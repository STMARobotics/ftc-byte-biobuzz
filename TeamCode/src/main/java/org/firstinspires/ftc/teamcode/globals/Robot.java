package org.firstinspires.ftc.teamcode.globals;


import static com.pedropathing.ivy.commands.Commands.instant;

import com.pedropathing.follower.Follower;
import com.pedropathing.ivy.Scheduler;
import com.qualcomm.hardware.sparkfun.SparkFunOTOS;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.controls.Bindings;
import org.firstinspires.ftc.teamcode.subsystems.Drive;
import org.firstinspires.ftc.teamcode.commands.DriverControlCommand;
import org.firstinspires.ftc.teamcode.subsystems.Intake;


public class Robot {

    // Components
    public IMU imu;

    private static final Robot instance = new Robot();
    public Telemetry telemetry;

    // Subsystems
    public Drive drive;
    public SparkFunOTOS otos;
    private Intake intake;


    public static Robot getInstance() {
        return instance;
    }

    public void init(OpMode opMode) {
        this.telemetry = opMode.telemetry;
        HardwareMap hwMap = opMode.hardwareMap;
        Bindings.init(opMode.gamepad1, opMode.gamepad2);
//        imu = hwMap.get(IMU.class, "imu");
//        imu.initialize(new IMU.Parameters(new RevHubOrientationOnRobot(RevHubOrientationOnRobot.LogoFacingDirection.UP, RevHubOrientationOnRobot.UsbFacingDirection.FORWARD)));
//        this.otos = (SparkFunOTOS) hwMap.get("Spark");
        Follower follower = org.firstinspires.ftc.teamcode.pedroPathing.Constants.create(hwMap);
        this.drive = new Drive(hwMap, follower);
        this.intake = new Intake(hwMap);

        if (Constants.OP_MODE_TYPE == Constants.OpModeType.TELEOP) {
            bindCommands();
        }

        Scheduler.schedule(drive.periodic(), intake.periodic());

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


        Bindings.getDriverRightBumper().whenPressed(()-> this.intake.runIntake());
        Bindings.getDriverRightBumper().whenReleased(()-> this.intake.stopIntake());

    }
}