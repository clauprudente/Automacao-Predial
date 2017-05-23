package br.usjt.arqdsis.sisPredial.Factorys;

import java.util.HashMap;

import br.usjt.arqdsis.sisPredial.Core.FachadeEmpresa;
import br.usjt.arqdsis.sisPredial.Core.FachadeUsuario;
import br.usjt.arqdsis.sisPredial.Core.IFachade;
import br.usjt.arqdsis.sisPredial.Models.Empresa;
import br.usjt.arqdsis.sisPredial.Models.Usuario;

public class FactoryFachade implements IFactory<IFachade> {

	private HashMap<String, IFachade> map;
	private static FactoryFachade instance;
	
	private FactoryFachade() {
		map = new HashMap<String,IFachade>();
		map.put(Usuario.class.getName(), new FachadeUsuario());
		map.put(Empresa.class.getName(), new FachadeEmpresa());
	}
	
	public static FactoryFachade getInstance() {
		if (instance == null)
			instance = new FactoryFachade();
		return instance;
	}
	
	@Override
	public IFachade criar(Object obj) {

		if (obj == null)
		return null;
		
		if (!map.containsKey(obj.getClass().getName()))
			return null;
		
		return map.get(obj.getClass().getName());
	}

}
