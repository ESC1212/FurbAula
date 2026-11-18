package Busca;

public class BuscaBinaria<T extends Comparable<T>> extends BuscaAbstract {

	public int buscar(T valor) {
		Object[] info = getInfo();
		if (info == null) {
			return -1;
		}
		
		int n = info.length;
		int inicio = 0;
		int fim = n - 1;
		
		while (inicio <= fim) {
			int meio = (inicio + fim) / 2;
			T elementoMeio = (T) info[meio];
			
			int comparacao = valor.compareTo(elementoMeio);
			if (comparacao < 0) {
				fim = meio - 1;
			} else if (comparacao > 0) {
				inicio = meio + 1;
			} else {
				return meio;
			}
		}
		return -1;
	}
}