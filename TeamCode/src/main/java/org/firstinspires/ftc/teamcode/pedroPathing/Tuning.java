package org.firstinspires.ftc.teamcode.pedroPathing;

import com.pedropathing.tuning.autotune.Procedure;
import com.pedropathing.tuning.autotune.Tuner;
import com.pedropathing.revhub.drivetrains.Mecanum;
import com.sun.tools.javac.code.Attribute;

import org.firstinspires.ftc.teamcode.globals.Robot;
import org.firstinspires.ftc.teamcode.pedroPathing.Procedures.ForesightTuner;
import org.firstinspires.ftc.teamcode.pedroPathing.Procedures.*;
public class Tuning {
    @Tuner
    public static Procedure otosTuner() {
        return new OtosTuner();
    }

    @Tuner
    public static Procedure mecanumTuner() {
        return new MecanumTuner();
    }

    @Tuner
    public static Procedure foresightTuner(){
        return new ForesightTuner(Constants::createLocalizer, Constants::createDrivetrain);
    }

}
