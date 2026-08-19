package lista;

public class NoLista<T> {
	
	public NoLista() {
		
	}
	
	private T info;
	
	public T getInfo() {
		return info;
	}
	
	public void setInfo(T info) {
		this.info = info;
	}
	
	public NoLista<T> getProximo(){
		return null;
	}
	
	public void setProximo(NoLista<T> proximo) {
	}
	
}
