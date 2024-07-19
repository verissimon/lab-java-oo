package template.redes;

public class Feicebuque extends RedeSocial {

    public Feicebuque(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    boolean login(String username, String password) {
        System.out.println("logando no Feicebuque");
        System.out.println("Usuario: " + username);
        System.out.print("senha: ");
        for (int i = 0; i < password.length(); i++) {
            System.out.print("*");
        }
        System.out.println("\nLogado com sucesso!");
        return true;
    }

    @Override
    void logout() {
        System.out.println(username + " deslogando do Feicebuque");
    }

    @Override
    boolean sendData(byte[] data) {
        System.out.println("Enviando dados para o Feicebuque");
        System.out.println("Mensagem postada: " + new String(data));
        return true;
    }
}
