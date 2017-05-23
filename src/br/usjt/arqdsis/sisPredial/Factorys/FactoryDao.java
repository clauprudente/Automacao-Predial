package br.usjt.arqdsis.sisPredial.Factorys;

import java.util.HashMap;

import br.usjt.arqdsis.sisPredial.DAO.AbstractDao;
import br.usjt.arqdsis.sisPredial.DAO.ConjuntoDao;
import br.usjt.arqdsis.sisPredial.DAO.EmpresaDao;
import br.usjt.arqdsis.sisPredial.DAO.UsuarioDao;
import br.usjt.arqdsis.sisPredial.Models.Conjunto;
import br.usjt.arqdsis.sisPredial.Models.Empresa;
import br.usjt.arqdsis.sisPredial.Models.Usuario;

public class FactoryDao implements IFactory<AbstractDao> {

	private HashMap<String, AbstractDao> listaDaos;
		
	public FactoryDao() {
		listaDaos = new HashMap<>();		
		listaDaos.put(Empresa.class.getName(), new EmpresaDao());
		listaDaos.put(Usuario.class.getName(), new UsuarioDao());
		listaDaos.put(Conjunto.class.getName(), new ConjuntoDao());
	}

	@Override
	public AbstractDao criar(Object obj) {
		
		if(obj == null)
			return null;
		System.out.println(obj.getClass().getName());
		if (listaDaos.containsKey(obj.getClass().getName()))
			return listaDaos.get(obj.getClass().getName());
		
		return null;
	}

}
