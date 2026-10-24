package org.firstinspires.ftc.teamcode.commands;

import com.seattlesolvers.solverslib.command.CommandBase;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.subsystems.Shooter;

public class ManualShoot extends CommandBase {
    private final Shooter shooter;
    public ManualShoot(Shooter shooter){
        this.shooter= shooter;
    }
    @Override
    public void execute(){
        shooter.setRPM(5);
    }
}
