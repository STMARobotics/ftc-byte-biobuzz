package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.teamcode.globals.constants.*;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;


import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Gate {
    private final Servo gate; //double check is the right servo
    private final Telemetry telemetry;

    public Gate(HardwareMap hardwareMap, Telemetry telemetry ){
        this.gate = hardwareMap.get(Servo.class, "gate");//pretty sure this should be a constant
        this.telemetry = telemetry;
    }
    public void openGate(){
        gate.setPosition(open);//add value to constants later
    }
    public void closeGate(){
        gate.setPosition(closed);//add value to constants later
    }
}
