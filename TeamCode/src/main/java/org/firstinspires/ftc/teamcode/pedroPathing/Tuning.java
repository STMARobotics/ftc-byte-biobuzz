package org.firstinspires.ftc.teamcode.pedroPathing;

import com.pedropathing.tuning.autotune.Procedure;
import com.pedropathing.tuning.autotune.Tuner;
import com.pedropathing.revhub.drivetrains.Mecanum;
import com.sun.tools.javac.code.Attribute;

import org.firstinspires.ftc.teamcode.globals.Robot;
import org.firstinspires.ftc.teamcode.pedroPathing.Procedures.ForesightTuner;
import org.firstinspires.ftc.teamcode.pedroPathing.Procedures.*;
public class Tuning {
    /**
     * Creates a tuning procedure just for the OTOS
     * @return
     */
    @Tuner
    public static Procedure otosTuner() {
        return new OtosTuner();
    }

    /**
     * Create a tuning procedure just for the mecanum
     * @return
     */
    @Tuner
    public static Procedure mecanumTuner() {
        return new MecanumTuner();
    }

    /**
     * Creates a tuning procedure just for the foresight tuner
     * @return
     */
    @Tuner
    public static Procedure foresightTuner(){
        return new ForesightTuner(Constants::createLocalizer, Constants::createDrivetrain);
    }

}