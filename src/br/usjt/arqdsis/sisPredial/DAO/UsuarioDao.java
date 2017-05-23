package br.usjt.arqdsis.sisPredial.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.usjt.arqdsis.sisPredial.Models.Empresa;
import br.usjt.arqdsis.sisPredial.Models.IEntidade;
import br.usjt.arqdsis.sisPredial.Models.Usuario;

public class UsuarioDao extends AbstractDao<Usuario>{

   public UsuarioDao()
   {
      super();
   }

   public boolean incluir(Usuario user)
   {
      String sql = "insert into Usuario(login, CPF, nome, empresaId, horaAcesso,horaSaida,senha,perfil) values (?, ?, ?, ?, ?, ?,?,?)";
   
      PreparedStatement stm = null;
      try
      {
         stm = conn.prepareStatement(sql);
         stm.setString(1, user.getLogin());
         stm.setString(2, user.getCPF());
         stm.setString(3, user.getNome());
         stm.setInt(4, user.getEmpresa().getId());
         stm.setTime(5, user.getHoraAcesso());
         stm.setTime(6, user.getHoraSaida());
         stm.setString(7, user.getSenha());
         stm.setString(8,user.getPerfil().toString());
         stm.executeUpdate();
			ResultSet rs = stm.getGeneratedKeys();
			rs.next();
			user.setId(rs.getInt(1));
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
   
   //alterar
   public boolean alterar(Usuario user)
   {
   
      String sql = "update Usuario set login = ?, CPF=?, empresaId = ?, horaAcesso = ?, horaSaida = ?, nome = ?, senha = ?, perfil = ? where id = ?";
         
      PreparedStatement stm = null;
      try
      {
         stm = conn.prepareStatement(sql);
         stm.setString(1, user.getLogin());
         stm.setString(2, user.getCPF());
         stm.setInt(3, user.getEmpresa().getId());
         stm.setTime(4, user.getHoraAcesso());
         stm.setTime(5, user.getHoraSaida());
         stm.setString(6, user.getNome());
         stm.setString(7, user.getSenha());
         stm.setString(8, user.getPerfil().toString());
         stm.setInt(9, user.getId());
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
   
   //Consultar
   public Usuario consultar(IEntidade entidade)
   {
      String sql = "select * from Usuario where id = ?";
      Usuario user;
      user= (Usuario)entidade;
   
      PreparedStatement stm = null;
      ResultSet rs = null;
      
      EmpresaDao empDao = new EmpresaDao();
      try
      {
         stm = conn.prepareStatement(sql);
         if (entidade instanceof Usuario){
            stm.setInt(1,entidade.getId());
         }
         rs = stm.executeQuery();
         while (rs.next())
         {
            
            user.setId(rs.getInt("id"));
            user.setCPF(rs.getString("cpf"));
            user.setLogin(rs.getString("login"));
            user.setNome(rs.getString("nome"));
            user.setEmpresa(new Empresa());
            user.getEmpresa().setId(rs.getInt("empresaId"));
            empDao.consultar(user.getEmpresa());
            user.setHoraAcesso(rs.getTime("horaAcesso"));
            user.setHoraSaida(rs.getTime("horaSaida"));
            user.setSenha(rs.getString("senha"));
            user.setPerfil(Usuario.TipoPerfil.valueOf(rs.getString("perfil")));
            
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
      return (user);
   }
   
   //Consultar
   public List<Usuario> consultarTodos(IEntidade entidade)
   {
      String sql = "select * from Usuario where empresa_id = ?";
      List<Usuario> usuarios = new ArrayList<Usuario>();
      Usuario user;     
   
      PreparedStatement stm = null;
      ResultSet rs = null;
      EmpresaDao EmpresaDao = new EmpresaDao();
      
      try
      {
         stm = conn.prepareStatement(sql);
         if (entidade instanceof Usuario){
         }
         else if (entidade instanceof Empresa){
            stm.setInt(1,((Empresa)entidade).getId());
         }
         rs = stm.executeQuery();
         while (rs.next())
         {
            user= new Usuario();
            user.setId(rs.getInt("id"));
            user.setCPF(rs.getString("cpf"));
            user.setLogin(rs.getString("login"));
            user.setNome(rs.getString("nome"));
            user.setEmpresa(new Empresa());
            user.getEmpresa().setId(rs.getInt("empresaId"));
            EmpresaDao.consultar(user.getEmpresa());
            user.setHoraAcesso(rs.getTime("horaAcesso"));
            user.setHoraSaida(rs.getTime("horaSaida"));
            System.out.println(user.getHoraAcesso());
            System.out.println(user.getHoraSaida());
            user.setSenha(rs.getString("senha"));
            user.setPerfil(Usuario.TipoPerfil.valueOf(rs.getString("perfil")));
            usuarios.add(user);     
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
      return usuarios;
   }

   public boolean deletar(Usuario user) {
      String sql = "delete from Usuario where id = ?";
      PreparedStatement stm = null;
      try
      {
    	 stm = conn.prepareStatement(sql);
         stm.setInt(1, user.getId());
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

