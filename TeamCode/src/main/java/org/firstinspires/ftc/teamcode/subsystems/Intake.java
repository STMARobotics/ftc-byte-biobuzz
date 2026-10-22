package org.firstinspires.ftc.teamcode.subsystems;

import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import static org.firstinspires.ftc.teamcode.globals.constants.INTAKE_SPEED;
import static org.firstinspires.ftc.teamcode.globals.constants.INTAKE_STOP;
public class Intake extends SubsystemBase {
    private final Motor intake;
    public Intake (HardwareMap hardwareMap) {
        intake = new Motor(hardwareMap, "INTAKE_MOTOR");
        intake.setInverted(true);

    }
    public void runIntake() {
        intake.set(INTAKE_SPEED);

    }

    public void vomit() {
        intake.set(-INTAKE_SPEED);

    }
    public void stopIntake() {
        intake.set(INTAKE_STOP);

    }

}

