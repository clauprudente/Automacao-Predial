package br.usjt.arqdsis.sisPredial.Aula03;

public abstract class Poligono extends Figura 
{
	private double base;
	private double altura;
	
	@Override
	public double area() 
	{
		return getBase() * getAltura();
	}
	
	public double getBase() 
	{
		return base;
	}
	public void setBase(double base) 
	{
		this.base = base;
	}
	public double getAltura() 
	{
		return altura;
	}
	public void setAltura(double altura) 
	{
		this.altura = altura;
	}
}
