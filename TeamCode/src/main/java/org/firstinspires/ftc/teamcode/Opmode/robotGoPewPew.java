package org.firstinspires.ftc.teamcode.Opmode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "robotGoPewPew", group = "Linear OpMode")
public class robotGoPewPew extends LinearOpMode {

    private DcMotor spinnyMotor = null;

    @Override
    public void runOpMode() {
        spinnyMotor = hardwareMap.get(DcMotor.class, "FlywheelMotor");
        spinnyMotor.setDirection(DcMotor.Direction.REVERSE);
        spinnyMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        waitForStart();

        while (opModeIsActive()) {
            if (gamepad1.a) {
                spinnyMotor.setPower(2.0);
            } else {
                spinnyMotor.setPower(0.0);
            }        }
    }
}