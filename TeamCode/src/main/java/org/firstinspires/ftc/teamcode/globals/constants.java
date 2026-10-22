package org.firstinspires.ftc.teamcode.globals;

public class constants {
    public enum OpModeType {
        AUTO,
        TELEOP
    }
    public enum AllianceColor {
        RED,
        BLUE
    }

    public static OpModeType OP_MODE_TYPE;
    public static AllianceColor ALLIANCE_COLOR = AllianceColor.BLUE;
    public static final double MINIMUM_SPEED = 0.5;

    // Hardware Names
    public static final String FRONT_RIGHT_MOTOR = "FrontRightMotor";
    public static final String FRONT_LEFT_MOTOR = "FrontLeftMotor";
    public static final String BACK_LEFT_MOTOR = "BackLeftMotor";
    public static final String BACK_RIGHT_MOTOR = "BackRightMotor";

    public static final String FLYWHEEL_MOTOR ="FlywheelMotor";

    public static final int LIMELIGHT_POLL_HZ = 90; // check num
    public static final int BLUE_PIPELINE = 0;
    public static final int RED_PIPELINE = 1;

    public static final double TURRET_KP = 0.03;
    public static final double TURRET_KD = 0.001;
    public static final double TURRET_MAX_POWER = 0.65;
    public static final double DEAD_BAND_DEG = 3.0; // magic num


}