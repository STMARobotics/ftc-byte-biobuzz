package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.teamcode.globals.Constants.*;

import com.pedropathing.follower.Follower;
import com.pedropathing.ivy.Command;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.controls.Bindings;
import org.firstinspires.ftc.teamcode.globals.Constants;
import org.firstinspires.ftc.teamcode.globals.Robot;

import java.util.function.DoubleSupplier;

public class Drive  {

    private final Robot robot = Robot.getInstance();
    private final Follower follower;

    public double getForward() {
        return forward;
    }
    public double getStrafe() {
        return strafe;
    }

    public double getTurn() {
        return turn;
    }

    private double forward;
    private double strafe;
    private double turn;

    private DcMotorEx frontRightMotor;
    private DcMotorEx frontLeftMotor;
    private DcMotorEx backLeftMotor;
    private DcMotorEx backRightMotor;

    public Drive(HardwareMap hwMap, Follower follower){
        this.follower = follower;
        this.frontRightMotor = hwMap.get(DcMotorEx.class, FRONT_RIGHT_MOTOR);
        this.frontLeftMotor = hwMap.get(DcMotorEx.class, FRONT_LEFT_MOTOR);
        this.backLeftMotor = hwMap.get(DcMotorEx.class, BACK_LEFT_MOTOR);
        this.backRightMotor = hwMap.get(DcMotorEx.class, BACK_RIGHT_MOTOR);
    }

    public void driveRobotCentric(double forward, double strafe, double turn) {
        this.forward = forward;
        this.strafe = strafe;
        this.turn = turn;

        follower.manual(forward, strafe, turn);
        follower.update();
    }
    public void telemetry(Telemetry telemetry) {
        // Log the position to the telemetry
    }

    public void stop() {
        this.driveRobotCentric(0,0,0);
    }


    public DcMotorEx getFrontRightMotor() {
        return frontRightMotor;
    }

    public DcMotorEx getFrontLeftMotor() {
        return frontLeftMotor;
    }

    public DcMotorEx getBackLeftMotor() {
        return backLeftMotor;
    }

    public DcMotorEx getBackRightMotor() {
        return backRightMotor;
    }

    public Command driveRobotCentric(){
        return Command.build()
                .requiring(this)
                .setExecute(() ->
                {
                    double forward = Bindings.getDriverLeftY().getAsDouble();
                    double strafe = Bindings.getDriverLeftX().getAsDouble();
                    double turn = Bindings.getDriverRightX().getAsDouble();
                    double triggerValue = Bindings.getDriverRightTrigger().getAsDouble();
                    double multiplier = (MINIMUM_SPEED + ((1 - MINIMUM_SPEED) * triggerValue));
                    this.driveRobotCentric(forward * multiplier, strafe * multiplier, turn * multiplier);
                });
    }

    public Command periodic(){
        return Command.build()
                .setExecute(() ->
                {
                    robot.telemetry.addData("Heading", this.follower.pose().heading());
                    robot.telemetry.addData("Drive - Forward", this.getForward());
                    robot.telemetry.addData("Drive - Strafe", this.getStrafe());
                    robot.telemetry.addData("Drive - Turn", this.getTurn());
                });

    }
}