<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="br.usjt.arqdsis.sisPredial.Models.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Visualizar Empresa</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body >
<c:import url="/menu.jsp"></c:import>
<div class="container">
<legend>Detalhes da Empresa</legend>
	<%
		Empresa emp = (Empresa) request.getAttribute("entidade");
	%>
	<div class="panel panel-success">
		<h2 class="panel-heading">
			<%=emp.getId()%>
			-
			<%=emp.getRazaoSocial()%></h2>
		<section class="panel-body" >
		<p><label>CNPJ:</label><%=emp.getCnpj()%></p>
			<p> <label>Horario Abertura:</label><%=emp.getHorarioAbertura()%></p>
			<p> <label>Hora Fechamento:</label><%=emp.getHorarioFechamento()%></p>
			<p> <label>Temperatura do Ar:</label><%=emp.getTemperaturaPadrao()%></p>
			<p> <label>Hora Inicio Ar:</label><%=emp.getHoraIniAr()%></p>
			<p> <label>Hora Fim Ar:</label><%=emp.getHoraFimAr()%></p>						
		</section>
	</div>
	</div>	
	
	<script type="text/javascript" scr="../js/npm.js"></script>
	<script type="text/javascript" scr="../js/bootstrap.min.js"></script>

</body>
</html>