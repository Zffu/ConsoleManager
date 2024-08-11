package tk.milkthedev.consolemanager.event;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class HandlerContainer {

    private List<Method> handlers;

    public HandlerContainer() {
        this.handlers = new ArrayList<>();
    }

    public void register(Method method) {
        this.handlers.add(method);
    }

    public void propagate(Event event) {
        for(Method method : this.handlers) {
            try {
                method.invoke(null, event);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



}
