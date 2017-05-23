package br.usjt.arqdsis.sisPredial.Models;

public class Conjunto extends IEntidade
{
   private String nrConjunto;
   private String andar;
   private double aluguel;
   private int tamanho;
   private boolean ocupado;
   
   public Conjunto()
   {
	   this.ocupado = false;
   }
   
   //Getters and Setters
   public String getNrConjunto() 
   {
      return nrConjunto;
   }
   public void setNrConjunto(String nrConjunto) 
   {
      this.nrConjunto = nrConjunto;
   }
   public String getAndar() 
   {
      return andar;
   }
   public void setAndar(String andar) 
   {
      this.andar = andar;
   }
   public double getAluguel() 
   {
      return aluguel;
   }
   public void setAlugel(double aluguel) 
   {
      this.aluguel = aluguel;
   }
   public int getTamanho() 
   {
      return tamanho;
   }
   public void setTamanho(int tamanho) 
   {
      this.tamanho = tamanho;
   }
   public boolean isOcupado() 
   {
      return ocupado;
   }
   public void setOcupado(boolean ocupado) 
   {
      this.ocupado = ocupado;
   }

   @Override
	public String toString() 
   {
		return getId() + " Sala " + getNrConjunto() + "\n Andar: " + getAndar();
	}
}