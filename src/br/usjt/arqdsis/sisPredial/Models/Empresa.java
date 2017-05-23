package br.usjt.arqdsis.sisPredial.Models;

import java.sql.Time;
import java.util.List;

public class Empresa extends IEntidade 
{
	private String cnpj;
	private String razaoSocial;
	private Time horarioAbertura;
	private Time horarioFechamento;
	private int temperaturaPadrao;
	private Time horaInicialAr;
	private Time horaFinalAr;
	private Conjunto conj;
	private List<Usuario> funcionarios;

	public Empresa() 
	{
		this("", "");
	}

	public Empresa(String cnpj, String razaoSocial) 
	{
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
	}
	
	// getters e Setters
	public String getCnpj() 
	{
		return cnpj;
	}

	public void setCnpj(String cnpj) 
	{
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() 
	{
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) 
	{
		this.razaoSocial = razaoSocial;
	}

	public int getTemperaturaPadrao() 
	{
		return temperaturaPadrao;
	}

	public void setTemperaturaPadrao(int temperaturaPadrao) 
	{
		this.temperaturaPadrao = temperaturaPadrao;
	}

	public Time getHorarioAbertura() 
	{
		return horarioAbertura;
	}

	public void setHorarioAbertura(Time horarioAbertura) 
	{
		this.horarioAbertura = horarioAbertura;
	}

	public Time getHorarioFechamento() 
	{
		return horarioFechamento;
	}

	public void setHorarioFechamento(Time horarioFechamento) 
	{
		this.horarioFechamento = horarioFechamento;
	}

	public Time gethoraInicialAr() 
	{
		return horaInicialAr;
	}

	public void sethoraInicialAr(Time horaInicialAr) 
	{
		this.horaInicialAr = horaInicialAr;
	}

	public Time gethoraFinalAr() 
	{
		return horaFinalAr;
	}

	public void sethoraFinalAr(Time horaFinalAr) 
	{
		this.horaFinalAr = horaFinalAr;
	}

	public Conjunto getConjunto() 
	{
		return conj;
	}

	public void setConjunto(Conjunto conj) 
	{
		this.conj = conj;
	}
	public List<Usuario> getFuncionarios() 
	{
		return funcionarios;
	}

	public void setFuncionarios(List<Usuario> funcionarios) 
	{
		this.funcionarios = funcionarios;
	}
	
	@Override
	public String toString()
	{
		return getCnpj() + " - " + getRazaoSocial();
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		if (obj == null)
			return false;
		if(!(obj instanceof Empresa))
			return false;
		if(!cnpj.equals(((Empresa)obj).cnpj))
			return false;
		if(!razaoSocial.equals(((Empresa)obj).razaoSocial))
			return false;		
		return true;
	}
	

}