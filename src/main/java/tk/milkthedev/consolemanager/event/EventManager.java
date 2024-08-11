package tk.milkthedev.consolemanager.event;

import tk.milkthedev.consolemanager.event.listener.Listener;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Manages the event inside of the ConsoleManager</p>
 * @since 1.0.0
 */
public class EventManager {

    /**
     * <p>Stores the event handlers.</p>
     */
    private List<Method>[] handlerMap = new List[EventType.values().length];

    /**
     * <p>Registers the handlers contained in an {@link Listener}</p>
     * @param listener the listener
     */
    public void register(Listener listener) {
        for(Method method : listener.getClass().getMethods()) {
            if(method.isAnnotationPresent(EventHandler.class)) {
                if(method.getGenericParameterTypes()[0] != null) {
                    Class<?> clazz = method.getGenericParameterTypes()[0].getClass();
                    RegisteredEvent event = clazz.getAnnotation(RegisteredEvent.class);
                    if(event != null) {
                        int id = event.type().ordinal();
                        if(this.handlerMap[id] == null) this.handlerMap[id] = new ArrayList<Method>();
                        this.handlerMap[id].add(method);
                    }
                }
            }
        }
    }

}
