package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.teamcode.globals.constants.*;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.seattlesolvers.solverslib.hardware.servos.ServoEx;


import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Kicker {
    private final ServoEx kicker; //double check is the right servo
    private final Telemetry telemetry;

    public Kicker(HardwareMap hardwareMap, Telemetry telemetry ){
        this.kicker = new ServoEx(hardwareMap, KICKER_SERVO);
        this.telemetry = telemetry;
    }
    public void down(){
        kicker.set(KICKER_ON_FLOOR);//add value to constants later
    }
    public void store(){
        kicker.set(KICKER_STORED);//add value to constants later
    }
}
