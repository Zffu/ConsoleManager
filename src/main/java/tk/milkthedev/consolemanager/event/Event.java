package tk.milkthedev.consolemanager.event;

public abstract class Event {

    public final EventType type;

    public Event(EventType type) {
        this.type = type;
    }

}
