package arvoreBinaria;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ArvoreBinariaTest {

    @Test
    public void testCaso1_EstaVaziaReconheceArvoreVazia() {
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();
        assertTrue(arvore.estaVazia());
    }

    @Test
    public void testCaso2_EstaVaziaReconheceArvoreNaoVazia() {
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();
        arvore.setRaiz(new NoArvoreBinaria<>(5));
        
        assertFalse(arvore.estaVazia());
    }

    // Método auxiliar para criar a árvore especificada a partir do Caso 3
    private ArvoreBinaria<Integer> criarArvoreCaso3() {
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();
        
        // Criando nós folhas
        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<>(4);
        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<>(5);
        NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<>(6);
        
        // Criando nós intermediários
        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<>(2, null, no4);
        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<>(3, no5, no6);
        
        // Criando a raiz
        NoArvoreBinaria<Integer> no1 = new NoArvoreBinaria<>(1, no2, no3);
        
        arvore.setRaiz(no1);
        return arvore;
    }

    @Test
    public void testCaso3_RepresentacaoTextualPreOrdem() {
        ArvoreBinaria<Integer> arvore = criarArvoreCaso3();
        
        assertEquals("<1<2<><4<><>>><3<5<><>><6<><>>>>", arvore.toString());
    }

    @Test
    public void testCaso4_PertenceAvaliaValorRaiz() {
        ArvoreBinaria<Integer> arvore = criarArvoreCaso3();
        
        assertTrue(arvore.pertence(1));
    }

    @Test
    public void testCaso5_PertenceAvaliaValorNaoRaizENaoFolha() {
        ArvoreBinaria<Integer> arvore = criarArvoreCaso3();
        
        assertTrue(arvore.pertence(3));
    }

    @Test
    public void testCaso6_PertenceAvaliaValorFolha() {
        ArvoreBinaria<Integer> arvore = criarArvoreCaso3();
        
        assertTrue(arvore.pertence(6));
    }

    @Test
    public void testCaso7_NaoPertence() {
        ArvoreBinaria<Integer> arvore = criarArvoreCaso3();
        
        assertFalse(arvore.pertence(10));
    }

    @Test
    public void testCaso8_ContarQuantidadeDeNos() {
        ArvoreBinaria<Integer> arvore = criarArvoreCaso3();
        
        assertEquals(6, arvore.contarNos());
    }
}