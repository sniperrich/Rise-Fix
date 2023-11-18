package com.alan.clients.event.impl.motion;

import com.alan.clients.event.CancellableEvent;
import com.alan.clients.util.interfaces.InstanceAccess;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public final class PostStrafeEvent extends CancellableEvent implements InstanceAccess {

}
