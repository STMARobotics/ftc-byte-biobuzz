package org.firstinspires.ftc.teamcode.subsystems;

import static com.pedropathing.ivy.commands.Commands.instant;
import static org.firstinspires.ftc.teamcode.globals.Constants.FLYWHEEL_MOTOR;
import static org.firstinspires.ftc.teamcode.globals.Constants.linearDistance;
import static org.firstinspires.ftc.teamcode.globals.Constants.time;

import com.pedropathing.ivy.Command;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.hardware.motors.MotorEx;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Shooter  {
    private final MotorEx flywheelMotor;
    private double targetRPM;
    private static double RPM_THRESHOLD = .05;

    public Shooter(HardwareMap hardwareMap){
        this.flywheelMotor = new MotorEx(hardwareMap, FLYWHEEL_MOTOR);
    }
    public void setRPM(double rpm){
        flywheelMotor.setVelocity(rpm*linearDistance/time);
        this.targetRPM = rpm;
    }
    public void stop(){
        flywheelMotor.setVelocity(0);
        targetRPM = 0;
    }
    public boolean isFlywheelReady(){
        return  Math.abs(getRPM() - targetRPM) <= 75;//check this num
    }
    public double getRPM(){
        return flywheelMotor.getVelocity()/linearDistance*time;
    }
    public void telemetry(Telemetry telemetry){
        telemetry.addData("Flywheel RPM", getRPM());
        telemetry.addData("Target RPM", targetRPM);
    }
    public Command stopCommand(){
        return instant(this::stop).requiring(this);
    }
    public Command spinUpCommand(int rpm){
        return Command.build()
                .setExecute(() -> {
                    this.setRPM(rpm);
                }).requiring(this);
    }
}
