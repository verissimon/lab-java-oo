package template.redes;

public class Xuitter extends RedeSocial {

    public Xuitter(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    boolean login(String username, String password) {
        System.out.println("logando no Xuitter");
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
        System.out.println(username + " deslogando do Xuitter");
    }

    @Override
    boolean sendData(byte[] data) {
        System.out.println("Enviando dados para o Xuitter");
        System.out.println("Mensagem postada: " + new String(data));

        return true;
    }
}
