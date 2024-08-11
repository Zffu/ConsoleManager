package tk.milkthedev.consolemanager.event;

public abstract class Event {

    /**
     * <p>Gets the handler container of the event.</p>
     * @return
     */
    public HandlerContainer getHandlerContainer() {
        return getHandlers();
    }

    /**
     * <p>Gets the handler container of the event.</p>
     * <p><b>Should be implemented in each event class!</b></p>
     * @return
     */
    public static HandlerContainer getHandlers() {
        return null;
    }

}
