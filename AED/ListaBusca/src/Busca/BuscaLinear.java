package Busca;

public class BuscaLinear<T> extends BuscaAbstract {

	public int buscar(T valor) {
		Object[] info = getInfo();
		if (info == null) {
			return -1;
		}
		
		int n = info.length;
		for (int i = 0; i < n; i++) {
			if (info[i].equals(valor)) {
				return i;
			}
		}
		return -1;
	}
}