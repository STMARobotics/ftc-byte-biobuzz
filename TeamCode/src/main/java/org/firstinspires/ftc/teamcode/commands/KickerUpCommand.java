package org.firstinspires.ftc.teamcode.commands;
import com.seattlesolvers.solverslib.command.CommandBase;
import com.seattlesolvers.solverslib.command.Subsystem;

import org.firstinspires.ftc.teamcode.subsystems.*;

public class KickerUpCommand extends CommandBase {
    private Kicker kicker;

    public void KickerUpCommand(Kicker kicker) {
        this.kicker = kicker;
        addRequirements((Subsystem) this.kicker);
    }


    @Override
    public void execute() {
        kicker.store();
    }


    @Override
    public boolean isFinished() {
        return super.isFinished();
    }

}