import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Stream;

public abstract class Conta implements IConta {

	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	@Override
	public void sacar(double valor) {
		saldo -= valor;
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void imprimirInfosComuns() {
		System.out
				.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}

	@FunctionalInterface
	interface AccountCreator {
		Conta createAccount(Cliente cliente);
	}

	@FunctionalInterface
	interface AccountOperation {
		void execute(Conta conta);
	}

	static Conta buscarConta(Integer numeroConta, List<Conta> contas) {
		Stream<Conta> contasStream = contas.stream();
		try {
			Conta buscada = contasStream
					.filter(c -> c.getNumero() == numeroConta).findFirst()
					.orElseThrow();
			return buscada;
		} catch (NoSuchElementException | NullPointerException e) {
			System.out.println("Conta não encontrada");
			return null;
		}
	}

	static void criarConta(Scanner scanner, List<Cliente> clientes,
			List<Conta> contas, AccountCreator creator) {
		System.out.println("Digite o nome do cliente a quem a conta pertence");
		String nome = scanner.next();
		Cliente clienteBuscado = Cliente.buscarCliente(nome, clientes);
		if (clienteBuscado != null) {
			Conta conta = creator.createAccount(clienteBuscado);
			conta.imprimirExtrato();
			contas.add(conta);
		}
	}

	static void operacao(Scanner scanner, List<Conta> contas,
			AccountOperation operation) {
		System.out.println("Digite o numero da conta base para a operação");
		Integer numeroConta = scanner.nextInt();
		Conta contaBuscada = buscarConta(numeroConta, contas);
		if (contaBuscada != null) {
			operation.execute(contaBuscada);
		}
	}
}
