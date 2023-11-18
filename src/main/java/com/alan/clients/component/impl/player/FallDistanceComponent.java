package com.alan.clients.component.impl.player;

import com.alan.clients.api.Rise;
import com.alan.clients.component.Component;
import com.alan.clients.event.Listener;
import com.alan.clients.event.annotations.EventLink;
import com.alan.clients.event.impl.motion.PreMotionEvent;

@Rise
public final class FallDistanceComponent extends Component {

    public static float distance;
    private float lastDistance;

    @EventLink()
    public final Listener<PreMotionEvent> onPreMotionEvent = event -> {
        final float fallDistance = mc.thePlayer.fallDistance;

        if (fallDistance == 0) {
            distance = 0;
        }

        distance += fallDistance - lastDistance;
        lastDistance = fallDistance;
    };
}
