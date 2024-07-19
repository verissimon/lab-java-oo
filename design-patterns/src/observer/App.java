package observer;

import observer.listeners.EventListener;

public class App {
    public static void main(String[] args) throws Exception {
        EventManager manager = new EventManager();
        Integer LIMIT = 50;

        manager.subscribe(new EventListener() {
            @Override
            public void update(String message, Integer state) {
                if (state >= LIMIT) {
                    System.out
                            .println("Observador de limite reagiu. " + message);
                    throw new RuntimeException(
                            "State gerado foi maior que " + LIMIT);
                }
            }
        });

        try {
            for (int i = 0; i < 10; i++) { // gera 10 estados aleatorios entre 0
                                           // e 100
                manager.randomState();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
