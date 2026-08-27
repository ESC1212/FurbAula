package lista;

public class ListaEncadeada<T> {
	
	private NoLista<T> primeiro;
	
	public ListaEncadeada() {
		primeiro = null;
	}
	
	
	
	public NoLista<T> getPrimeiro(){
		return primeiro;
	}
	
	public void inserir(T info) {
		NoLista<T> novaInfo = new NoLista<>(info);
		novaInfo.setProximo(primeiro);
		primeiro = novaInfo;
	}
	
	public boolean estaVazia() {
		return primeiro == null;
	}

	public NoLista<T> buscar(T Valor) {
        NoLista<T> p = primeiro;

        while (p != null) {
        	
            if (p.getInfo().equals(Valor))
                return p;

            p = p.getProximo();
        }

        return null;
    }

    public void retirar(T Valor) {
        NoLista<T> anterior = null;
        NoLista<T> p = primeiro;

        while (p != null && !(p.getInfo().equals(Valor))) {
            anterior = p;
            p = p.getProximo();
        }

        if (p != null) {
            if (p == primeiro)
            	primeiro = p.getProximo();
            else
                anterior.setProximo(p.getProximo());
        }
    }

    public int obterComprimento() {
        int comprimento = 0;
        NoLista<T> p = primeiro;

        while (p != null) {
            comprimento++;
            p = p.getProximo();
        }

        return comprimento;
    }

    public NoLista<T> obterNo(int posicao) {
    	NoLista<T> p = primeiro;
    	
    	if (posicao == -1)
    		posicao = obterComprimento() -1;
    	
        if (posicao < -1 || posicao >= obterComprimento())
            throw new IndexOutOfBoundsException();
        
        for (int i = 0; i < posicao; i++) {
            p = p.getProximo();
        }

        return p;
    }

    @Override
    public String toString() {
        String s = "";
        NoLista<T> p = primeiro;

        while (p != null) {
        	s += p.getInfo().toString();
        	
        	if (p.getProximo() != null)
        		s += ",";
        	
        	p = p.getProximo();
        }

        return s;
    }
    
}