import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EstoqueObserverTest {

	@Test
	void deveNotificarUmObserver() {
		Estoque estoque = new Estoque("Notebook", 100);
		EstoqueObserver observer = new EstoqueObserver("Observer 1", estoque);
		estoque.atualizaEstoque(90);
		assertEquals("Observer 1 notificado da alteração no estoque: ProdutoEstoque{nomeProduto='Notebook', quantidade=90}", observer.getUltimaNotificacao());
	}

	@Test
	void deveNotificarVariosObservers() {
		Estoque estoque = new Estoque("Notebook", 100);
		EstoqueObserver observer1 = new EstoqueObserver("Observer 1", estoque);
		EstoqueObserver observer2 = new EstoqueObserver("Observer 2", estoque);
		estoque.atualizaEstoque(80);
		assertEquals("Observer 1 notificado da alteração no estoque: ProdutoEstoque{nomeProduto='Notebook', quantidade=80}", observer1.getUltimaNotificacao());
		assertEquals("Observer 2 notificado da alteração no estoque: ProdutoEstoque{nomeProduto='Notebook', quantidade=80}", observer2.getUltimaNotificacao());
	}

	@Test
	void naoDeveNotificarObserverNaoRegistrado() {
		Estoque estoque = new Estoque("Notebook", 100);
		EstoqueObserver observer = new EstoqueObserver("Observer 1", estoque);
		assertNull(observer.getUltimaNotificacao());
	}

	@Test
	void deveNotificarObserverCorreto() {
		Estoque estoqueA = new Estoque("Notebook", 100);
		Estoque estoqueB = new Estoque("Smartphone", 200);
		EstoqueObserver observer1 = new EstoqueObserver("Observer 1", estoqueA);
		EstoqueObserver observer2 = new EstoqueObserver("Observer 2", estoqueB);
		estoqueA.atualizaEstoque(90);
		assertEquals("Observer 1 notificado da alteração no estoque: ProdutoEstoque{nomeProduto='Notebook', quantidade=90}", observer1.getUltimaNotificacao());
		assertNull(observer2.getUltimaNotificacao());
	}
}
