package br.usjt.arqdsis.sisPredial.Aula03;

public class Piramede extends Cubo implements Poligono3D 
{
	@Override
	public double volume() 
	{
		return super.volume() * (1/3);
	}
}
