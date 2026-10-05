package arvoreNAria;

public class Arvore<T> {
	
	private NoArvore<T> raiz;
	
	public Arvore() {
		this.raiz = null;
	}
	
	public NoArvore<T> getRaiz() {
		return this.raiz;
	}
	
	public void setRaiz(NoArvore<T> raiz) {
		this.raiz = raiz;
	}
	
	public boolean pertence(T info) {
		if (this.raiz == null) {
			return false;
		}
		return pertence(this.raiz, info);
	}
	
	private boolean pertence(NoArvore<T> no, T info) {
		if (no.getInfo().equals(info)) {
			return true;
		} else {
			NoArvore<T> p = no.getPrimeiro();
			while (p != null) {
				if (pertence(p, info)) {
					return true;
				}
				p = p.getProximo();
			}
			return false;
		}
	}
	
	public String toString() {
		if (this.raiz == null) {
			return "";
		}
		return obterRepresentacaoTextual(this.raiz);
	}
	
	private String obterRepresentacaoTextual(NoArvore<T> no) {
		String s = "<" + no.getInfo();
		NoArvore<T> p = no.getPrimeiro();
		while (p != null) {
			s += obterRepresentacaoTextual(p);
			p = p.getProximo();
		}
		s += ">";
		return s;
	}
	
	public int contarNos() {
		if (this.raiz == null) {
			return 0;
		}
		return contarNos(this.raiz);
	}
	
	private int contarNos(NoArvore<T> no) {
		int quant = 1;
		NoArvore<T> p = no.getPrimeiro();
		while (p != null) {
			quant += contarNos(p);
			p = p.getProximo();
		}
		return quant;
	}

}