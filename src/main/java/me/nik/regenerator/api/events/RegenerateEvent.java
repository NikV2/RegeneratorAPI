package me.nik.regenerator.api.events;

import me.nik.regenerator.api.custom.QueuedChunk;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.List;

public class RegenerateEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final List<QueuedChunk> queuedChunks;

    public RegenerateEvent(List<QueuedChunk> chunks) {
        this.queuedChunks = chunks;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public List<QueuedChunk> getQueuedChunks() {
        return queuedChunks;
    }

    public HandlerList getHandlers() {
        return handlers;
    }
}