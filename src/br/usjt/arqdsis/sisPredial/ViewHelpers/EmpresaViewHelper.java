package br.usjt.arqdsis.sisPredial.ViewHelpers;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import br.usjt.arqdsis.sisPredial.Models.Conjunto;
import br.usjt.arqdsis.sisPredial.Models.Empresa;
import br.usjt.arqdsis.sisPredial.Models.IEntidade;

public class EmpresaViewHelper implements IViewHelper {

	@Override
	public IEntidade criar(HttpServletRequest request) {

		Empresa empresa = new Empresa();
		
		DateFormat fmtData = new SimpleDateFormat("HH:mm");
		String data = request.getParameter("horarioAbertura");
		if (data != null)
			try {
				empresa.setHorarioAbertura(new Time(fmtData.parse(data).getTime()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		data = request.getParameter("horarioFechamento");
		if (data != null)
			try {
				empresa.setHorarioFechamento(new Time(fmtData.parse(data).getTime()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		data = request.getParameter("horaIniAr");
		if (data != null)
			try {
				empresa.setHoraIniAr(new Time(fmtData.parse(data).getTime()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		data = request.getParameter("horaFimAr");
		if (data != null)
			try {
				empresa.setHoraFimAr(new Time(fmtData.parse(data).getTime()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		if (request.getParameter("id") != null && request.getParameter("id") != "")
			empresa.setId(Integer.parseInt(request.getParameter("id")));

		empresa.setCnpj(request.getParameter("cnpj"));
		empresa.setRazaoSocial(request.getParameter("razaoSocial"));
		if(request.getParameter("temperaturaPadrao") != null && request.getParameter("temperaturaPadrao") != "")
			empresa.setTemperaturaPadrao(Integer.parseInt(request.getParameter("temperaturaPadrao")));
		
		
		empresa.setConjunto(new Conjunto());
		if (request.getParameter("idConjunto") != null && request.getParameter("idConjunto") != "")
			empresa.getConjunto().setId(Integer.parseInt(request.getParameter("idConjunto")));
		
		return empresa;

	}

}
