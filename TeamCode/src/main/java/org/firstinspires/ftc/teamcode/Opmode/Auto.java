package org.firstinspires.ftc.teamcode.Opmode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.seattlesolvers.solverslib.command.CommandOpMode;

import org.firstinspires.ftc.teamcode.commands.AutoSucksAndIHateItCommand;
import org.firstinspires.ftc.teamcode.globals.Robot;
import org.firstinspires.ftc.teamcode.globals.constants;


@Autonomous(name="TempAuto", preselectTeleOp = "Driver Controlled")
public class Auto extends CommandOpMode {
    private final Robot robot = Robot.getInstance();
    private final long startTime = System.currentTimeMillis();

    @Override
    public void initialize() {
        constants.OP_MODE_TYPE = constants.OpModeType.AUTO;
        super.reset();
        robot.init(this);
        schedule(
                new AutoSucksAndIHateItCommand(robot.drive,1.0, .5)
        );
    }

    @Override
    public void run() {
        super.run();
        }
    }
