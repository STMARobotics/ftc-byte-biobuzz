package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.teamcode.globals.Constants.FLYWHEEL_MOTOR;
import static org.firstinspires.ftc.teamcode.globals.Constants.linearDistance;
import static org.firstinspires.ftc.teamcode.globals.Constants.time;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.hardware.motors.MotorEx;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Shooter extends SubsystemBase {
    private final MotorEx flywheelMotor;
    private double targetRPM;

    public Shooter(HardwareMap hardwareMap){
        this.flywheelMotor = new MotorEx(hardwareMap, FLYWHEEL_MOTOR);
    }
    public void setRPM(double RPM){
        flywheelMotor.setVelocity(RPM*linearDistance/time);
        RPM=targetRPM;
    }
    public void stop(){
        flywheelMotor.setVelocity(0);
        targetRPM =0;
    }
    public boolean isFlywheelReady(){
        return  Math.abs(getRPM() - targetRPM) <= 75;//check this num
    }
    public double getRPM(){
        return flywheelMotor.getVelocity()/linearDistance*time;
    }
    public void telemetry(Telemetry telemetry){
        telemetry.addData("Flywheel RPM", flywheelMotor.getVelocity()/linearDistance*time);
        telemetry.addData("Target RPM", targetRPM);
    }

}
