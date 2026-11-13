package org.firstinspires.ftc.teamcode.controls;

import com.qualcomm.robotcore.hardware.Gamepad;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

public class Bindings {

    private final Gamepad driver;
    private final Gamepad operator;
    private final List<Button> buttons = new ArrayList<>();

    private static Bindings INSTANCE;

    /** Call every OpMode init. Replaces the gamepads and clears old button bindings. */
    public static void init(Gamepad driverGamepad, Gamepad operatorGamepad) {
        INSTANCE = new Bindings(driverGamepad, operatorGamepad);
    }

    private Bindings(Gamepad driver, Gamepad operator) {
        this.driver = driver;
        this.operator = operator;
    }

    /** Call once per loop, before Scheduler.execute(), so button bindings fire. */
    public static void update() {
        for (Button b : INSTANCE.buttons) {
            b.update();
        }
    }

    private static Button button(BooleanSupplier input) {
        Button b = new Button(input);
        INSTANCE.buttons.add(b);
        return b;
    }

    // ---------------- Driver buttons ----------------

    public static Button getDriverOptionKey() {
        return button(() -> INSTANCE.driver.options);
    }

    public static Button getDriverButtonA() {
        return button(() -> INSTANCE.driver.a);
    }

    public static Button getDriverLeftBumper() {
        return button(() -> INSTANCE.driver.left_bumper);
    }

    public static Button getDriverRightBumper() {
        return button(() -> INSTANCE.driver.right_bumper);
    }

    // ---------------- Operator buttons ----------------

    public static Button getOperatorButtonA() {
        return button(() -> INSTANCE.operator.a);
    }

    public static Button getOperatorLeftBumper() {
        return button(() -> INSTANCE.operator.left_bumper);
    }

    // ---------------- Sticks and triggers ----------------

    public static DoubleSupplier getDriverLeftX() {
        return () -> INSTANCE.driver.left_stick_x;
    }

    /** Inverted so pushing the stick up is positive (the SDK reports up as negative). */
    public static DoubleSupplier getDriverLeftY() {
        return () -> -INSTANCE.driver.left_stick_y;
    }

    public static DoubleSupplier getDriverRightX() {
        return () -> INSTANCE.driver.right_stick_x;
    }

    public static DoubleSupplier getDriverRightTrigger() {
        return () -> INSTANCE.driver.right_trigger;
    }

    public static DoubleSupplier getDriverLeftTrigger() {
        return () -> INSTANCE.driver.left_trigger;
    }

    public static DoubleSupplier getOperatorLeftTrigger() {
        return () -> INSTANCE.operator.left_trigger;
    }

    public static DoubleSupplier getOperatorRightTrigger() {
        return () -> INSTANCE.operator.right_trigger;
    }
}
