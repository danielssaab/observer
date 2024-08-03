import java.util.Observable;

public class Estoque extends Observable {

	private String nomeProduto;
	private int quantidade;

	public Estoque(String nomeProduto, int quantidadeInicial) {
		this.nomeProduto = nomeProduto;
		this.quantidade = quantidadeInicial;
	}

	public void atualizaEstoque(int quantidade) {
		this.quantidade = quantidade;
		estoqueModificado();
	}

	private void estoqueModificado() {
		setChanged();
		notifyObservers();
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	@Override
	public String toString() {
		return "ProdutoEstoque{" +
			"nomeProduto='" + nomeProduto + '\'' +
			", quantidade=" + quantidade +
			'}';
	}
}
