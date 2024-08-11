package tk.milkthedev.consolemanager.event;

import tk.milkthedev.consolemanager.event.listener.Listener;

import java.util.ArrayList;

public class EventManager {
    private final ArrayList<Event> events;
    private final ArrayList<Listener> listeners;
    public EventManager() {
        this.events = new ArrayList<>();
        this.listeners = new ArrayList<>();
    }

    public void registerEvent(Event event) {
        events.add(event);
    }

    public void unregisterEvent(Event event) {
        events.remove(event);
    }

    public void registerListener(Listener listener) {
        listeners.add(listener);
    }

    public void unregisterListener(Listener listener) {
        listeners.remove(listener);
    }

    public void fireEvent(Event event) {
    }
}
