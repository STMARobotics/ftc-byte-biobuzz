package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.teamcode.globals.Constants.*;
import static org.firstinspires.ftc.teamcode.pedroPathing.Constants.*;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometery.Pose;
import com.pedropathing.paths.PathBuilder;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.hardware.motors.MotorEx;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;


public class Drive extends SubsystemBase{
     private final Robot robot = Robot.getInstance();
     private Follower follower;
     private Pose currentPose = new Pose();

    public double getForward() {
        return forward;
    }

    public double getStrafe(){
        return strafe;
    }

    public double getTurn(){
        return turn;
    }

    private double forward;
    private double strafe;
    private double turn;

    private MotorEx frontRightMotor;
    private MotorEx frontLeftMotor;
    private MotorEx backLeftMotor;
    private MotorEx backRightMotor;


    public Drive(HardwareMap hwMap){
        follower = createFollower(hwMap);
        this.frontRightMotor = new MotorEx(hwMap, FRONT_RIGHT_MOTOR);
        this.frontLeftMotor = new MotorEx(hwMap, FRONT_LEFT_MOTOR);
        this.backLeftMotor = new MotorEx(hwMap, BACK_LEFT_MOTOR);
        this.frontRightMotor = new MotorEx(hwMap, BACK_RIGHT_MOTOR);
    }

    public void driveFieldCentric(double forward, double strafe, double turn){
        this.forward = forward;
        this.strafe = strafe;
        this.turn = -turn;

        robot.telemetryData.addData("Heading", this.getHeading());
        robot.telemetryData.addeData("Drive - Forward", this.getForward());
        robot.telemetryData.addData("Drive - Strafe", this.getStrafe());
        robot.telemetryData.addData("Drive - Turn", this.getTurn());
        this.follower.setTeleOpDrive(this.forward, this.strafe, this.turn, true);
        follower.update();
        currentPose = follower.getPose();


         public PathBuilder pathBuilder(){
         return follower.pathBuilder();
         }

         public void resetLocalization(){
         pose restPose = new Pose();
         follower.setStartingPoint(resetPose);
         follower.setPose(resetPose);
        }

        public double getHeading(){
            return robot.imu.getRobotYawPitchRollAngles().getYaw(BNO055IMU.AngleUnit.DEGREES);
        }

        @Override
        public void periodic(){
         follower.update();
         currentPose = follower.getPose();
         }
    }


}
