package br.usjt.arqdsis.sisPredial.DAO;
import java.sql.Connection;
import java.util.List;

import br.usjt.arqdsis.sisPredial.Models.IEntidade;

public abstract class AbstractDao<T>{
   protected Connection conn;
   
   public AbstractDao()
   {
      try
      {
         conn = AcessoBD.getInstance();
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
   }
   
   public abstract boolean incluir(T obj);
   public abstract boolean alterar(T obj);
   public abstract T consultar(IEntidade obj);
   public abstract List<T> consultarTodos(IEntidade obj);
   public abstract boolean deletar(T obj);
   
  
}