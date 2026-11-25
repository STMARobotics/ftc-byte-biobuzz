package org.firstinspires.ftc.teamcode.controls;

import com.pedropathing.ivy.Command;
import com.pedropathing.ivy.Scheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

/**
 * A gamepad button with SolversLib-style bindings that does not need a command scheduler.
 * Bindings.update() must be called once per loop for bindings to fire.
 *
 * Runnable versions run the code immediately.
 * Ivy Command versions schedule the command with the Ivy Scheduler.
 */
public class Button {
    private final BooleanSupplier input;
    private boolean last = false;
    private boolean toggled = false;

    private final List<Runnable> onPress = new ArrayList<>();
    private final List<Runnable> onRelease = new ArrayList<>();
    private final List<Runnable> whileHeld = new ArrayList<>();
    private final List<Runnable> toggleOn = new ArrayList<>();
    private final List<Runnable> toggleOff = new ArrayList<>();

    Button(BooleanSupplier input) {
        this.input = input;
    }

    // ---- Runnable versions: run the code right away ----
    public Button whenPressed(Runnable r)  { onPress.add(r);   return this; }
    public Button whenReleased(Runnable r) { onRelease.add(r); return this; }
    public Button whileHeld(Runnable r)    { whileHeld.add(r); return this; }
    public Button toggleWhenPressed(Runnable on, Runnable off) {
        toggleOn.add(on);
        toggleOff.add(off);
        return this;
    }

    // ---- Ivy Command versions: schedule the command ----
    public Button whenPressed(Command c)  { return whenPressed(schedule(c)); }
    public Button whenReleased(Command c) { return whenReleased(schedule(c)); }
    public Button toggleWhenPressed(Command on, Command off) {
        return toggleWhenPressed(schedule(on), schedule(off));
    }

    private static Runnable schedule(Command c) {
        return () -> Scheduler.schedule(c);
    }

    /** Current state of the button. */
    public boolean get() {
        return input.getAsBoolean();
    }

    /** Called by Bindings.update() once per loop. */
    void update() {
        boolean now = input.getAsBoolean();
        if (now && !last) {
            run(onPress);
            toggled = !toggled;
            run(toggled ? toggleOn : toggleOff);
        }
        if (!now && last) {
            run(onRelease);
        }
        if (now) {
            run(whileHeld);
        }
        last = now;
    }

    private static void run(List<Runnable> runnables) {
        for (Runnable r : runnables) {
            r.run();
        }
    }
}
