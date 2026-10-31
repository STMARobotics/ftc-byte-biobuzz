package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.teamcode.globals.Constants.*;

import androidx.core.math.MathUtils;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.controller.PIDController;
import com.seattlesolvers.solverslib.hardware.motors.Motor;
import com.seattlesolvers.solverslib.hardware.motors.MotorEx;
import com.seattlesolvers.solverslib.hardware.servos.ServoEx;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Turret extends SubsystemBase {
private final MotorEx turretMotor;
private final ServoEx hoodServo;
private final Limelight limelight;

private double lastAppliedPower = 0.0;//i have no idea what this does yet

private final PIDController pidController = new PIDController(TURRET_KP,0.0,TURRET_KD);

public Turret(HardwareMap hardwareMap){
    this.turretMotor = new MotorEx(hardwareMap, TURRET_MOTOR);
    this.hoodServo = new ServoEx(hardwareMap, HOOD_SERVO);


    limelight = new Limelight(hardwareMap);

    turretMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
}
public void setTurretPower(double power){
    lastAppliedPower = MathUtils.clamp(power, -TURRET_MAX_POWER, TURRET_MAX_POWER);
    turretMotor.set(lastAppliedPower);
}
public void stopTurret(){
    lastAppliedPower = 0.0;
    turretMotor.set(0);
}
public void goToHome(){
    turretMotor.setTargetPosition(TURRET_HOME);
    setTurretPower(2);//figure out later
    if (turretMotor.atTargetPosition()){
        stopTurret();
    }
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
    hoodServo.set(HOOD_HOME);//random num
}
public void telemetry(Telemetry telemetry){
    telemetry.addData("Turret Applied Power", lastAppliedPower);
    telemetry.addData("Hood Servo Position", hoodServo.getRawPosition());
}
}