package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.teamcode.globals.constants.*;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;


import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Kicker {
    private final Servo kicker; //double check is the right servo
    private final Telemetry telemetry;

    public Kicker(HardwareMap hardwareMap, Telemetry telemetry ){
        this.kicker = hardwareMap.get(Servo.class, "kicker");//pretty sure this should be a constant
        this.telemetry = telemetry;
    }
    public void kickerOn(){
        kicker.setPosition(onFloor);//add value to constants later
    }
    public void kickerStored(){
        kicker.setPosition(stored);//add value to constants later
    }
}
