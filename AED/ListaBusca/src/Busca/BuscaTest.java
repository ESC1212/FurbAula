package Busca;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BuscaTest {

	private Integer[] criarVetor() {
		return new Integer[] {0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
	}

	@Test
	void testCaso1_BuscaLinear() {
		BuscaLinear<Integer> busca = new BuscaLinear<>();
		busca.setInfo(criarVetor());
		assertEquals(2, busca.buscar(20));
	}

	@Test
	void testCaso2_BuscaLinearVetorOrdenado() {
		BuscaLinearVetorOrdenado<Integer> busca = new BuscaLinearVetorOrdenado<>();
		busca.setInfo(criarVetor());
		assertEquals(4, busca.buscar(40));
	}

	@Test
	void testCaso3_BuscaBinariaExistente() {
		BuscaBinaria<Integer> busca = new BuscaBinaria<>();
		busca.setInfo(criarVetor());
		assertEquals(7, busca.buscar(70));
	}

	@Test
	void testCaso4_BuscaBinariaInexistente() {
		BuscaBinaria<Integer> busca = new BuscaBinaria<>();
		busca.setInfo(criarVetor());
		assertEquals(-1, busca.buscar(75));
	}
}