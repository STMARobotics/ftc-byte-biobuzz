package org.firstinspires.ftc.teamcode.subsystems;

import static com.pedropathing.ivy.commands.Commands.instant;
import static org.firstinspires.ftc.teamcode.globals.Constants.HOOD_HOME;
import static org.firstinspires.ftc.teamcode.globals.Constants.HOOD_SERVO;

import com.pedropathing.ivy.Command;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.hardware.servos.ServoEx;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.globals.Robot;

public class Hood {
    private final ServoEx hoodServo;
    private final Robot robot = Robot.getInstance();
    private int expectedPosition;

    public Hood(HardwareMap hardwareMap){
        this.hoodServo = new ServoEx(hardwareMap, HOOD_SERVO);
    }

    public void moveToHome(){
        hoodServo.set(HOOD_HOME);//random num
    }

    public void moveToPosition(int degrees) {
        this.expectedPosition = degrees;
        hoodServo.set(degrees);
    }

    public void telemetry(Telemetry telemetry) {
        telemetry.addData("Hood Servo Position", hoodServo.getRawPosition());
    }

    public Command periodic (){
      return  Command.build()
              .setExecute(()->
              {
                 robot.telemetry.addData("Expected position", expectedPosition);
                 robot.telemetry.addData("hood actual position", hoodServo.getRawPosition());
              });
    }

    public Command moveToHomeCommand(){
      return instant(this::moveToHome).requiring(this);
    }

    public Command moveToPositionCommand(int degrees) {
      return  Command.build()
              .setExecute(()->{
                  this.moveToPosition(degrees);
              }).requiring(this);
    }
}
