package br.usjt.arqdsis.sisPredial.Models;

public abstract class IEntidade
{   
   private int iId;
   
   public void setId(int id)
   {
      iId = id;
   }
   public int getId()
   {
      return iId;
   }
   
}