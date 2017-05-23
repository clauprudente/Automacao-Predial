package br.usjt.arqdsis.sisPredial.DispacherPathsEntity;

public class ConjuntoDispacherPath extends IDispacherPathEntidade {
	@Override
	public String post() {
		return get();
	}

	@Override
	public String get() {
		return "Views/Conjunto/Visualizar.jsp";
	}

	@Override
	public String put() {
		return get();
	}

	@Override
	public String delete() {
		return query();
	}

	@Override
	public String query() {
		return "Views/Conjunto/VisualizarTodos.jsp";
	}

	@Override
	public String postPage() {
		return "Views/Conjunto/CadastrarConjunto.jsp";
	}
	
	@Override
	public String putPage() {
		return postPage();
	}
}
