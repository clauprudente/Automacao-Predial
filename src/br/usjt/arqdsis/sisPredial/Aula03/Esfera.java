package br.usjt.arqdsis.sisPredial.Aula03;

public class Esfera extends Circulo implements Poligono3D 
{
	@Override
	public double volume() 
	{
		return (4/3) * Math.PI * Math.pow(getRaio(), 3);
	}
}
