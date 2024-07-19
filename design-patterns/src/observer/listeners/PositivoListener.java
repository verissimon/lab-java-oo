package observer.listeners;

public class PositivoListener implements EventListener {

    @Override
    public void update(String message, Integer state) {
        if (state > 0) {
            System.out.println("listener positivo reagiu. " + message);
        }
    }

}
