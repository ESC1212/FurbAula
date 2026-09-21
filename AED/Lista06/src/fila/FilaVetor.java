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
			throw new FilaCheiaException();
		
		int fim = (inicio + tamanho) % limite;
		info[fim] = valor;
		tamanho++;
	}
	
	public T retirar() {
		if (estaVazia())
			throw new FilaVaziaException();
		
		T valor = peek();
		info[inicio] = null;
		inicio = (inicio + 1) % limite;
		tamanho--;
		return valor;
	}
	
	@SuppressWarnings("unchecked")
	public T peek() {
		if (estaVazia())
			throw new FilaVaziaException();
		
		return (T) info[inicio];
	}
	
	public boolean estaVazia() {
		return tamanho == 0;
	}
	
	public void liberar() {
		info = new Object[limite];
        tamanho = 0;
        inicio = 0;
	}
	
	@SuppressWarnings("unchecked")
	public FilaVetor<T> criarFilaConcatenada(FilaVetor<T> f2) {
        int novoLimite = this.limite + f2.limite;
        FilaVetor<T> novaFila = new FilaVetor<>(novoLimite);
        
        for (int i = 0; i < this.tamanho; i++) {
            int pos = (this.inicio + i) % this.limite;
            novaFila.inserir((T) this.info[pos]);
        }
        
        for (int i = 0; i < f2.tamanho; i++) {
            int pos = (f2.inicio + i) % f2.limite;
            novaFila.inserir((T) f2.info[pos]);
        }
        
        return novaFila;
	}

    @Override
    public String toString() {
        if (estaVazia()) return "";
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tamanho; i++) {
            int pos = (inicio + i) % limite;
            sb.append(info[pos]);
            if (i < tamanho - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public int getLimite() {
        return this.limite;
    }
}