package Busca;

public class BuscaLinearVetorOrdenado<T extends Comparable<T>> extends BuscaAbstract {

	public int buscar(T valor) {
		Object[] info = getInfo();
		if (info == null) {
			return -1;
		}
		
		int n = info.length;
		for (int i = 0; i < n; i++) {
			T elementoAtual = (T) info[i];
			if (elementoAtual.equals(valor)) {
				return i;
			} else if (valor.compareTo(elementoAtual) < 0) {
				break;
			}
		}
		return -1;
	}
}