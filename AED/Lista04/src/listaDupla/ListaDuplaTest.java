package listaDupla;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ListaDuplaTest {

    private ListaDupla<Integer> lista;

    //Na lista dupla, o meu metodo de obter String Inversa só imprime no console
    private String obterStringOrdemInversa(ListaDupla<Integer> lista) {
        if (lista.estaVazia()) return "";
        
        NoListaDupla<Integer> p = lista.getPrimeiro();
        while (p.getProximo() != null) {
            p = p.getProximo();
        }
        
        StringBuilder sb = new StringBuilder();
        while (p != null) {
            sb.append(p.getInfo());
            if (p.getAnterior() != null) sb.append(",");
            p = p.getAnterior();
        }
        return sb.toString();
    }

    @BeforeEach
    public void setUp() {
        lista = new ListaDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
    }

    @Test
    public void test1() {
        assertEquals("20,15,10,5", lista.toString(), "Os dados inseridos devem estar na ordem correta");
        assertEquals("5,10,15,20", obterStringOrdemInversa(lista), "As ligações de 'anterior' devem estar consistentes");
    }

    @Test
    public void testCaso2_BuscarElementoNoInicio() {
        NoListaDupla<Integer> no = lista.buscar(20);
        assertNotNull(no, "O nó contendo 20 não deveria ser null");
        assertEquals(20, no.getInfo(), "O valor do nó deve ser 20");
    }

    @Test
    public void testCaso3_BuscarElementoNoMeio() {
        NoListaDupla<Integer> no = lista.buscar(10);
        assertNotNull(no, "O nó contendo 10 não deveria ser null");
        assertEquals(10, no.getInfo(), "O valor do nó deve ser 10");
    }

    @Test
    public void testCaso4_RemoverElementoNoInicio() {
        lista.retirar(20);
        assertEquals("15,10,5", lista.toString());
    }

    @Test
    public void testCaso5_RemoverElementoNoMeio() {
        lista.retirar(10);
        assertEquals("20,15,5", lista.toString());
    }

    @Test
    public void testCaso6_RemoverElementoNoFim() {
        lista.retirar(5);
        assertEquals("20,15,10", lista.toString());
    }

    @Test
    public void testCaso7_LiberarDadosDaLista() {
        NoListaDupla<Integer> no20 = lista.buscar(20);
        NoListaDupla<Integer> no15 = lista.buscar(15);
        NoListaDupla<Integer> no10 = lista.buscar(10);
        NoListaDupla<Integer> no5 = lista.buscar(5);

        lista.liberar();

        assertTrue(lista.estaVazia(), "A lista deve estar vazia após liberar");
        assertNull(lista.getPrimeiro(), "A referência 'primeiro' deve ser null");

        assertNull(no20.getAnterior());
        assertNull(no20.getProximo());

        assertNull(no15.getAnterior());
        assertNull(no15.getProximo());

        assertNull(no10.getAnterior());
        assertNull(no10.getProximo());

        assertNull(no5.getAnterior());
        assertNull(no5.getProximo());
    }
}