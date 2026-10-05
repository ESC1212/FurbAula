package arvoreNAria;

public class NoArvore<T> {
	
	private T info;
	private NoArvore<T> primeiro;
	private NoArvore<T> proximo;
	
	public NoArvore(T info) {
		this.info = info;
	}
	
	public void inserirFilho(NoArvore<T> sa) {
		sa.setProximo(primeiro);
		setPrimeiro(sa);
	}
	
	public void setInfo(T info) {
		this.info = info;
	}
	
	public T getInfo() {
		return this.info;
	}
	
	public NoArvore<T> getPrimeiro() {
		return this.primeiro;
	}
	
	public void setPrimeiro(NoArvore<T> no) {
		this.primeiro = no;
	}
	
	public NoArvore<T> getProximo() {
		return this.proximo;
	}
	
	public void setProximo(NoArvore<T> no) {
		this.proximo = no;
	}

}