package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.teamcode.globals.constants.*;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.hardware.servos.ServoEx;


import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Gate {
    private final ServoEx gate; //double check is the right servo
    private final Telemetry telemetry;

    public Gate(HardwareMap hardwareMap, Telemetry telemetry ){
        this.gate = new ServoEx(hardwareMap, GATE_SERVO);//pretty sure this should be a constant
        this.telemetry = telemetry;
    }

    public void open(){
        gate.set(GATE_OPEN);//add value to constants later
    }
    public void close(){
        gate.set(GATE_CLOSED);//add value to constants later
    }
}
