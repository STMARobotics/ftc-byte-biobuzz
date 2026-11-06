package org.firstinspires.ftc.teamcode.commands;
import com.seattlesolvers.solverslib.command.CommandBase;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
public class IntakeStopCommand extends CommandBase {
    private Intake intake;

    public void IntakeStopCommand(Intake intake) {
        this.intake = intake;
        addRequirements(this.intake);
    }

    @Override
    public void execute() { intake.stopIntake();
    }

    @Override
    public boolean isFinished() { return super.isFinished();
    }
}
