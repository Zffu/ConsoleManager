package tk.milkthedev.consolemanager.event.impl;

import tk.milkthedev.consolemanager.event.Cancellable;
import tk.milkthedev.consolemanager.event.Event;
import tk.milkthedev.consolemanager.event.EventType;

public class ConsoleInputEvent extends Event implements Cancellable {
    private boolean cancel = false;
    private String input;

    public ConsoleInputEvent(String input) {
        this.input = input;
    }

    public boolean isCancel() {
        return cancel;
    }

    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
}
