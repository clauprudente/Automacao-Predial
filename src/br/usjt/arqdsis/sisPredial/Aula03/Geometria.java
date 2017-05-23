package br.usjt.arqdsis.sisPredial.Aula03;

import java.util.ArrayList;
import java.util.List;

public class Geometria 
{
	public List<Figura> listaFiguras;

	public Geometria() 
	{
		listaFiguras = new ArrayList<>();
		Triangulo tri = new Triangulo();
		tri.setNM(2);
		tri.setAltura(2);
		tri.setMP(2);
		tri.setBase(2);
		listaFiguras.add(tri);
		Retangulo ret = new Retangulo();
		ret.setAltura(2);
		ret.setBase(2);
		listaFiguras.add(ret);
		ret = new Quadrado();
		ret.setAltura(2);
		ret.setBase(2);
		listaFiguras.add(ret);
		ret = new Losango();
		ret.setAltura(2);
		ret.setBase(2);
		listaFiguras.add(ret);
		Circulo circ = new Circulo();
		circ.setDiametro(4);
		listaFiguras.add(circ);
		Cubo cub = new Cubo();
		cub.setAltura(2);
		cub.setBase(2);
		cub.setLargura(2);
		listaFiguras.add(cub);
		cub = new Piramede();
		cub.setAltura(2);
		cub.setBase(2);
		cub.setLargura(2);
		listaFiguras.add(cub);
		circ = new Cilindro();
		circ.setDiametro(4);
		circ.setAltura(2);
		listaFiguras.add(circ);
		circ = new Esfera();
		circ.setDiametro(4);
		listaFiguras.add(circ);
		
		for(Figura fig: listaFiguras)
		{
			System.out.println(fig.getClass().getName().toString() + ":");
			System.out.print(" Area: " + fig.area());
			System.out.print(" Perimetro: " + fig.perimetro());
			if (fig instanceof Poligono3D)
				System.out.print(" Volume:" + ((Poligono3D) fig).volume());
			if(fig instanceof Retangulo)
				System.out.println(" Diagonal:" + ((Retangulo)fig).calculaDiagonal());
		}
	}
}
