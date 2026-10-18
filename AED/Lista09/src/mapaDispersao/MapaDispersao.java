package mapaDispersao;

import ListaEncadeada.ListaEncadeada;
import ListaEncadeada.NoLista;

public class MapaDispersao<T> {
	
	private ListaEncadeada<NoMapa<T>>[] info;
	
	public MapaDispersao(int tamanho) {
		this.info = new ListaEncadeada[tamanho];
		for (int i = 0; i < tamanho; i++) {
			this.info[i] = new ListaEncadeada<>();
		}
	}
	
	private int calcularHash(int chave) {
		return chave % this.info.length;
	}
	
	public void inserir(int chave, T dado) {
		int indice = calcularHash(chave);
		
		NoMapa<T> novoNo = new NoMapa<>();
		novoNo.setChave(chave);
		novoNo.setInfo(dado);
		
		this.info[indice].inserir(novoNo);
	}
	
	public void remover(int chave) {
		int indice = calcularHash(chave);
		
		NoMapa<T> noBusca = new NoMapa<>();
		noBusca.setChave(chave);
		
		this.info[indice].retirar(noBusca);
	}
	
	public T buscar(int chave) {
		int indice = calcularHash(chave);
		
		NoMapa<T> noBusca = new NoMapa<>();
		noBusca.setChave(chave);
		
		NoLista<NoMapa<T>> noEncontrado = this.info[indice].buscar(noBusca);
		
		if (noEncontrado != null) {
			return noEncontrado.getInfo().getInfo();
		}
		
		return null;
	}
}