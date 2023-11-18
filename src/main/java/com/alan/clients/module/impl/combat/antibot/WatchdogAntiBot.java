package com.alan.clients.module.impl.combat.antibot;

import com.alan.clients.Client;
import com.alan.clients.module.impl.combat.AntiBot;
import com.alan.clients.event.Listener;
import com.alan.clients.event.annotations.EventLink;
import com.alan.clients.event.impl.motion.PreMotionEvent;
import com.alan.clients.value.Mode;
import net.minecraft.client.network.NetworkPlayerInfo;

public final class WatchdogAntiBot extends Mode<AntiBot> {

    public WatchdogAntiBot(String name, AntiBot parent) {
        super(name, parent);
    }

    @EventLink()
    public final Listener<PreMotionEvent> onPreMotionEvent = event -> {

        mc.theWorld.playerEntities.forEach(player -> {
            final NetworkPlayerInfo info = mc.getNetHandler().getPlayerInfo(player.getUniqueID());

            if (info == null) {
                Client.INSTANCE.getBotManager().add(player);
            } else {
                Client.INSTANCE.getBotManager().remove(player);
            }
        });
    };
}