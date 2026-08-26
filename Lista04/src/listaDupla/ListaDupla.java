package listaDupla;

import java.security.Principal;

public class ListaDupla<T> {
	
	private NoListaDupla<T> primeiro;
	
	public ListaDupla() {
		primeiro = null;
	}
	
	
	
	public NoListaDupla<T> getPrimeiro(){
		return primeiro;
	}
	
	public void inserir(T info) {
		NoListaDupla<T> novaInfo = new NoListaDupla<>(info);
		novaInfo.setProximo(primeiro);
		primeiro.setAnterior(novaInfo);
		primeiro = novaInfo;
	}
	
	public boolean estaVazia() {
		return primeiro == null;
	}

	public NoListaDupla<T> buscar(T Valor) {
        NoListaDupla<T> p = primeiro;

        while (p != null) {
        	
            if (p.getInfo().equals(Valor))
                return p;

            p = p.getProximo();
        }

        return null;
    }

    public void retirar(T Valor) {
        NoListaDupla<T> p = primeiro;

        while (p != null && !(p.getInfo().equals(Valor))) {
            p = p.getProximo();
        }

        if (p != null) {
            if (p == primeiro) {
            	primeiro = p.getProximo();
            	p.setAnterior(null);
            } else {
            	p.getAnterior().setProximo(p.getProximo());
            	p.getProximo().setAnterior(p.getAnterior());
            }
        }
    }
    
    public void exibirOrdemInversa() {
    	NoListaDupla<T> ultimo = null;
    	NoListaDupla<T> p = primeiro;

    	if (p != null) {
    		if (p.getProximo() == null)
    			System.out.println(p.getInfo());
    		while (p.getProximo() != null) {
    			p = p.getProximo();
        	}
    		while (p.getAnterior() != null) {
    			System.out.println(p.getInfo());
    			p = p.getAnterior();
    		}
    	}	
    }
    
    public void liberar() {
    	NoListaDupla<T> p = primeiro;
    	
    	while (p != null) {
    		p.setAnterior(null);
    		p = p.getProximo();
    	}
    	
    	primeiro = null;
    	
    }

    @Override
    public String toString() {
        String s = "";
        NoListaDupla<T> p = primeiro;

        while (p != null) {
        	s += p.getInfo().toString();
        	
        	if (p.getProximo() != null)
        		s += ",";
        	
        	p = p.getProximo();
        }

        return s;
    }
    
}
