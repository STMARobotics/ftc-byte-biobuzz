package org.firstinspires.ftc.teamcode.commands;
import com.seattlesolvers.solverslib.command.CommandBase;
import com.seattlesolvers.solverslib.command.Subsystem;

import org.firstinspires.ftc.teamcode.subsystems.*;
public class KickerDownCommand extends CommandBase {
    private Kicker kicker;

    public void KickerDownCommand(Kicker kicker) {
        this.kicker = kicker;
        addRequirements((Subsystem) this.kicker);
    }

    @Override
    public void execute() {
        kicker.down();
    }


    @Override
    public boolean isFinished() {
        return super.isFinished();
    }

    ;
}