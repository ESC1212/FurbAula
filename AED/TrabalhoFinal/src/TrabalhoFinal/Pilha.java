package TrabalhoFinal;

public class Pilha<T> {
    private Object[] dados = new Object[100];
    private int tamanho = 0;

    public void empilhar(T elemento) {
        if (tamanho == dados.length) {
            Object[] novo = new Object[dados.length * 2];
            System.arraycopy(dados, 0, novo, 0, dados.length);
            dados = novo;
        }
        dados[tamanho++] = elemento;
    }

    public T desempilhar() {
        if (estaVazia()) {
            return null;
        }
        @SuppressWarnings("unchecked")
        T elemento = (T) dados[--tamanho];
        dados[tamanho] = null;
        return elemento;
    }

    @SuppressWarnings("unchecked")
	public T olhar() {
        if (estaVazia()) {
            return null;
        }
        return (T) dados[tamanho - 1];
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }
}