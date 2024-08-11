package tk.milkthedev.consolemanager.event;

/**
 * <p>An event that was registered</p>
 */
public @interface RegisteredEvent {

    /**
     * <p>The event type of the event. Used of an optimized approach</p>
     * @return
     */
    EventType type();

}
