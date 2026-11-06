package org.firstinspires.ftc.teamcode.subsystems;

import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import static org.firstinspires.ftc.teamcode.globals.constants.*;

// Give the intake the motor that powers it 
public class Intake extends SubsystemBase {
    private final Motor intake;

    /**
     * Gives intake a motor and defines it
     * @param hardwareMap
     */
    public Intake (HardwareMap hardwareMap) {
        intake = new Motor(hardwareMap, "INTAKE_MOTOR");
        intake.setInverted(true);

    }

    /**
     * Runs intake
     */
    public void runIntake() {
        intake.set(INTAKE_SPEED);

    }

    /**
     * Vomits out pollen / reverse intake
     */
    public void vomit() {
        intake.set(-INTAKE_SPEED);

    }

    /**
     * Stops the intake
     */
    public void stopIntake() {
        intake.set(INTAKE_STOP);

    }

}

