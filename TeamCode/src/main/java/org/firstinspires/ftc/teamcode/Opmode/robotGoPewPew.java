package org.firstinspires.ftc.teamcode.Opmode;
//yeah this actully sucks

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.seattlesolvers.solverslib.util.TelemetryData;


@TeleOp(name = "robotGoPewPew", group = "Linear OpMode")
public class robotGoPewPew extends LinearOpMode {

    private DcMotorEx spinnyMotor = null;

    @Override
    public void runOpMode() {
//        TelemetryData telemetryData = new TelemetryData(telemetry);

        spinnyMotor = hardwareMap.get(DcMotorEx.class, "FlywheelMotor");
        spinnyMotor.setDirection(DcMotor.Direction.REVERSE);
        spinnyMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        waitForStart();

        while (opModeIsActive()) {
            if (gamepad1.a) {
                spinnyMotor.setPower(1);

                double currentTicksPerSecond = spinnyMotor.getVelocity();

                // 2. Get the ticks per revolution for your specific motor

                // 3. Convert ticks per second back to RPM
                double currentRPM = (currentTicksPerSecond / 28.0) * 60.0;

                // 4. Display the RPM on the Driver Station telemetry
                telemetry.addData("Motor RPM", currentRPM);
                telemetry.addData("op mode active", true);
            } else {
                spinnyMotor.setPower(0.0);
                telemetry.addData("op mode active", false);
            }
            telemetry.update();
        }
    }
}