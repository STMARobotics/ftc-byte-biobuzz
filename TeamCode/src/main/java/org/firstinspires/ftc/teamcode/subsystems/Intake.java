package org.firstinspires.ftc.teamcode.subsystems;

import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import static org.firstinspires.ftc.teamcode.globals.constants.*;

// Give the intake the motor that powers it 
public class Intake extends SubsystemBase {
    private final Motor intake;
    public Intake (HardwareMap hardwareMap) {
        intake = new Motor(hardwareMap, "INTAKE_MOTOR");
        intake.setInverted(true);

    }
    // This runs the intake.
    public void runIntake() {
        intake.set(INTAKE_SPEED);

    }
    // Reverse the intake so it spits out polllen.
    public void vomit() {
        intake.set(-INTAKE_SPEED);

    }
    // Fully stops the intake
    public void stopIntake() {
        intake.set(INTAKE_STOP);

    }

}

