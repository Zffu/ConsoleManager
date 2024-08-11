package tk.milkthedev.consolemanager.api;

import tk.milkthedev.consolemanager.event.EventManager;
import tk.milkthedev.consolemanager.event.listener.Listener;
import tk.milkthedev.consolemanager.handler.ConsoleHandler;
import tk.milkthedev.consolemanager.manager.command.CommandManager;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    private final CommandManager commandManager;
    private final ConsoleHandler consoleHandler;
    private final EventManager eventManager;
    private final ArrayList<Listener> listeners;

    public Manager() {
        this.commandManager = new CommandManager(this);
        this.consoleHandler = new ConsoleHandler();
        this.eventManager = new EventManager();
        this.listeners = new ArrayList<>();
    }

    public Manager(CommandManager commandManager, ConsoleHandler consoleHandler, EventManager eventManager, ArrayList<Listener> listeners) {
        this.commandManager = commandManager;
        this.consoleHandler = consoleHandler;
        this.eventManager = eventManager;
        this.listeners = listeners;
    }

    public CommandManager getCommandManager() {
        return this.commandManager;
    }

    public ConsoleHandler getConsoleHandler() {
        return this.consoleHandler;
    }

    public EventManager getEventManager() {
        return this.eventManager;
    }

    public void registerListener(Listener listener) {
        this.listeners.add(listener);
    }

    public void unregisterListener(Listener listener) {
        this.listeners.remove(listener);
    }

    public List<Listener> getListeners() {
        return this.listeners;
    }
}
