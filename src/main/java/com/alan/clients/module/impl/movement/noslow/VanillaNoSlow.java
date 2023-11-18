package com.alan.clients.module.impl.movement.noslow;

import com.alan.clients.module.impl.movement.NoSlow;
import com.alan.clients.event.Listener;
import com.alan.clients.event.annotations.EventLink;
import com.alan.clients.event.impl.motion.SlowDownEvent;
import com.alan.clients.value.Mode;

/**
 * @author Strikeless
 * @since 13.03.2022
 */
public class VanillaNoSlow extends Mode<NoSlow> {

    public VanillaNoSlow(String name, NoSlow parent) {
        super(name, parent);
    }

    @EventLink
    public final Listener<SlowDownEvent> onSlowDown = event -> {
        event.setCancelled(true);
    };
}