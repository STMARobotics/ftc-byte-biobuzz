package org.firstinspires.ftc.teamcode.pedroPathing;

import static org.firstinspires.ftc.teamcode.globals.constants.*;

import com.pedropathing.algorithm.Algorithm;
import com.pedropathing.algorithm.Foresight;
import com.pedropathing.algorithm.ForesightConfig;
import com.pedropathing.controllers.Controller;
import com.pedropathing.follower.Follower;
import com.pedropathing.localization.Localizer;
import com.pedropathing.math.Matrix;
import com.pedropathing.math.Vector2D;
import com.pedropathing.drivetrain.Drivetrain;
import com.pedropathing.revhub.drivetrains.Mecanum;
import com.pedropathing.revhub.drivetrains.MecanumConfig;
import com.pedropathing.revhub.localizers.OTOSConfig;
import com.pedropathing.revhub.localizers.OTOSLocalizer;
import com.pedropathing.revhub.localizers.PinpointConfig;
import com.pedropathing.revhub.localizers.PinpointLocalizer;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Constants {
// create that takes the robots hardware.
    public static Follower create(HardwareMap h){
        return new Follower(
                new OTOSLocalizer(h, LOCALIZER_CONFIG),
                new Mecanum(h, DRIVETRAIN_CONFIG),
                new Foresight(FORESIGHT_CONFIG)

        );
    }

    /**
     * Pedro Pathing Mecanum config. It is all tuned but need to be merged and replace with Mollie's code.
     */
    public static MecanumConfig DRIVETRAIN_CONFIG = new MecanumConfig(
            c -> {
                c.frontLeftName.set("FrontLeftMotor");
                c.backLeftName.set("BackLeftMotor");
                c.frontRightName.set("FrontRightMotor");
                c.backRightName.set("BackRightMotor");
                c.frontLeftDirection.set(DcMotorSimple.Direction.REVERSE);
                c.backLeftDirection.set(DcMotorSimple.Direction.REVERSE);
                c.frontRightDirection.set(DcMotorSimple.Direction.FORWARD);
                c.backRightDirection.set(DcMotorSimple.Direction.FORWARD);
                c.manualBrakeMode.set(true);
            }
    );

    /**
     * Pedro Pathing config. It is also all tune and just need to be merged and replace with Mollie's code
     */
    public static OTOSConfig LOCALIZER_CONFIG = new OTOSConfig(
            c -> {
                c.name.set("pinpoint");
            }
    );

    /**
     * Pedro Pathing foresight config that hasnt been tuned at all.
     */
    public static ForesightConfig FORESIGHT_CONFIG = new ForesightConfig(
            c -> {
                Controller primaryTranslationalForward = Controller.proportional(0.3);
                Controller secondaryTranslationalForward = Controller.proportional(0.1);
                Controller primaryTranslationalLateral = Controller.proportional(0.3);
                Controller secondaryTranslationalLateral = Controller.proportional(0.1);
                c.forwardTranslational.set(Controller.piecewise(secondaryTranslationalForward).put(2.5, primaryTranslationalForward));
                c.strafeTranslational.set(Controller.piecewise(secondaryTranslationalLateral).put(2.5, primaryTranslationalLateral));
                c.coast.set(Controller.proportionalFeedforward(0.010978350889324107));
                c.brake.set(Controller.proportionalFeedforward(0.008731598255925491));
                c.headingFeedback.set(Controller.proportional(5.258721785960744));
                c.headingBrakeCoefficients.set(Vector2D.cartesian(0.05642143125655298, 0.0063829525363003695));
                c.linearBrakeCoefficients.set(Matrix.diag(0.10605894992901523, 0.08719146175596092));
                c.quadraticBrakeCoefficients.set(Matrix.diag(0.0014663966976606565, 0.0013837064502458813));
                c.maxAchievableForwardVelocity.set(72.72923108818539);
                c.maxAchievableStrafeVelocity.set(52.34323936525474);
                c.naturalForwardDeceleration.set(85.01144677379789);
                c.naturalStrafeDeceleration.set(104.49787535782846);
            }
    );

    /**
     * Creates and initialized a new Drivetrain instance for the Mecanum drive.
     * @param hardware
     * @return
     */
    public static Drivetrain createDrivetrain(HardwareMap hardware ) {
        return new Mecanum(hardware, DRIVETRAIN_CONFIG);
    }

    /**
     *Create and initializes a new position-tracking system (Localizer)
     * @param hardwareMap
     * @return
     */
    public static Localizer createLocalizer(HardwareMap hardwareMap) {
        return new OTOSLocalizer(hardwareMap, LOCALIZER_CONFIG);
    }

    /**
     *Creates and initializes a specific type of Algorithm
     * @return
     */
    public static Algorithm createAlgorithm() {
        return new Foresight(FORESIGHT_CONFIG);
    }

    /**
     *Create and initializes a followe for the otos.
     * @param hardwareMap
     * @return
     */
    public static Follower createFollower(HardwareMap hardwareMap) {
        return new Follower(createLocalizer(hardwareMap), createDrivetrain(hardwareMap), createAlgorithm());
    }
}


