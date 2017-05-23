package br.usjt.arqdsis.sisPredial.DispacherPathsEntity;

public class EmpresaDispacherPath extends IDispacherPathEntidade {

	@Override
	public String post() {
		return get();
	}

	@Override
	public String get() {
		return "Views/Empresa/Visualizar.jsp";
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
		return "Views/Empresa/VisualizarTodos.jsp";
	}

	@Override
	public String postPage() {
		return "Views/Empresa/CadastrarEmpresa.jsp";
	}
	
	@Override
	public String putPage() {
		return postPage();
	}

}
