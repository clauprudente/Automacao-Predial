package br.usjt.arqdsis.sisPredial.Core;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IFachade {

	RequestDispatcher create(HttpServletRequest request,HttpServletResponse response);
	RequestDispatcher read(HttpServletRequest request,HttpServletResponse response);
	RequestDispatcher update(HttpServletRequest request,HttpServletResponse response);
	RequestDispatcher delete(HttpServletRequest request,HttpServletResponse response);
	
	RequestDispatcher notFound(HttpServletRequest request);
	RequestDispatcher badRequest(HttpServletRequest request);
	RequestDispatcher defaultError(HttpServletRequest request);
	
	RequestDispatcher createPage(HttpServletRequest request,HttpServletResponse response);
	RequestDispatcher updatePage(HttpServletRequest request,HttpServletResponse response);

	
	
}
