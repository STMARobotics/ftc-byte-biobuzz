package org.firstinspires.ftc.teamcode.Opmode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.seattlesolvers.solverslib.command.CommandOpMode;

import org.firstinspires.ftc.teamcode.commands.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.globals.Robot;
import org.firstinspires.ftc.teamcode.globals.Constants;


@Autonomous(name="SimpleAuto", preselectTeleOp = "Driver Controlled")
public class SimpleAutoOpMode extends CommandOpMode {
    private final Robot robot = Robot.getInstance();
    private final long startTime = System.currentTimeMillis();

    @Override
    public void initialize() {
        Constants.OP_MODE_TYPE = Constants.OpModeType.AUTO;
        super.reset();
        robot.init(this);
        schedule(
                new DriveForwardCommand(robot.drive,1.5, .5)
        );
    }

    @Override
    public void run() {
        super.run();
        }
    }
