package arvoreNAria;

public class NoArvore<T> {
	
	private T info;
	private NoArvore primeiro;
	private NoArvore proximo;
	
	public NoArvore(T info) {
		this.info = info;
	}
	
	public void inserirFilho(NoArvore sa) {
		if (primeiro == null) {
			sa.setProximo(primeiro);
			setPrimeiro(sa);
		}
	}
	
	public void setInfo(T info) {
		this.info = info;
	}
	
	public T getInfo() {
		return this.info;
	}
	
	public NoArvore getPrimeiro() {
		return this.primeiro;
	}
	
	public void setPrimeiro(NoArvore no) {
		this.primeiro = no;
	}
	
	public NoArvore getProximo() {
		return this.proximo;
	}
	
	public void setProximo(NoArvore no) {
		this.proximo = no;
	}

}
