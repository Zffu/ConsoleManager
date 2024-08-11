package tk.milkthedev.consolemanager.event;

import tk.milkthedev.consolemanager.event.listener.Listener;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;

public class EventManager {
    private final ArrayList<Event> events;
    private final ArrayList<Listener> listeners;
    private final ArrayList<EventHandler> handlers;
    private final ArrayList<Method> methods;
    public EventManager() {
        this.events = new ArrayList<>();
        this.listeners = new ArrayList<>();
        this.handlers = new ArrayList<>();
        this.methods = new ArrayList<>();
    }

    public void registerEvent(Event event) {
        events.add(event);
    }

    public void unregisterEvent(Event event) {
        events.remove(event);
    }

    public void registerListener(Listener listener) {
        listeners.add(listener);
        for(Method method : listener.getClass().getMethods()) {
            EventHandler handler = method.getAnnotation(EventHandler.class);
            if(handler != null) {
                handlers.add(handler);
                methods.add(method);
            }
        }
    }

    public void unregisterListener(Listener listener) {
        listeners.remove(listener);
    }

    public void fireEvent(Event event) {
        ArrayList<Event> events1 = new ArrayList<>();
        ArrayList<EventHandler> handlers1 = new ArrayList<>();

        events.forEach(e -> {
            if (e.getEventName().equals(event.getEventName())) {
                events1.add(e);
                handlers1.add(handlers.get(events.indexOf(e)));
            }
        });

        // TODO: Sort on the basis of priority
        for (Method method : methods) {
            try {
                method.invoke(handlers1, handlers);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
