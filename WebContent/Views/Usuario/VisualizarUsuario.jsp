<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="br.usjt.arqdsis.sisPredial.Models.Usuario"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Visualizar Usuario</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body >
<c:import url="/menu.jsp"></c:import>
<div class="container">
<legend>Detalhes do Usuario</legend>
	<%
		Usuario usr = (Usuario) request.getAttribute("entidade");
	%>
	<div class="panel panel-success">
		<h2 class="panel-heading">
			<%=usr.getId()%>
			-
			<%=usr.getNome()%></h2>
		<section class="panel-body" >
		<p><label>CPF:</label><%=usr.getCPF()%></p>
			<p> <label>Hora	Entrada:</label><%=usr.getHoraAcesso()%></p>
			<p> <label>Hora Saida:</label><%=usr.getHoraSaida()%></p>
			<p><label>Login:</label><%=usr.getLogin()%></p>
			<p> <label>Privilegio:</label><%=usr.getPerfil().name()%></p>
		</section>
	</div>
	</div>
	
	
	<script type="text/javascript" scr="../js/npm.js"></script>
	<script type="text/javascript" scr="../js/bootstrap.min.js"></script>

</body>
</html>