package arvoreBinaria;

public class ArvoreBinaria<T> {
	
	NoArvoreBinaria raiz;
	
	public ArvoreBinaria() {
		
	}
	
	public void setRaiz(NoArvoreBinaria raiz) {
		this.raiz = raiz;
	}
	
	public boolean estaVazia() {
		return raiz == null;
	}
	
	public boolean pertence(T info) {
		return false;
	}
	
	private boolean pertence(NoArvoreBinaria no, T info) {
		return false;
	}
	
	public String toString() {
		return toString(raiz);
	}
	
	private String toString(NoArvoreBinaria no) {
		String string = "<"; 
		if (raiz.getInfo() != null) {
			string += toString()
		}
		return string + ">";
	}
	
	public String arvorePre(NoArvoreBinaria no);
	
	public int contarNos();
	
	public int contarNos(NoArvoreBinaria no);

}
