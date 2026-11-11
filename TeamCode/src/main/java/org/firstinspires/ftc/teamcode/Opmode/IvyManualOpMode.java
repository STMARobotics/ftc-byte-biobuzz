package org.firstinspires.ftc.teamcode.Opmode;

import static com.pedropathing.ivy.Scheduler.schedule;

import com.pedropathing.ivy.Scheduler;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.globals.Robot;

@TeleOp(name="IvyManualOpMode")
public class IvyManualOpMode extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        Scheduler.reset();

        Robot.getInstance().init(this);

        waitForStart();

//        Schedule the sequence when the OpMode starts

        schedule(Robot.getInstance().drive.driveRobotCentric());
        while (opModeIsActive()) {
            // Run the scheduler each loop
            Scheduler.execute();
        }
    }
}
