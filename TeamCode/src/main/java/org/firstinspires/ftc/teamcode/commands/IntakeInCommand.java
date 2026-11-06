package org.firstinspires.ftc.teamcode.commands;
import com.seattlesolvers.solverslib.command.CommandBase;
import org.firstinspires.ftc.teamcode.subsystems.Intake;

public class IntakeInCommand extends CommandBase {
    private Intake intake;

    public void IntakeInCommand(Intake intake) {
        this.intake = intake;
        addRequirements(this.intake);
    }

    @Override
    public void execute(){
        intake.runIntake();
    }

    @Override
    public boolean isFinished() {
        return super.isFinished();
    }
}