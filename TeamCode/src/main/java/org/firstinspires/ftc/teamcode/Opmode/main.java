package org.firstinspires.ftc.teamcode.Opmode;

//import com.pedropathing.geometry.Pose;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.seattlesolvers.solverslib.command.CommandOpMode;

import com.seattlesolvers.solverslib.gamepad.GamepadEx;
import com.seattlesolvers.solverslib.util.TelemetryData;

import org.firstinspires.ftc.teamcode.globals.constants;
import org.firstinspires.ftc.teamcode.globals.Robot;

@TeleOp(name = "Driver Controlled")
public class main extends CommandOpMode {

    public GamepadEx driverGamepad;
    public GamepadEx operatorGamepad;

    TelemetryData telemetryData = new TelemetryData(telemetry);

    private final Robot robot = Robot.getInstance();

    @Override
    public void initialize() {
        // Must have for all opModes
        constants.OP_MODE_TYPE = constants.OpModeType.TELEOP;

        // Resets the command scheduler
        super.reset();

        // Initialize the robot (which also registers subsystems, configures CommandScheduler, etc.)
        robot.init(this);
    }

    @Override
    public void run() {
        // DO NOT REMOVE ANY LINES BELOW! Runs the command scheduler and updates telemetry
        super.run();
        telemetryData.update();
    }
}