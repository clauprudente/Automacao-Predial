package br.usjt.arqdsis.sisPredial.Factorys;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import br.usjt.arqdsis.sisPredial.Models.Usuario;
import br.usjt.arqdsis.sisPredial.ViewHelpers.EmpresaViewHelper;
import br.usjt.arqdsis.sisPredial.ViewHelpers.IViewHelper;
import br.usjt.arqdsis.sisPredial.ViewHelpers.UsuarioViewHelper;

public class FactoryViewHelper implements IFactory<IViewHelper> {

	private HashMap<String, IViewHelper> mapViewHelper;

	public FactoryViewHelper() {
		mapViewHelper = new HashMap<>();

		mapViewHelper.put("usuario", new UsuarioViewHelper());
		mapViewHelper.put("empresa", new EmpresaViewHelper());

	}

	@Override
	public IViewHelper criar(Object obj) {

		if (obj == null)
			return null;

		if (!(obj instanceof HttpServletRequest))
			return null;

		System.out.println(((HttpServletRequest) obj).getParameter("entidadeName"));
		return mapViewHelper.get(((HttpServletRequest) obj).getParameter("entidadeName").toLowerCase());
	}

}
