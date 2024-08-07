import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		List<Cliente> clientes = new ArrayList<Cliente>();
		Banco banco = new Banco();
		banco.setNome("Banco generico");
		// List<Conta> contas = new ArrayList<Conta>();
		banco.setContas(new ArrayList<Conta>());

		Scanner scanner = new Scanner(System.in);
		while (true) {

			System.out.println("Selecione uma opção, 0 para sair");
			System.out.println("1 - Cadastrar cliente");
			System.out.println("2 - Cadastrar conta corrente");
			System.out.println("3 - Cadastrar conta poupanca");
			System.out.println("4 - depositar");
			System.out.println("5 - sacar");
			System.out.println("6 - transferir");

			int opcao = scanner.nextInt();
			if (opcao == 0) {
				break;
			}
			switch (opcao) {
			case 1: // cadastrar
				System.out.println("Digite o nome do cliente");
				String nome = scanner.next();
				Cliente cliente = new Cliente();
				cliente.setNome(nome);
				System.out.println("cliente " + cliente.getNome()
						+ " cadastrado com sucesso");
				clientes.add(cliente);
				break;

			case 2: // criar conta corrente
				Conta.criarConta(scanner, clientes, banco.getContas(),
						clienteCorrente -> new ContaCorrente(clienteCorrente));
				break;

			case 3: // criar conta poupanca
				Conta.criarConta(scanner, clientes, banco.getContas(),
						clientePoupanca -> new ContaPoupanca(clientePoupanca));
				break;

			case 4: // depositar
				// depositar(scanner, contas);
				Conta.operacao(scanner, banco.getContas(), conta -> {
					System.out.println("Digite o valor do deposito");
					Float valor = scanner.nextFloat();
					if (valor > 0) {
						conta.depositar(valor);
						conta.imprimirExtrato();
					} else
						System.out.println("Valor inválido");
				});
				break;

			case 5: // sacar
				Conta.operacao(scanner, banco.getContas(), (conta) -> {
					System.out.println("Digite o valor do saque");
					Float valor = scanner.nextFloat();
					if (valor > 0) {
						conta.sacar(valor);
						conta.imprimirExtrato();
					} else
						System.out.println("Valor inválido");
				});
				break;

			case 6: // transferir
				Conta.operacao(scanner, banco.getContas(), contaBase -> {
					System.out.println("Digite o numero da conta destino");
					Integer numeroContaDestino = scanner.nextInt();
					Conta contaDestino = Conta.buscarConta(numeroContaDestino,
							banco.getContas());
					if (contaDestino != null) {
						System.out.println("Digite o valor da transferencia");
						Float valor = scanner.nextFloat();
						if (valor > 0) {
							contaBase.transferir(valor, contaDestino);
							System.out.println("Conta base: ");
							contaBase.imprimirExtrato();
							System.out.println("Conta destino: ");
							contaDestino.imprimirExtrato();
						} else
							System.out.println("Valor inválido");
					}
				});
				break;
			default:
				break;
			}

		}
		scanner.close();
	}

}
