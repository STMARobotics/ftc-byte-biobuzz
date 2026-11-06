package org.firstinspires.ftc.teamcode.commands;
import com.seattlesolvers.solverslib.command.CommandBase;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
public class IntakeVomitCommand extends CommandBase {
    private final Intake intake;

    public IntakeVomitCommand(Intake intake) {
        this.intake = intake;
        addRequirements(this.intake);
    }

    @Override
    public void execute() { intake.vomit();
    }

    @Override
    public boolean isFinished() { return true;
    }
}


