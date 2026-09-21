package fila;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FilaVetorTest {

    @Test
    public void testCaso1_EstaVaziaReconheceFilaVazia() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        
        assertTrue(fila.estaVazia());
    }

    @Test
    public void testCaso2_EstaVaziaReconheceFilaNaoVazia() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        fila.inserir(10);
        
        assertFalse(fila.estaVazia());
    }

    @Test
    public void testCaso3_EnfileirarEDesenfileirarCorretamente() {
        FilaVetor<Integer> fila = new FilaVetor<>(10);
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        
        assertEquals(10, fila.retirar());
        assertEquals(20, fila.retirar());
        assertEquals(30, fila.retirar());
        assertTrue(fila.estaVazia());
    }

    @Test
    public void testCaso4_FilaCheiaException() {
        FilaVetor<Integer> fila = new FilaVetor<>(3);
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        
        assertThrows(RuntimeException.class, () -> {
            fila.inserir(40);
        });
    }

    @Test
    public void testCaso5_FilaVaziaException() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        
        assertThrows(RuntimeException.class, () -> {
            fila.retirar();
        });
    }

    @Test
    public void testCaso6_PeekRetornaInicio() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        
        assertEquals(10, fila.peek());
        assertEquals(10, fila.retirar());
    }

    @Test
    public void testCaso7_LiberarRemoveElementos() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        
        fila.liberar();
        
        assertTrue(fila.estaVazia());
    }

    @Test
    public void testCaso8_ConcatenacaoDeFilas() {
        // Criar f1
        FilaVetor<Integer> f1 = new FilaVetor<>(5);
        f1.inserir(10);
        f1.inserir(20);
        f1.inserir(30);
        
        FilaVetor<Integer> f2 = new FilaVetor<>(3);
        f2.inserir(40);
        f2.inserir(50);
        
        FilaVetor<Integer> f3 = f1.criarFilaConcatenada(f2);
        
        assertEquals("10,20,30,40,50", f3.toString());
        assertEquals(8, f3.getLimite());
        
        assertEquals("10,20,30", f1.toString());
        assertEquals("40,50", f2.toString());
    }
}