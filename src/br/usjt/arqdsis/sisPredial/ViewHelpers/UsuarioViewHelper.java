package br.usjt.arqdsis.sisPredial.ViewHelpers;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import br.usjt.arqdsis.sisPredial.Models.Empresa;
import br.usjt.arqdsis.sisPredial.Models.IEntidade;
import br.usjt.arqdsis.sisPredial.Models.Usuario;
import br.usjt.arqdsis.sisPredial.Models.Usuario.TipoPerfil;

public class UsuarioViewHelper implements IViewHelper {

	@Override
	public IEntidade criar(HttpServletRequest request) {
		Usuario usuario = new Usuario();

		usuario.setCPF(request.getParameter("cpf"));
		usuario.setNome(request.getParameter("nome"));
		if (request.getParameter("perfil") != null)
			usuario.setPerfil(TipoPerfil.valueOf(request.getParameter("perfil")));
		usuario.setLogin(request.getParameter("login"));
		usuario.setSenha(request.getParameter("senha"));
		DateFormat fmtData = new SimpleDateFormat("HH:mm");
		String data = request.getParameter("horaAcesso");
		if (data != null)
			try {
				usuario.setHoraAcesso(new Time(fmtData.parse(data).getTime()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		data = request.getParameter("horaSaida");
		if (data != null)
			try {
				usuario.setHoraSaida(new Time(fmtData.parse(data).getTime()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if (request.getParameter("id") != null && request.getParameter("id") != "")
			usuario.setId(Integer.parseInt(request.getParameter("id")));

		usuario.setEmpresa(new Empresa());
		if (request.getParameter("idEmpresa") != null && request.getParameter("idEmpresa") != "")
			usuario.getEmpresa().setId(Integer.parseInt(request.getParameter("idEmpresa")));

		return usuario;
	}

}
