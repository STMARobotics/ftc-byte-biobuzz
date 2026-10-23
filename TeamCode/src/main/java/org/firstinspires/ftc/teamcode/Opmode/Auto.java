package org.firstinspires.ftc.teamcode.Opmode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.seattlesolvers.solverslib.command.CommandOpMode;

import org.firstinspires.ftc.teamcode.commands.DriverControlCommand;
import org.firstinspires.ftc.teamcode.globals.Robot;
import org.firstinspires.ftc.teamcode.globals.constants;
import org.firstinspires.ftc.teamcode.subsystems.Drive;


@Autonomous(name="TempAuto", preselectTeleOp = "Driver Controlled")
public class Auto extends CommandOpMode {
    private final Robot robot = Robot.getInstance();
    private final long startTime = System.currentTimeMillis();

    @Override
    public void initialize() {
        constants.OP_MODE_TYPE = constants.OpModeType.AUTO;

        robot.init(this);
    }

    @Override
    public void run() {
        robot.drive.driveRobotCentric(.25, 0, 0);
        super.run();
        long currentTime = System.currentTimeMillis();
        long actualTime = currentTime-startTime;
        long timeWanted = 1000;
        if (actualTime >= timeWanted){
            robot.drive.stop();
        }
    }


}
