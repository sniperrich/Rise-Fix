package com.alan.clients.event.impl.motion;

import com.alan.clients.event.CancellableEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Alan
 * @since 13.03.2022
 */
@Getter
@Setter
@AllArgsConstructor
public class JumpEvent extends CancellableEvent {
    private float jumpMotion;
    private float yaw;
}
