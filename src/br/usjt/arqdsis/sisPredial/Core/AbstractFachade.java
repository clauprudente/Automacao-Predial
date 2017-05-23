package br.usjt.arqdsis.sisPredial.Core;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.arqdsis.sisPredial.DAO.AbstractDao;
import br.usjt.arqdsis.sisPredial.DispacherPathsEntity.IDispacherPathEntidade;
import br.usjt.arqdsis.sisPredial.Factorys.FactoryDao;
import br.usjt.arqdsis.sisPredial.Factorys.FactoryDispacherPath;
import br.usjt.arqdsis.sisPredial.Factorys.FactoryViewHelper;
import br.usjt.arqdsis.sisPredial.Models.IEntidade;
import br.usjt.arqdsis.sisPredial.ViewHelpers.IViewHelper;

public abstract class AbstractFachade implements IFachade {

	protected FactoryDao factoryDao;
	protected FactoryViewHelper factoryViewHelper;
	protected FactoryDispacherPath factoryDispacherPath;
	
	protected AbstractFachade() {
		factoryDao = new FactoryDao();
	    factoryViewHelper = new FactoryViewHelper();
	    factoryDispacherPath = new FactoryDispacherPath();
	}
	
	@Override
	public RequestDispatcher create(HttpServletRequest request, HttpServletResponse response) {
		IViewHelper vhp = factoryViewHelper.criar(request);
		IEntidade entidade = vhp.criar(request);
		AbstractDao dao = factoryDao.criar(entidade);
		dao.incluir(entidade);
		
		request.setAttribute("entidade", entidade);
		IDispacherPathEntidade path = factoryDispacherPath.criar(entidade);
		if (path == null)
			return notFound(request);
		return request.getRequestDispatcher(path.post());
		
	}
	
	@Override
	public RequestDispatcher read(HttpServletRequest request, HttpServletResponse response) {
		IViewHelper vhp = factoryViewHelper.criar(request);
		IEntidade entidade = vhp.criar(request);
		AbstractDao dao = factoryDao.criar(entidade);
		List<IEntidade> entidades = null;
		if (request.getParameter("all") != null && request.getParameter("all").equals("false"))
			dao.consultar(entidade);
		else
			entidades = dao.consultarTodos(entidade);

		request.setAttribute("entidade", entidade);
		request.setAttribute("entidades", entidades);
		IDispacherPathEntidade path = factoryDispacherPath.criar(entidade);
		if (path == null)
			return notFound(request);
		RequestDispatcher view = request.getRequestDispatcher("404");

		if (entidades == null)
			view = request.getRequestDispatcher(path.get());
		else
			view = request.getRequestDispatcher(path.query());
		return view;
	}

	@Override
	public RequestDispatcher update(HttpServletRequest request, HttpServletResponse response) {
		IViewHelper vhp = factoryViewHelper.criar(request);
		IEntidade entidade = vhp.criar(request);
		AbstractDao dao = factoryDao.criar(entidade);
		dao.alterar(entidade);
		
		request.setAttribute("entidade", entidade);
		IDispacherPathEntidade path = factoryDispacherPath.criar(entidade);
		if (path == null)
			return notFound(request);
		return request.getRequestDispatcher(path.put());
	}

	@Override
	public RequestDispatcher delete(HttpServletRequest request, HttpServletResponse response) {
		IViewHelper vhp = factoryViewHelper.criar(request);
		IEntidade entidade = vhp.criar(request);
		AbstractDao dao = factoryDao.criar(entidade);
		dao.deletar(entidade);
		
		request.setAttribute("entidades", dao.consultarTodos(entidade));
		IDispacherPathEntidade path = factoryDispacherPath.criar(entidade);
		if (path == null)
			return notFound(request);
		return request.getRequestDispatcher(path.delete());
	}
	
	
	@Override
	public RequestDispatcher notFound(HttpServletRequest request) {
		return request.getRequestDispatcher("page404.html");
	}
	
	@Override
	public RequestDispatcher badRequest(HttpServletRequest request) {
		return request.getRequestDispatcher("pageBadRequest.html");
	}
	
	@Override
	public RequestDispatcher defaultError(HttpServletRequest request) {
		return request.getRequestDispatcher("error.html");
	}
	
	
}
