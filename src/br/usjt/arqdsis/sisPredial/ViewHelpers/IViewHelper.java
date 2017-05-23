package br.usjt.arqdsis.sisPredial.ViewHelpers;

import javax.servlet.http.HttpServletRequest;

import br.usjt.arqdsis.sisPredial.Models.IEntidade;

public interface IViewHelper {
	IEntidade criar(HttpServletRequest request);
}
