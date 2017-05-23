package br.usjt.arqdsis.sisPredial.Aula03;

public class Cubo extends Quadrado implements Poligono3D 
{
	public double largura;
	
	public double getLargura() 
	{
		return largura;
	}

	public void setLargura(double largura) 
	{
		this.largura = largura;
	}

	@Override
	public double volume() 
	{
		return getBase() * getAltura() * getLargura();
	}

}
