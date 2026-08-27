package lista;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ListaEncadeadaTest {

    @Test
    public void test01_ListaVazia() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        assertTrue(lista.estaVazia());
    }

    @Test
    public void test02_ListaNaoVazia() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        assertFalse(lista.estaVazia());
    }

    @Test
    public void test03_InclusaoUmNumero() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);

        NoLista<Integer> primeiro = lista.getPrimeiro();
        assertNotNull(primeiro);
        assertEquals(5, primeiro.getInfo());
        assertNull(primeiro.getProximo());
    }

    @Test
    public void test04_InclusaoTresNumeros() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);

        NoLista<Integer> n1 = lista.getPrimeiro();
        assertNotNull(n1);
        assertEquals(15, n1.getInfo());

        NoLista<Integer> n2 = n1.getProximo();
        assertNotNull(n2);
        assertEquals(10, n2.getInfo());

        NoLista<Integer> n3 = n2.getProximo();
        assertNotNull(n3);
        assertEquals(5, n3.getInfo());

        assertNull(n3.getProximo());
    }

    @Test
    public void test05_BuscarPrimeiraPosicao() {
        ListaEncadeada<Integer> lista = criarListaComQuatroElementos();
        
        NoLista<Integer> no = lista.buscar(20);
        assertNotNull(no);
        assertEquals(20, no.getInfo());
    }

    @Test
    public void test06_BuscarMeioDaLista() {
        ListaEncadeada<Integer> lista = criarListaComQuatroElementos();
        
        NoLista<Integer> no = lista.buscar(15);
        assertNotNull(no);
        assertEquals(15, no.getInfo());
    }

    @Test
    public void test07_BuscarDadoInexistente() {
        ListaEncadeada<Integer> lista = criarListaComQuatroElementos();
        
        NoLista<Integer> no = lista.buscar(50);
        assertNull(no);
    }

    @Test
    public void test08_ExcluirPrimeiroElemento() {
        ListaEncadeada<Integer> lista = criarListaComQuatroElementos();
        lista.retirar(20);

        assertEquals("15,10,5", lista.toString());
    }

    @Test
    public void test09_ExcluirElementoDoMeio() {
        ListaEncadeada<Integer> lista = criarListaComQuatroElementos();
        lista.retirar(15);

        assertEquals("20,10,5", lista.toString());
    }

    @Test
    public void test10_ObterNoPosicaoZero() {
        ListaEncadeada<Integer> lista = criarListaComQuatroElementos();
        
        NoLista<Integer> no = lista.obterNo(0);
        assertNotNull(no);
        assertEquals(20, no.getInfo());
    }

    @Test
    public void test11_ObterNoUltimaPosicao() {
        ListaEncadeada<Integer> lista = criarListaComQuatroElementos();
        
        NoLista<Integer> no = lista.obterNo(3);
        assertNotNull(no);
        assertEquals(5, no.getInfo());
    }

    @Test
    public void test12_ObterNoPosicaoInvalida() {
        ListaEncadeada<Integer> lista = criarListaComQuatroElementos();
        
        assertThrows(IndexOutOfBoundsException.class, () -> {
            lista.obterNo(10);
        });
    }

    @Test
    public void test13_ObterComprimentoListaVazia() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        
        assertEquals(0, lista.obterComprimento());
    }

    @Test
    public void test14_ObterComprimentoListaNaoVazia() {
        ListaEncadeada<Integer> lista = criarListaComQuatroElementos();
        
        assertEquals(4, lista.obterComprimento());
    }

    private ListaEncadeada<Integer> criarListaComQuatroElementos() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        return lista;
    }
}