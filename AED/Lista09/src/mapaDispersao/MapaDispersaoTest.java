package mapaDispersao;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class MapaDispersaoTest {

	@Test
	void testCaso1_ValidarInsercaoEBuscaNovoDado() {
		MapaDispersao<Aluno> mapa = new MapaDispersao<>(53);
		Aluno obj1 = new Aluno(12000, "Jean", LocalDate.of(2000, 1, 1));
		
		mapa.inserir(12000, obj1);
		
		Aluno resultado = mapa.buscar(12000);
		assertSame(obj1, resultado);
	}

	@Test
	void testCaso2_ValidarInsercaoEBuscaVariosDados() {
		MapaDispersao<Aluno> mapa = new MapaDispersao<>(53);
		
		Aluno jean = new Aluno(12000, "Jean", LocalDate.of(2000, 1, 1));
		Aluno pedro = new Aluno(14000, "Pedro", LocalDate.of(1999, 1, 20));
		Aluno marta = new Aluno(12500, "Marta", LocalDate.of(2001, 2, 18));
		Aluno lucas = new Aluno(13000, "Lucas", LocalDate.of(1998, 11, 25));
		
		mapa.inserir(12000, jean);
		mapa.inserir(14000, pedro);
		mapa.inserir(12500, marta);
		mapa.inserir(13000, lucas);
		
		assertSame(jean, mapa.buscar(12000));
		assertSame(pedro, mapa.buscar(14000));
		assertSame(marta, mapa.buscar(12500));
		assertSame(lucas, mapa.buscar(13000));
	}
	
	@Test
	void testCaso3_ValidarInsercaoEBuscaComColisao() {
		MapaDispersao<Aluno> mapa = new MapaDispersao<>(53);
		
		Aluno jean = new Aluno(12000, "Jean", LocalDate.of(2000, 1, 1));
		Aluno pedro = new Aluno(14000, "Pedro", LocalDate.of(1999, 1, 20));
		Aluno marta = new Aluno(14226, "Marta", LocalDate.of(2001, 2, 18));
		Aluno lucas = new Aluno(17180, "Lucas", LocalDate.of(1998, 11, 25));
		
		mapa.inserir(12000, jean);
		mapa.inserir(14000, pedro);
		mapa.inserir(14226, marta);
		mapa.inserir(17180, lucas);
		
		assertSame(jean, mapa.buscar(12000));
		assertSame(pedro, mapa.buscar(14000));
		assertSame(marta, mapa.buscar(14226));
		assertSame(lucas, mapa.buscar(17180));
	}
}