package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.teamcode.globals.Constants.*;

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
    /**
     * Drivetrain subsystem. Encapsulates the details of how the drivetrain works.
     */
    private final Robot robot = Robot.getInstance();
    private final Follower follower;
    private final MecanumDrive mecanumDrive;

    /**
     * Allows robot to go forward
     * @return
     */
    public double getForward() {
        return forward;
    }

    /**
     * Allows robot to strafe
     * @return
     */
    public double getStrafe() {
        return strafe;
    }

    /**
     * Allows the robot to turn
     * @return
     */
    public double getTurn() {
        return turn;
    }
    // Store the movements inputs
    private double forward;
    private double strafe;
    private double turn;

    //Declare the four motors used to control mecanum or omnidirection
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

    /**
     * Controls the robot using field-centric driving mechanics
     * @param forward
     * @param strafe
     * @param turn
     */
    public void driveFieldCentric(double forward, double strafe, double turn) {
        this.forward = forward;
        this.strafe = strafe;
        this.turn = turn;
        this.follower.manual(forward, strafe, turn);
        this.follower.update();
    }

    /**
     * Drive the robot centric manner
     * @param forward
     * @param strafe
     * @param turn
     */
    public void driveRobotCentric(double forward, double strafe, double turn) {
        this.forward = -forward;
        this.strafe = -strafe;
        this.turn = -turn;
        DrivePowers  powers = ManualDrive.fieldCentric(
                forward,
                strafe,
                turn,
                follower.pose().heading()
        );

//        DrivePowers powers = ManualDrive.fieldCentric(
//                forward,
//                strafe,
//                turn,
//                follower.pose().heading()
//        );

        robot.telemetryData.addData("Heading", this.follower.pose().heading());
        robot.telemetryData.addData("Drive - Forward", this.getForward());
        robot.telemetryData.addData("Drive - Strafe", this.getStrafe());
        robot.telemetryData.addData("Drive - Turn", this.getTurn());

        follower.manual(powers);
        follower.update();
        mecanumDrive.driveRobotCentric(this.strafe, this.turn, this.forward);
    }

    /**
     * Add drivetrain telemetry data
     * @param telemetry
     */
    public void telemetry(Telemetry telemetry) {
        // Log the position to the telemetry
    }

    /**
     * Stops the drivetrain
     */
    public void stop() {
        this.driveFieldCentric(0,0,0);
    }

    /**
     * Gets the front right motor of the robot
     * @return
     */
    public MotorEx getFrontRightMotor() {
        return frontRightMotor;
    }

    /**
     * Gets the front left motor of the robot
     * @return
     */
    public MotorEx getFrontLeftMotor() {
        return frontLeftMotor;
    }

    /**
     * Gets the back left motor of the robot
     * @return
     */
    public MotorEx getBackLeftMotor() {
        return backLeftMotor;
    }

    /**
     * Gets the back right motor of the robot
     * @return
     */
    public MotorEx getBackRightMotor() {
        return backRightMotor;
    }
}