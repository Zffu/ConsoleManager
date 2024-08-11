package tk.milkthedev.consolemanager.event.impl;

import tk.milkthedev.consolemanager.event.Cancellable;
import tk.milkthedev.consolemanager.event.Event;
import tk.milkthedev.consolemanager.event.EventType;
import tk.milkthedev.consolemanager.event.RegisteredEvent;

@RegisteredEvent(type = EventType.COMMAND_PREPROCESS)
public class CommandPreprocessEvent extends Event implements Cancellable {
    private boolean cancel = false;
    private final String command;

    public CommandPreprocessEvent( String command) {
        this.command = command;
    }

    public boolean isCancel() {
        return cancel;
    }

    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }

    public String getCommand() {
        return command;
    }
}
