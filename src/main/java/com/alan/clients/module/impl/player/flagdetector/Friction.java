package com.alan.clients.module.impl.player.flagdetector;

import com.alan.clients.module.impl.player.FlagDetector;
import com.alan.clients.event.Listener;
import com.alan.clients.event.Priorities;
import com.alan.clients.event.annotations.EventLink;
import com.alan.clients.event.impl.motion.PreMotionEvent;
import com.alan.clients.value.Mode;


public class Friction extends Mode<FlagDetector> {
    public Friction(String name, FlagDetector parent) {
        super(name, parent);
    }

    @EventLink(value = Priorities.VERY_LOW)
    public final Listener<PreMotionEvent> onPreMotionEvent = event -> {

        if (mc.thePlayer.ticksSinceVelocity <= 20 || mc.thePlayer.isCollidedHorizontally ||
                mc.thePlayer.offGroundTicks <= 1 || event.isOnGround() || mc.thePlayer.capabilities.isFlying ||
                mc.thePlayer.ticksSinceTeleport == 1) return;

        double moveFlying = 0.02599999835384377;
        double friction = 0.9100000262260437;

        double speed = Math.hypot(mc.thePlayer.motionX, mc.thePlayer.motionZ);
        double lastSpeed = Math.hypot(mc.thePlayer.lastMotionX, mc.thePlayer.lastMotionZ);

        if (speed > lastSpeed * friction + moveFlying) {
            getParent().fail("Friction");
        }
    };
}
