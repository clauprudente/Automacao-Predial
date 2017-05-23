package br.usjt.arqdsis.sisPredial.Aula03;

public class Cilindro extends Circulo implements Poligono3D 
{
	@Override
	public double volume() 
	{
		return Math.PI * Math.pow(getRaio(), 3) * getAltura();
	}
}
