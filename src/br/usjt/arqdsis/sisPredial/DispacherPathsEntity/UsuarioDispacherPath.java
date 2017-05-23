package br.usjt.arqdsis.sisPredial.DispacherPathsEntity;

public class UsuarioDispacherPath extends IDispacherPathEntidade {

	@Override
	public String post() {
		return get();
	}

	@Override
	public String get() {
		return "Views/Usuario/VisualizarUsuario.jsp";
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
		return "Views/Usuario/VisualizarTodosUsuarios.jsp";
	}

	@Override
	public String postPage() {
		return "Views/Usuario/CadastrarUsuario.jsp";
	}
	
	@Override
	public String putPage() {
		return postPage();
	}

}
