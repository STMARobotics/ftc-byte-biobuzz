package org.firstinspires.ftc.teamcode.commands;

import com.seattlesolvers.solverslib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.subsystems.Intake;

public class IntakeCommand extends InstantCommand{
    private Intake intake;



    public void IntakeInCommand(Intake intake){
        this.intake = intake;
        addRequirements(this.intake);
    }

    public void IntakeStopCommand(Intake intake){
        this.intake = intake;
        addRequirements(this.intake);
    }

    @Override
    public void execute(){
        intake.runIntake();
    }




}
