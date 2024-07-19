import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class Cliente {

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	static Cliente buscarCliente(String nome, List<Cliente> clientes) {
		Stream<Cliente> clientesStream = clientes.stream();
		try {
			Cliente buscado = clientesStream
					.filter(c -> c.getNome().equals(nome)).findFirst()
					.orElseThrow();
			return buscado;
		} catch (NoSuchElementException | NullPointerException e) {
			System.out.println("Cliente não encontrado");
			return null;
		}
	}

}
