package br.usjt.arqdsis.sisPredial.Models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistroAcesso extends IEntidade 
{

	private Date dataAcesso;
	private String tipo;
	private Usuario usuario;
	public Date getDataAcesso() 
	{
		return dataAcesso;
	}

	public void setDataAcesso(Date dataAcesso) 
	{
		this.dataAcesso = dataAcesso;
	}

	public String getTipo() 
	{
		return tipo;
	}

	public void setTipo(String tipo) 
	{
		this.tipo = tipo;
	}

	public Usuario getUsuario() 
	{
		return usuario;
	}

	public void setUsuario(Usuario usuario) 
	{
		this.usuario = usuario;
	}
	
	@Override
	public String toString() 
	{
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		return  format.format(getDataAcesso()) 
				+ ":" + getUsuario().getLogin() 
				+ ":" + getTipo() + ";";
	}

	// Metodos
	public void enviarArquivo() 
	{
		
	}

	public void controlarAcesso() 
	{
		
	}

	public void consultar() 
	{
	}

}