package br.usjt.arqdsis.sisPredial.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.usjt.arqdsis.sisPredial.Models.Conjunto;
import br.usjt.arqdsis.sisPredial.Models.Empresa;
import br.usjt.arqdsis.sisPredial.Models.IEntidade;

public class EmpresaDao extends AbstractDao<Empresa> 
{

	public EmpresaDao() 
	{
		super();
	}

	// incluir
	public boolean incluir(Empresa empresa) 
	{
		String sql = "insert into Empresa(CNPJ,RAZAOSOCIAL,temperaturaPadrao,horarioAbertura,horarioFechamento,horaIniAr,horaFimAr,conjuntoId) values (?, ?, ?, ?, ?,?,?)";
		PreparedStatement stm = null;
		try 
		{
			stm = conn.prepareStatement(sql);
			stm.setString(1, empresa.getCnpj());
			stm.setString(2, empresa.getRazaoSocial());
			stm.setInt(3, empresa.getTemperaturaPadrao());
			stm.setTime(4, empresa.getHorarioAbertura());
			stm.setTime(5, empresa.getHorarioFechamento());
			stm.setTime(6, empresa.getHoraIniAr());
			stm.setTime(7, empresa.getHoraFimAr());
			if(empresa.getConjunto() != null)
				stm.setInt(8, empresa.getConjunto().getId());
			else
				stm.setNull(8, java.sql.Types.INTEGER);
			stm.executeUpdate();
 
			ResultSet rs = stm.getGeneratedKeys();
			rs.next();
			empresa.setId(rs.getInt(1));
			return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			try {
				conn.rollback();
			} 
			catch (SQLException e1) 
			{
				System.out.print(e1.getStackTrace());
			} 
			finally 
			{
				if (stm != null) 
				{
					try {
						stm.close();
					} catch (SQLException e1) {
						System.out.print(e1.getStackTrace());
					}
				}
			}
		}
		return false;
	}

	// alterar
	public boolean alterar(Empresa empresa) {

		String sql = "update Empresa set (CNPJ = ?,RAZAOSOCIAL = ?,TemperaturaPadrao = ?,horarioAbertura = ?,horarioFechamento = ?,horaIniAr = ?,horaFimAr = ?,conjuntoId = ?) where id = ?";
		PreparedStatement stm = null;
		try 
		{
			stm = conn.prepareStatement(sql);
			stm.setString(1, empresa.getCnpj());
			stm.setString(2, empresa.getRazaoSocial());
			stm.setInt(3, empresa.getTemperaturaPadrao());
			stm.setTime(4, empresa.getHorarioAbertura());
			stm.setTime(5, empresa.getHorarioFechamento());
			stm.setTime(6, empresa.getHoraIniAr());
			stm.setTime(7, empresa.getHoraFimAr());
			if(empresa.getConjunto() != null)
				stm.setInt(8, empresa.getConjunto().getId());
			else
				stm.setNull(8, java.sql.Types.INTEGER);
			stm.setInt(9, empresa.getId());
			stm.execute();
			return true;
		} catch (Exception e) 
		{
			e.printStackTrace();
			try 
			{
				conn.rollback();
			} 
			catch (SQLException e1) 
			{
				System.out.print(e1.getStackTrace());
			} 
			finally 
			{
				if (stm != null) 
				{
					try 
					{
						stm.close();
					} 
					catch (SQLException e1) 
					{
						System.out.print(e1.getStackTrace());
					}
				}
			}
		}
		return false;
	}

	// Consultar
	public Empresa consultar(IEntidade obj) {
		String sql = "select * from Empresa where id = ?";
		Empresa empresa = (Empresa) obj;
		PreparedStatement stm = null;
		ResultSet rs = null;
		ConjuntoDao conjuntoDao = new ConjuntoDao();

		try {
			stm = conn.prepareStatement(sql);
			stm.setInt(1, empresa.getId());
			rs = stm.executeQuery();
			while (rs.next())
			{
				empresa.setId(rs.getInt("id"));
				empresa.setCnpj(rs.getString("cnpj"));
				empresa.setRazaoSocial(rs.getString("razaosocial"));
				empresa.setTemperaturaPadrao(rs.getInt("TemperaturaPadrao"));
				empresa.setHorarioAbertura(rs.getTime("horarioAbertura"));
				empresa.setHorarioFechamento(rs.getTime("horarioFechamento"));
				empresa.setHoraIniAr(rs.getTime("horaIniAr"));
				empresa.setHoraFimAr(rs.getTime("horaFimAr"));
				if ( rs.getInt("conjuntoId") != 0)
				{
					empresa.setConjunto(new Conjunto());
					empresa.getConjunto().setId(rs.getInt("conjuntoId"));
					conjuntoDao.consultar(empresa.getConjunto());
				}
				
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			try 
			{
				conn.rollback();
			} 
			catch (SQLException e1) 
			{
				System.out.print(e1.getStackTrace());
			}
		} 
		finally 
		{
			if (stm != null) 
			{
				try 
				{
					stm.close();
				} catch (SQLException e1) 
				{
					System.out.print(e1.getStackTrace());
				}
			}
		}
		return (empresa);
	}

	// Consultar
	public List<Empresa> consultarTodos(IEntidade entidade) 
	{
		String sql = "select * from Empresa where id = ?";
		List<Empresa> empresas = new ArrayList<Empresa>();
		PreparedStatement stm = null;
		ResultSet rs = null;
		Empresa empresa = new Empresa();
		ConjuntoDao conjuntoDao = new ConjuntoDao();
		try 
		{
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while (rs.next()) 
			{
				empresa = new Empresa();
				empresa.setId(rs.getInt("id"));
				empresa.setCnpj(rs.getString("cnpj"));
				empresa.setRazaoSocial(rs.getString("razaosocial"));
				empresa.setTemperaturaPadrao(rs.getInt("TemperaturaPadrao"));
				empresa.setHorarioAbertura(rs.getTime("horarioAbertura"));
				empresa.setHorarioFechamento(rs.getTime("horarioFechamento"));
				empresa.setHoraIniAr(rs.getTime("horaIniAr"));
				empresa.setHoraFimAr(rs.getTime("horaFimAr"));
				
				if ( rs.getInt("conjuntoId") != 0)
				{
					empresa.setConjunto(new Conjunto());
					empresa.getConjunto().setId(rs.getInt("conjuntoId"));
					conjuntoDao.consultar(empresa.getConjunto());
				}
				empresas.add(empresa);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			try 
			{
				conn.rollback();
			} 
			catch (SQLException e1) 
			{
				System.out.print(e1.getStackTrace());
			}
		} 
		finally 
		{
			if (stm != null) 
			{
				try 
				{
					stm.close();
				} 
				catch (SQLException e1) 
				{
					System.out.print(e1.getStackTrace());
				}
			}
		}
		return empresas;
	}

	public boolean deletar(Empresa empresa) 
	{
		String sql = "delete from Empresa where id = ?";

		PreparedStatement stm = null;
		try 
		{
			stm = conn.prepareStatement(sql);
			stm.setInt(1, empresa.getId());
			stm.execute();
			return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			try
			{
				conn.rollback();
			} 
			catch (SQLException e1) 
			{
				System.out.print(e1.getStackTrace());
			}
		} 
		finally 
		{
			if (stm != null) 
			{
				try 
				{
					stm.close();
				} 
				catch (SQLException e1) 
				{
					System.out.print(e1.getStackTrace());
				}
			}
		}
		return false;
	}
}
