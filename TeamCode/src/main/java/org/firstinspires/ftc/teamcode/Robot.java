package org.firstinspires.ftc.teamcode;

import android.renderscript.ScriptGroup;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.hardware.sparkfun.SparkFunOTOS;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.seattlesolvers.solverslib.util.TelemetryData;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Robot extends com.seattlesolvers.solverslib.command.Robot {
    //Components
    public IMU imu;

    private static final Robot instance = new Robot();
    public TelemetryData telemetryData;

    //Subsystem
    public Drive drive;
    public SparkFunOTOS otos;


    public static Robot getInstance() {
        return instance;
    }

    public void init(OPMode opMode) {
        reset();
        this.telemetryData = new TelemetryData(opMode.telemetry);
        HardwareMap hwMap = opMode.hardwareMap;
        Bindings.init(opMode.gamepad1, opMode.gamepad2);
        imu = hwMap.get(IMU.class, "imu");
        imu.initialize((new IMU.Parameters(new RevHubOrientationOnRobot(RevHubOrientationOnRobot.LogoFacingDirection.UP, RevHubOrientationOnRobot.UsbFacingDirection.FORWARD))));
        this.drive
    }


}
