package com.alan.clients.event;

@FunctionalInterface
public interface Listener<Event> {
    void call(Event event);
}