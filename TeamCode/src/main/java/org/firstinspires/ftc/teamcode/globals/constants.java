package org.firstinspires.ftc.teamcode.globals;

import com.qualcomm.robotcore.hardware.Servo;

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
    //drive subsystem
    public static final String FRONT_RIGHT_MOTOR = "FrontRightMotor";
    public static final String FRONT_LEFT_MOTOR = "FrontLeftMotor";
    public static final String BACK_LEFT_MOTOR = "BackLeftMotor";
    public static final String BACK_RIGHT_MOTOR = "BackRightMotor";

//    shooter constants
    public static final String FLYWHEEL_MOTOR ="FlywheelMotor";

//    limelight constants
    public static final int LIMELIGHT_POLL_HZ = 90; // check num
    public static final int BLUE_PIPELINE = 0;
    public static final int RED_PIPELINE = 1;

//    turret constants
    public static final double TURRET_KP = 0.00;// made up num
    public static final double TURRET_KD = 0.000;// made up num
    public static final double TURRET_MAX_POWER = 0.60;// made up num
    public static final double DEAD_BAND_DEG = 3.0; // made up num

//  Gate constants
    public static final String GATE_SERVO = "Gate";
    public static final int GATE_OPEN = 0; //DO NOT RUN THIS THE NUMBER IS COMPLETLY MADE UP
    public static final int GATE_CLOSED = 0; //DO NOT RUN THIS THE NUMBER IS COMPLETLY MADE UP

//   kicker constants
     public static final String KICKER_SERVO  = "Kicker";
    public static final int KICKER_ON_FLOOR = 0; //DO NOT RUN THIS THE NUMBER IS COMPLETLY MADE UP
    public static final int KICKER_STORED = 0; //DO NOT RUN THIS THE NUMBER IS COMPLETLY MADE UP



}