package org.firstinspires.ftc.teamcode.Opmode;

import static com.pedropathing.ivy.Scheduler.schedule;

import com.pedropathing.ivy.Scheduler;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.globals.Constants;
import org.firstinspires.ftc.teamcode.globals.Robot;
@Autonomous(name="IvyAutoOpMode", preselectTeleOp = "IvyManualOpMode")
public class IvyAutoOpMode extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Constants.OP_MODE_TYPE = Constants.OpModeType.AUTO;
        Scheduler.reset();
        Robot.getInstance().init(this);

        waitForStart();

        schedule(Robot.getInstance().drive.driveForward(1.5, .5));
        while (opModeIsActive()) {
            // Run the scheduler each loop
            Scheduler.execute();
        }
    }
}
