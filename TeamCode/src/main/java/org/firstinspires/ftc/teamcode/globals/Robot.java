package org.firstinspires.ftc.teamcode.globals;


import com.pedropathing.follower.Follower;
import com.qualcomm.hardware.sparkfun.SparkFunOTOS;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.seattlesolvers.solverslib.util.TelemetryData;

import org.firstinspires.ftc.teamcode.controls.Bindings;
import org.firstinspires.ftc.teamcode.subsystems.Drive;
import org.firstinspires.ftc.teamcode.commands.DriverControlCommand;


public class Robot extends com.seattlesolvers.solverslib.command.Robot {

    // Components
    public IMU imu;

    private static final Robot instance = new Robot();
    public TelemetryData telemetryData;

    // Subsystems
    public Drive drive;
    public SparkFunOTOS otos;


    public static Robot getInstance() {
        return instance;
    }

    public void init(OpMode opMode) {
        reset();
        this.telemetryData = new TelemetryData(opMode.telemetry);
        HardwareMap hwMap = opMode.hardwareMap;
        Bindings.init(opMode.gamepad1, opMode.gamepad2);
//        imu = hwMap.get(IMU.class, "imu");
//        imu.initialize(new IMU.Parameters(new RevHubOrientationOnRobot(RevHubOrientationOnRobot.LogoFacingDirection.UP, RevHubOrientationOnRobot.UsbFacingDirection.FORWARD)));
//        this.otos = (SparkFunOTOS) hwMap.get("Spark");
        Follower follower = org.firstinspires.ftc.teamcode.pedroPathing.Constants.create(hwMap);
        this.drive = new Drive(hwMap, follower);

        register(drive);

        if (Constants.OP_MODE_TYPE == Constants.OpModeType.TELEOP) {
            System.out.println("MFM ****************  OP MODE TELEOP");
            bindCommands();
        }

    }


    public void bindCommands() {
//        bindings.getDriverOptionKey().whenPressed(
//                new InstantCommand(() -> {
//                    imu.resetYaw();
//                }));

        DriverControlCommand dcc = new DriverControlCommand(drive,
                Bindings.getDriverLeftY(),
                Bindings.getDriverLeftX(),
                Bindings.getDriverRightX(),
                Bindings.getDriverRightTrigger()
        );

        this.drive.setDefaultCommand(dcc);

    }
}