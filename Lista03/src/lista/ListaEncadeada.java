package lista;

public class ListaEncadeada<T> {
	
	public ListaEncadeada() {
	}
	
	NoLista<T> primeiro = new NoLista();
	
	public <T> T getPrimeiro(){
		return (T) primeiro.getInfo();
	}
	
	public void inserir(Object t) {
	}
	
	public boolean estaVazia() {
		return true;
	}

	public <T> NoLista<T> buscar(T Valor){
		return null;
	}
	
}
