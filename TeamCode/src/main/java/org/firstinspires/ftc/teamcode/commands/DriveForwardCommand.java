package org.firstinspires.ftc.teamcode.commands;

import com.qualcomm.robotcore.util.ElapsedTime;
import com.seattlesolvers.solverslib.command.CommandBase;
import org.firstinspires.ftc.teamcode.subsystems.Drive;

public class DriveForwardCommand extends CommandBase {
    private final Double driveTime;
    private final Drive drive;
    private final Double driveSpeed;
    private ElapsedTime timer;

    public DriveForwardCommand(Drive drive, Double driveTime, Double speed) {
        this.drive = drive;
        this.driveTime = driveTime;
        this.driveSpeed = speed;

        addRequirements(this.drive);
    }

    @Override
    public void initialize() {
        this.timer = new ElapsedTime();
        this.timer.reset();
    }

    @Override
    public void execute() {
        this.drive.driveRobotCentric(this.driveSpeed, 0,0);
    }

    @Override
    public void end(boolean interrupted) {
        this.drive.stop();
    }

    @Override
    public boolean isFinished() {
        return timer.seconds() >= driveTime;
    }
}