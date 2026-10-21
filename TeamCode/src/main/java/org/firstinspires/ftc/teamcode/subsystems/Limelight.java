package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;

public class Limelight extends SubsystemBase {
    private final Limelight3A limelight;

    public Limelight(HardwareMap hardwareMap){
        limelight = hardwareMap.get(Limelight3A.class, "limelight");
        limelight.setPollRateHz(LIMELIGHT_POLL_HZ); //will deal with this when i feel like it >:(
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
