package arvoreNAria;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ArvoreTest {

	private Arvore<Integer> criarArvoreCaso1() {
		NoArvore<Integer> no4 = new NoArvore<>(4);
		NoArvore<Integer> no3 = new NoArvore<>(3);
		no3.inserirFilho(no4);
		
		NoArvore<Integer> no5 = new NoArvore<>(5);
		NoArvore<Integer> no2 = new NoArvore<>(2);
		no2.inserirFilho(no5);
		no2.inserirFilho(no3);
		
		NoArvore<Integer> no10 = new NoArvore<>(10);
		NoArvore<Integer> no9 = new NoArvore<>(9);
		no9.inserirFilho(no10);
		
		NoArvore<Integer> no8 = new NoArvore<>(8);
		NoArvore<Integer> no7 = new NoArvore<>(7);
		no7.inserirFilho(no9);
		no7.inserirFilho(no8);
		
		NoArvore<Integer> no6 = new NoArvore<>(6);
		NoArvore<Integer> no1 = new NoArvore<>(1);
		no1.inserirFilho(no7);
		no1.inserirFilho(no6);
		no1.inserirFilho(no2);
		
		Arvore<Integer> arvore = new Arvore<>();
		arvore.setRaiz(no1);
		return arvore;
	}

	@Test
	void testCaso1_ValidarRepresentacaoTextual() {
		Arvore<Integer> arvore = criarArvoreCaso1();
		assertEquals("<1<2<3<4>><5>><6><7<8><9<10>>>>", arvore.toString());
	}

	@Test
	void testCaso2_BuscarNoExistente() {
		Arvore<Integer> arvore = criarArvoreCaso1();
		assertTrue(arvore.pertence(7));
	}

	@Test
	void testCaso3_BuscarNoInexistente() {
		Arvore<Integer> arvore = criarArvoreCaso1();
		assertFalse(arvore.pertence(55));
	}

	@Test
	void testCaso4_ValidarContagemDeNos() {
		Arvore<Integer> arvore = criarArvoreCaso1();
		assertEquals(10, arvore.contarNos());
	}
}