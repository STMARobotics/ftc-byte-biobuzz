package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Shooter extends SubsystemBase {
    private final DcMotorEx flywheelMotor;
    private double targetRPM;

    public Shooter(HardwareMap hardwareMap){
        flywheelMotor = hardwareMap.get(DcMotorEx.class, "flywheelMotor");
    }
    public void setRPM(double RPM){
        flywheelMotor.setVelocity(RPM*28/60);//will need to figure out if want to use this number later
        RPM=targetRPM;
    }
    public void stop(){
        flywheelMotor.setPower(0);
        targetRPM =0;
    }
    public boolean flywheelReady(){
        return  Math.abs(getRPM() - targetRPM) <= 75;//check this num
    }
    public double getRPM(){
        return flywheelMotor.getVelocity()/28.0*60.0;//check num
    }
    public void telemetry(Telemetry telemetry){
        telemetry.addData("Flywheel RPM", flywheelMotor.getVelocity()/28.0*60.0);
        telemetry.addData("Target RPM", targetRPM);
    }

}
