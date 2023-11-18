package com.alan.clients.event.impl.motion;

import com.alan.clients.event.CancellableEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public final class HitSlowDownEvent extends CancellableEvent {
    public double slowDown;
    public boolean sprint;
}
