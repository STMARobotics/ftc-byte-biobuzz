package org.firstinspires.ftc.teamcode.subsystems;

import androidx.core.math.MathUtils;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.controller.PIDController;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Turret extends SubsystemBase {
private final DcMotorEx turretMotor;
private final Servo hoodServo;
private final Limelight limelight;

private double lastAppliedPower = 0.0;//i have no idea what this does yet

private final PIDController pidController = new PIDController(TURRET_KP,0.0,TURRET_KD);//add to constants

public Turret(HardwareMap hardwareMap){
    turretMotor = hardwareMap.get(DcMotorEx.class, "turretMotor");
    hoodServo = hardwareMap.get(Servo.class, "hoodServo");
    limelight = new Limelight(hardwareMap);

    turretMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
}
public void setTurretPower(double power){
    lastAppliedPower = MathUtils.clamp(power, -TURRET_MAX_POWER, TURRET_MAX_POWER);// add later
    turretMotor.setPower(lastAppliedPower);
}
public void stopTurret(){
    lastAppliedPower = 0.0;
    turretMotor.setPower(0);
}
public void goToHome(){
    //figure out why you exist
}
public  void autoLockTurret(){
    double error = limelight.getTargetOffset();
    if (Double.isNaN(error)){
        stopTurret();
    }else {
        double output = pidController.calculate(error, 0.0);
        setTurretPower(output);
    }
}
public boolean isLockedOn(double thresholdDeg){
    double tx = limelight.getTargetOffset();
    if (Double.isNaN(tx)){
        return false;
    }
    return Math.abs(tx) <= thresholdDeg;
 }
public boolean isLockedOn(){
    return isLockedOn(DEAD_BAND_DEG);//will need to figure out what this is
}

public void hoodToHome(){
    hoodServo.setPosition(0.25);//random num
}
public void telemetry(Telemetry telemetry){
    telemetry.addData("Turret Applied Power", lastAppliedPower);
    telemetry.addData("Hood Servo Position", hoodServo.getPosition());
}
}