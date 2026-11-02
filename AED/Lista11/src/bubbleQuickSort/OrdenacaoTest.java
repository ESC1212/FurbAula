package bubbleQuickSort;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class OrdenacaoTest {

	@Test
	void testCaso1_ValidarAlgoritmoBolha() {
		Integer[] dados = {70, 2, 88, 15, 90, 30};
		
		OrdenacaoBolha<Integer> bolha = new OrdenacaoBolha<>();
		bolha.setInfo(dados);
		bolha.ordenar();
		
		Integer[] esperado = {2, 15, 30, 70, 88, 90};
		assertArrayEquals(esperado, bolha.getInfo());
	}

	@Test
	void testCaso2_ValidarAlgoritmoBolhaOtimizada() {
		Integer[] dados = {70, 2, 88, 15, 90, 30};
		
		OrdenacaoBolhaOtimizada<Integer> bolhaOtimizada = new OrdenacaoBolhaOtimizada<>();
		bolhaOtimizada.setInfo(dados);
		bolhaOtimizada.ordenar();
		
		Integer[] esperado = {2, 15, 30, 70, 88, 90};
		assertArrayEquals(esperado, bolhaOtimizada.getInfo());
	}

	@Test
	void testCaso3_ValidarAlgoritmoQuickSort() {
		Integer[] dados = {70, 2, 88, 15, 90, 30};
		
		OrdenacaoQuickSort<Integer> quickSort = new OrdenacaoQuickSort<>();
		quickSort.setInfo(dados);
		quickSort.ordenar();
		
		Integer[] esperado = {2, 15, 30, 70, 88, 90};
		assertArrayEquals(esperado, quickSort.getInfo());
	}
}