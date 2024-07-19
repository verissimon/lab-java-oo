package template;

import java.util.Scanner;

import template.redes.Feicebuque;
import template.redes.RedeSocial;
import template.redes.Xuitter;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Selecione uma opção, 0 para sair");
            System.out.println("escolha rede social para realizar postagem:");
            System.out.println("1 - Xuitter");
            System.out.println("2 - Feicebuque");

            int opcao = scanner.nextInt();
            if (opcao == 0) {
                break;
            }

            System.out.println("Digite o username:");
            String username = scanner.next();
            System.out.println("Digite a senha:");
            String password = scanner.next();
            System.out.println("Digite o texto da postagem:");
            String post = scanner.next();

            RedeSocial redeSocial = null;
            switch (opcao) {
            case 1:
                redeSocial = new Xuitter(username, password);
                break;

            case 2:
                redeSocial = new Feicebuque(username, password);
                break;
            default:
                break;
            }
            redeSocial.post(post);
            scanner.nextLine();
        }
        scanner.close();
    }
}
