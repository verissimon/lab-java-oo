package observer.listeners;

public class NegativoListener implements EventListener {

    @Override
    public void update(String message, Integer state) {
        if (state < 0) {
            System.out.println("listener negativo reagiu. " + message);
        }
    }

}
