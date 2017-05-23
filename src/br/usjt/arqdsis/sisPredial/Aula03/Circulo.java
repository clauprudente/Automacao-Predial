package br.usjt.arqdsis.sisPredial.Aula03;

public class Circulo extends Poligono 
{
	private double diametro;
	
	public double getDiametro() 
	{
		return diametro;
	}

	public void setDiametro(double diametro) 
	{
		this.diametro = diametro;
	}

	public double getRaio()
	{
		return getDiametro()/2;
	}

	@Override
	public double area() 
	{
		return Math.PI * Math.pow(getRaio(), 2);
	}

	@Override
	public double perimetro() 
	{
		return Math.PI * getDiametro();
	}
	
	

}
