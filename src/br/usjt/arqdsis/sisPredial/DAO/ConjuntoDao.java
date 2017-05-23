package br.usjt.arqdsis.sisPredial.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.usjt.arqdsis.sisPredial.Models.Conjunto;
import br.usjt.arqdsis.sisPredial.Models.IEntidade;

public class ConjuntoDao extends AbstractDao<Conjunto> 
{
	public ConjuntoDao() 
	{
		super();
	}

	// incluir
	public boolean incluir(Conjunto conjunto) {

		String sql = "insert into Conjunto(nrConjunto,Andar,Alugel,tamanho,ocupado) values (?, ?, ?, ?, ?)";
		PreparedStatement stm = null;
		try 
		{
			stm = conn.prepareStatement(sql);
			stm.setString(1, conjunto.getNrConjunto());
			stm.setString(2, conjunto.getAndar());
			stm.setDouble(3, conjunto.getAlugel());
			stm.setInt(4, conjunto.getTamanho());
			stm.setBoolean(5, conjunto.isOcupado());
			stm.executeUpdate();
			ResultSet rs = stm.getGeneratedKeys();
			rs.next();
			conjunto.setId(rs.getInt(1));
			return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			try 
			{
				conn.rollback();
			} 
			catch (SQLException e1) {
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

	// alterar
	public boolean alterar(Conjunto conjunto) 
	{
		String sql = "update Conjunto set nrConjunto=?,Andar=?,Alugel=?,tamanho=?,ocupado=? where id = ?";
		PreparedStatement stm = null;
		try 
		{
			stm = conn.prepareStatement(sql);
			stm.setString(1, conjunto.getNrConjunto());
			stm.setString(2, conjunto.getAndar());
			stm.setDouble(3, conjunto.getAlugel());
			stm.setInt(4, conjunto.getTamanho());
			stm.setBoolean(5, conjunto.isOcupado());
			stm.setInt(6, conjunto.getId());
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
	public Conjunto consultar(IEntidade entidade) 
	{
		String sqlSelect = "select * from Conjunto where id = ?";
		Conjunto conjunto = new Conjunto();
		PreparedStatement stm = null;
		ResultSet rs = null;

		try 
		{
			stm = conn.prepareStatement(sqlSelect);
			stm.setInt(1, entidade.getId());
			rs = stm.executeQuery();
			while (rs.next()) 
			{
				conjunto.setId(rs.getInt("id"));
				conjunto.setNrConjunto(rs.getString("nrConjunto"));
				conjunto.setAndar(rs.getString("Andar"));
				conjunto.setAlugel(rs.getDouble("Alugel"));
				conjunto.setTamanho(rs.getInt("tamanho"));
				conjunto.setOcupado(rs.getBoolean("ocupado"));
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
		return (conjunto);
	}

	// Consultar
	public List<Conjunto> consultarTodos(IEntidade entidade) {
		String sql = "select * from Conjunto";
		List<Conjunto> conjuntos = new ArrayList<Conjunto>();
		Conjunto conjunto;
		PreparedStatement stm = null;
		ResultSet rs = null;

		try 
		{
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while (rs.next()) 
			{
				conjunto = new Conjunto();
				conjunto.setId(rs.getInt("id"));
				conjunto.setNrConjunto(rs.getString("nrConjunto"));
				conjunto.setAndar(rs.getString("Andar"));
				conjunto.setAlugel(rs.getDouble("Alugel"));
				conjunto.setTamanho(rs.getInt("tamanho"));
				conjunto.setOcupado(rs.getBoolean("ocupado"));
				conjuntos.add(conjunto);
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
		return conjuntos;
	}

	public boolean deletar(Conjunto conjunto) 
	{
		String sql = "Delete from Conjunto where id = ?";
		PreparedStatement stm = null;
		try 
		{
			stm = conn.prepareStatement(sql);
			stm.setInt(1, conjunto.getId());
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
}
