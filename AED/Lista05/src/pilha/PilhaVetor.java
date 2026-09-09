package pilha;

public abstract class PilhaVetor<T> implements Pilha<T> {

	T[] info;
	int limite;
	int tamanho;

	public PilhaVetor(int limite) {
		this.limite = limite;
		tamanho = 0;
	}

	public void push(T info) {
		if (tamanho >= limite)
			throw new RuntimeException("Pilha cheia.");
		tamanho++;
		
	}

	public T pop() {
		return null;
	}

	public T peek() {
		return null;
	}

	public boolean estaVazia() {
		return false;
	}

	public void liberar() {
		System.out.println("Test");
	}
}
