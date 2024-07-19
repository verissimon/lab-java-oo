package template.redes;

public abstract class RedeSocial {
    String username;
    String password;

    public boolean post(String message) {
        if (login(this.username, this.password)) {
            boolean result = sendData(message.getBytes());
            logout();
            System.out.println("-------------------------------------");
            return result;
        }
        return false;
    }

    abstract boolean login(String username, String password);

    abstract boolean sendData(byte[] data);

    abstract void logout();
}
