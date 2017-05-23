package br.usjt.arqdsis.sisPredial.Test.Models;
import org.junit.BeforeClass;
import org.junit.Test;
import br.usjt.arqdsis.sisPredial.DAO.ConjuntoDao;
import br.usjt.arqdsis.sisPredial.Models.Conjunto;

public class ConjuntoTeste 
{
	private ConjuntoDao dao;
	@BeforeClass
	private void beforeClass() 
	{
		dao = new ConjuntoDao();
	}
	@Test
	public void testInserir() 
	{
		Conjunto conjunto =  new Conjunto();
		conjunto.setAlugel(2000);
		conjunto.setAndar("1");
		conjunto.setNrConjunto("1");
		conjunto.setOcupado(false);
		conjunto.setTamanho(10);
	}

	@Test
	public void testAlterar() 
	{
		Conjunto conjunto =  new Conjunto();
		conjunto.setId(1);
		dao.consultar(conjunto);
		conjunto.setAlugel(2500);
		dao.alterar(conjunto);
	}

	@Test
	public void testConsultar() 
	{
		Conjunto conjunto =  new Conjunto();
		conjunto.setId(1);
		dao.consultar(conjunto);
	}

	@Test
	public void testDeletar() 
	{
		Conjunto conjunto =  new Conjunto();
		conjunto.setId(1);
		dao.consultar(conjunto);
		dao.deletar(conjunto);
	}
}
