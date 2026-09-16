package fila;

public class FilaVetor<T> implements Fila<T> {
	
	Object info[];
	int limite;
	int tamanho; 
	int inicio;

	public FilaVetor(int limite){
		info = new Object[limite];
		this.limite = limite;
		tamanho = 0;
		inicio = 0;
	}
	
	public void inserir(T valor) {
		
		if (tamanho == limite)
			throw new RuntimeException();
		
		int fim = (inicio + tamanho) % limite;
		info[fim] = valor;
		tamanho++;
	}
	
	public T retirar() {
		
		if (estaVazia())
			throw new RuntimeException();
		
		T valor = peek();
		info[inicio] = null;
		inicio = (inicio + 1) % limite;
		tamanho--;
		return valor;
	}
	
	@SuppressWarnings("unchecked")
	public T peek() {
		if (estaVazia())
			throw new RuntimeException();
		
		return (T) info[inicio];
	}
	
	public boolean estaVazia() {
		return tamanho == 0;
	}
	
	public void liberar() {
		info = new Object[limite];		
	}
	
	public FilaVetor<T> criarFilaConcatenada(FilaVetor<T> f2) {
		if (f2.tamanho + this.tamanho > limite)
			throw new RuntimeException();
		
	}
	
}
