package com.alan.clients.module.impl.movement.jesus;

import com.alan.clients.module.impl.movement.Jesus;
import com.alan.clients.event.Listener;
import com.alan.clients.event.annotations.EventLink;
import com.alan.clients.event.impl.motion.WaterEvent;
import com.alan.clients.value.Mode;

/**
 * @author Alan
 * @since 16.05.2022
 */

public class GravityJesus extends Mode<Jesus> {

    public GravityJesus(String name, Jesus parent) {
        super(name, parent);
    }

    @EventLink()
    public final Listener<WaterEvent> onWater = event -> {
        event.setWater(event.isWater() && mc.thePlayer.offGroundTicks > 5 && mc.gameSettings.keyBindJump.isKeyDown());
    };
}