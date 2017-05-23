package br.usjt.arqdsis.sisPredial.Controllers;

import java.io.*;
import java.util.List;
import javax.jws.WebMethod;
import javax.servlet.*;
import br.usjt.arqdsis.sisPredial.*;
/**
 * Servlet implementation class CrudController
 */
@WebServlet("/CrudController.do")
public class CrudController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FactoryViewHelper factoryViewHelper;
	private FactoryFachade fachadeFactory;

	public CrudController() {
		factoryViewHelper = new FactoryViewHelper();
		fachadeFactory = FactoryFachade.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IViewHelper vhp = factoryViewHelper.criar(request);
		IFachade fachade = fachadeFactory.criar(vhp.criar(request));

		RequestDispatcher view;
		if (request.getParameter("_method").equals("get"))
			if (request.getParameter("page") != null && request.getParameter("page").equals("create"))
				view = fachade.createPage(request, response);
			else if (request.getParameter("page") != null && request.getParameter("page").equals("update"))
				view = fachade.updatePage(request, response);
			else
				view = fachade.read(request, response);
		else if (request.getParameter("_method").equals("delete"))
			view = fachade.delete(request, response);
		else
			view = fachade.badRequest(request);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IViewHelper vhp = factoryViewHelper.criar(request);
		IFachade fachade = fachadeFactory.criar(vhp.criar(request));

		RequestDispatcher view;
		if (request.getParameter("_method").equals("post"))
			view = fachade.create(request, response);
		else if (request.getParameter("_method").equals("put"))
			view = fachade.update(request, response);
		else
			view = fachade.badRequest(request);

		view.forward(request, response);
	}

}
