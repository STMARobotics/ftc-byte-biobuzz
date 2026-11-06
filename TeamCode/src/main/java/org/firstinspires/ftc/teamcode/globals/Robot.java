package org.firstinspires.ftc.teamcode.globals;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.hardware.sparkfun.SparkFunOTOS;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.seattlesolvers.solverslib.command.InstantCommand;
import com.seattlesolvers.solverslib.util.TelemetryData;

import org.firstinspires.ftc.teamcode.commands.DriverControlCommand;
import org.firstinspires.ftc.teamcode.commands.IntakeInCommand;
import org.firstinspires.ftc.teamcode.commands.IntakeStopCommand;
import org.firstinspires.ftc.teamcode.commands.IntakeVomitCommand;
import org.firstinspires.ftc.teamcode.controls.bindings;
import org.firstinspires.ftc.teamcode.subsystems.Drive;
import org.firstinspires.ftc.teamcode.subsystems.Intake;



public class Robot extends com.seattlesolvers.solverslib.command.Robot {

    // Components
    public IMU imu;

    private static final Robot instance = new Robot();
    public TelemetryData telemetryData;

    // Subsystems
    public Drive drive;
    public SparkFunOTOS otos;

    public Intake intake;


    public static Robot getInstance() {
        return instance;
    }

    public void init(OpMode opMode) {
        reset();
        this.telemetryData = new TelemetryData(opMode.telemetry);
        HardwareMap hwMap = opMode.hardwareMap;
        bindings.init(opMode.gamepad1, opMode.gamepad2);
        imu = hwMap.get(IMU.class, "imu");
        imu.initialize(new IMU.Parameters(new RevHubOrientationOnRobot(RevHubOrientationOnRobot.LogoFacingDirection.UP, RevHubOrientationOnRobot.UsbFacingDirection.FORWARD)));
        this.drive = new Drive(hwMap);
        this.otos = (SparkFunOTOS) hwMap.get("Spark");

        register(drive);

        if (constants.OP_MODE_TYPE == constants.OpModeType.TELEOP) {
            bindCommands();
        }

    }


    public void bindCommands() {
        bindings.getDriverOptionKey().whenPressed(
                new InstantCommand(() -> {
                    imu.resetYaw();
                }));

        DriverControlCommand dcc = new DriverControlCommand(drive,
                bindings.getDriverLeftY(),
                bindings.getDriverLeftX(),
                bindings.getDriverRightX(),
                bindings.getDriverRightTrigger()
        );

        this.drive.setDefaultCommand(dcc);

    bindings.getDriverRightBumper().whenPressed(new IntakeInCommand());
    bindings.getDriverRightBumper().whenInactive(new IntakeStopCommand());
    bindings.getDriverLeftBumper().whenPressed(new IntakeVomitCommand(intake));
    bindings.getDriverLeftBumper().whenInactive(new IntakeStopCommand());


    }
}