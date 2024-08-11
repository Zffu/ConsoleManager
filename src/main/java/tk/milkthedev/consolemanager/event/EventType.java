package tk.milkthedev.consolemanager.event;

import tk.milkthedev.consolemanager.event.impl.CommandPreprocessEvent;
import tk.milkthedev.consolemanager.event.impl.ConsoleInputEvent;

/**
 * <p>Types of events in the ConsoleManager. Used for various optimizations</p>
 * @since 1.0.0
 */
public enum EventType {

    COMMAND_PREPROCESS(CommandPreprocessEvent.class),
    CONSOLE_INPUT(ConsoleInputEvent.class);

    private Class<? extends Event> clazz;

    private EventType(Class<? extends Event> clazz) {
        this.clazz = clazz;
    }

    public Class<? extends Event> getClazz() {
        return clazz;
    }

}
