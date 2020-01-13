package br.com.horizon.components.events.abstractions;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class GameEvent extends Event {

    public static HandlerList handlerList = new HandlerList();

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

}
