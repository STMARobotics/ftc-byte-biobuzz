package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.teamcode.globals.constants.*;

import com.pedropathing.drivetrain.DrivePowers;
import com.pedropathing.follower.Follower;
import com.pedropathing.follower.ManualDrive;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.drivebase.MecanumDrive;
import com.seattlesolvers.solverslib.hardware.motors.MotorEx;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.globals.Robot;

public class Drive extends SubsystemBase {

    private final Robot robot = Robot.getInstance();
    private final Follower follower;
    private final MecanumDrive mecanumDrive;

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

    private MotorEx frontRightMotor;
    private MotorEx frontLeftMotor;
    private MotorEx backLeftMotor;
    private MotorEx backRightMotor;

    public Drive(HardwareMap hwMap, Follower follower){
        this.follower = follower;
        this.frontRightMotor = new MotorEx(hwMap, FRONT_RIGHT_MOTOR);
        this.frontLeftMotor = new MotorEx(hwMap, FRONT_LEFT_MOTOR);
        this.backLeftMotor = new MotorEx(hwMap, BACK_LEFT_MOTOR);
        this.backRightMotor = new MotorEx(hwMap, BACK_RIGHT_MOTOR);

        this.backRightMotor.setInverted(true);
        mecanumDrive = new MecanumDrive(frontLeftMotor, frontRightMotor, backLeftMotor, backRightMotor);
    }

    public void driveFieldCentric(double forward, double strafe, double turn) {
        this.forward = forward;
        this.strafe = strafe;
        this.turn = turn;
        this.follower.manual(forward, strafe, turn);
        this.follower.update();
    }

    public void driveRobotCentric(double forward, double strafe, double turn){
        this.forward = forward;
        this.strafe = strafe;
        this.turn = -turn;

//        DrivePowers powers = ManualDrive.fieldCentric(
//                forward,
//                strafe,
//                turn,
//                follower.pose().heading()
//        );

//        robot.telemetryData.addData("Heading", this.follower.pose().heading());
        robot.telemetryData.addData("Drive - Forward", this.getForward());
        robot.telemetryData.addData("Drive - Strafe", this.getStrafe());
        robot.telemetryData.addData("Drive - Turn", this.getTurn());
//        follower.manual(powers);
//        follower.update();

        System.out.println("MFM **************** in Drive Robot Centric ");
        mecanumDrive.driveRobotCentric(strafe, forward, turn);
    }
    public void telemetry(Telemetry telemetry) {
        // Log the position to the telemetry
    }

    public void stop() {
        this.driveFieldCentric(0,0,0);
    }


    public MotorEx getFrontRightMotor() {
        return frontRightMotor;
    }

    public MotorEx getFrontLeftMotor() {
        return frontLeftMotor;
    }

    public MotorEx getBackLeftMotor() {
        return backLeftMotor;
    }

    public MotorEx getBackRightMotor() {
        return backRightMotor;
    }
}