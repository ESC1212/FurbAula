package fila;

public interface Fila<T> {
	
	void inserir(T Valor);
	
	T retirar();
	
	T peek();
	
	boolean estaVazia();
	
	void liberar();
	
}
