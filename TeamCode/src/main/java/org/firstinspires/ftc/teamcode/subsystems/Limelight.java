package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.teamcode.globals.Constants.LIMELIGHT;
import static org.firstinspires.ftc.teamcode.globals.Constants.LIMELIGHT_POLL_HZ;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.SerialNumber;
import com.seattlesolvers.solverslib.command.SubsystemBase;

public class Limelight extends SubsystemBase {
    private final Limelight3A limelight;

    public Limelight(HardwareMap hardwareMap){
        this.limelight = hardwareMap.get(Limelight3A.class, LIMELIGHT);
        limelight.setPollRateHz(LIMELIGHT_POLL_HZ);
        limelight.start();
    }
    public void pipelineSwitcher(int pipeline){
        limelight.pipelineSwitch(pipeline); // 0=blue 1=red
    }
    public double getTargetOffset(){
        LLResult result = limelight.getLatestResult();
        if (result == null || !result.isValid()){
            return Double.NaN;
        }
        return result.getTy();
    }
    public boolean hasValidTarget(){
        LLResult result = limelight.getLatestResult();
        return result != null && result.isValid();
    }

}
