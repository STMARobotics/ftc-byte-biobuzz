package org.firstinspires.ftc.teamcode.commands;

import com.seattlesolvers.solverslib.command.CommandBase;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.subsystems.*;

public class AutoShootCommand extends CommandBase {
            private final Gate gate;
            private final Limelight limelight;
            private final Turret turret;
            private final Shooter shooter;
            private final Telemetry telemetry;

            public AutoShootCommand(Gate gate, Limelight limelight, Turret turret, Shooter shooter,  Telemetry telemetry){
                this.gate = gate;
                this.limelight = limelight;
                this.turret = turret;
                this.shooter = shooter;
                this.telemetry = telemetry;

                addRequirements( gate,turret,limelight,shooter);//idk ill deal with this later
            }
    @Override
    public void initialize(){
        //  tell distance
        limelight.getTargetOffset();

        //  Shooter looks up speed and hood
        //
        //  set turret offset
    }
    @Override
    public void execute(){
//   Check Limelight to see if in tolerance (update values if needed)
//  Check if turret is aimed right
//  Check it flywheel at Speed
//
//  If yes
//    open gate
//  no
//    continue
//
//Release button cancel

    }

}

