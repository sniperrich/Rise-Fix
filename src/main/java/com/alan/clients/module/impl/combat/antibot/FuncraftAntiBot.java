package com.alan.clients.module.impl.combat.antibot;

import com.alan.clients.Client;
import com.alan.clients.module.impl.combat.AntiBot;
import com.alan.clients.event.Listener;
import com.alan.clients.event.annotations.EventLink;
import com.alan.clients.event.impl.motion.PreUpdateEvent;
import com.alan.clients.value.Mode;

/**
 * @author Wykt
 * @since 2/04/2023
 */

public final class FuncraftAntiBot extends Mode<AntiBot> {
    public FuncraftAntiBot(String name, AntiBot parent) {
        super(name, parent);
    }

    @EventLink
    private final Listener<PreUpdateEvent> preUpdateEventListener = event -> {
        mc.theWorld.playerEntities.forEach(player -> {
            if(player.getDisplayName().getUnformattedText().contains("§")) {
                Client.INSTANCE.getBotManager().remove(player);
                return;
            }

            Client.INSTANCE.getBotManager().add(player);
        });
    };
}