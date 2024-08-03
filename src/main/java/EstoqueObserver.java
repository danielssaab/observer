import java.util.Observable;
import java.util.Observer;

public class EstoqueObserver implements Observer {

	private String nome;
	private Observable observable;
	private String ultimaNotificacao;

	public EstoqueObserver(String nome, Observable observable) {
		this.nome = nome;
		this.observable = observable;
		observable.addObserver(this);
	}

	public String getUltimaNotificacao() {
		return this.ultimaNotificacao;
	}

	@Override
	public void update(Observable observable, Object arg) {
		if (observable instanceof Estoque) {
			Estoque estoque = (Estoque) observable;
			this.ultimaNotificacao =  (nome + " notificado da alteração no estoque: " + estoque.toString());
		}
	}
}
