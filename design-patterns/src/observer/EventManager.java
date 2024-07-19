package observer;

import java.util.ArrayList;
import java.util.List;
import observer.listeners.EventListener;

public class EventManager {
    private List<EventListener> listeners = new ArrayList<>();

    private Integer state = 0;

    public void subscribe(EventListener listener) {
        listeners.add(listener);
    }

    public void unsubscribe(EventListener listener) {
        listeners.remove(listener);
    }

    public void notify(String message) {
        for (EventListener listener : listeners) {
            listener.update(message, this.state);
        }
    }

    public void incrementaEstado() {
        state++;
        notify("Estado incrementado para " + state);
    }

    public void decrementaEstado() {
        state--;
        notify("Estado decrementado para " + state);
    }

    public void randomState() {
        state = (int) (Math.random() * 100);
        System.out.println("Estado randomico " + state);
        notify("Estado randomico " + state);
    }

}
