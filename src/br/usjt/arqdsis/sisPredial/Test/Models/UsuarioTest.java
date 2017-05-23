package br.usjt.arqdsis.sisPredial.Test.Models;
import java.sql.Time;
import java.util.Date;
import org.junit.BeforeClass;
import org.junit.Test;
import br.usjt.arqdsis.sisPredial.DAO.EmpresaDao;
import br.usjt.arqdsis.sisPredial.DAO.UsuarioDao;
import br.usjt.arqdsis.sisPredial.Models.Empresa;
import br.usjt.arqdsis.sisPredial.Models.Usuario;

public class UsuarioTest 
{
	public final int millisegundoHour = 3600000;
	public final int fuso = 3600000 * 3;
	private UsuarioDao dao;
	@BeforeClass
	public void beforeClass()
	{
		dao = new UsuarioDao();
	}
	
	@Test
	public void testIncluir() 
	{
		Usuario user = new Usuario();
		user.setCPF("43208561806");
		user.setNome("Claudia");
		user.setHoraAcesso(new Time(1000));
		Date dt = new Date();
		dt.setTime((millisegundoHour * 8)+ (millisegundoHour/2) + fuso);
		dt = new Date();
		dt.setTime((millisegundoHour * 16)+fuso);
		user.setLogin("clau");
		user.setSenha("1234");
		user.setPerfil(Usuario.TipoPerfil.Admin);
		user.setEmpresa(new Empresa());
		user.getEmpresa().setId(2);
		EmpresaDao daoEmpresa = new EmpresaDao();
		daoEmpresa.consultar(user.getEmpresa());
	}

	@Test
	public void testAlterar() 
	{
		Usuario user = new Usuario();
		user.setId(1);
		dao.consultar(user);
		user.setNome("Ale");
		dao.alterar(user);
		
	}
	@Test
	public void testConsultar() 
	{
		Usuario user = new Usuario();
		user.setId(1);
		dao.consultar(user);		
	}

	@Test
	public void testDeletar() 
	{
		Usuario user = new Usuario();
		user.setId(1);
		dao.consultar(user);
		dao.deletar(user);
	}

}
