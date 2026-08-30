package listaDupla;

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
		
		if (primeiro != null) {			
			primeiro.setAnterior(novaInfo);
		}
		
		novaInfo.setProximo(primeiro);
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
        	if (p == primeiro && p.getProximo() == null ) {
        		primeiro = null;
        	} else if (p == primeiro) {
            	primeiro = p.getProximo();
            	primeiro.setAnterior(null);
            } else if (p.getProximo() == null){
            	p.getAnterior().setProximo(null);
            } else {
            	p.getAnterior().setProximo(p.getProximo());
            	p.getProximo().setAnterior(p.getAnterior());
            }
        }
    }
    
    public void exibirOrdemInversa() {
    	NoListaDupla<T> p = primeiro;

    	if (p != null) {
    		while (p.getProximo() != null) {
    			p = p.getProximo();
        	}
    		while (p != null) {
    			System.out.println(p.getInfo());
    			p = p.getAnterior();
    		}
    	}	
    }
    
    public void liberar() {
    	NoListaDupla<T> p = primeiro;
    	NoListaDupla<T> proximo;
    	
    	while (p != null) {
    		proximo = p.getProximo();
    		p.setAnterior(null);
    		p.setProximo(null);
    		p = proximo;
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
