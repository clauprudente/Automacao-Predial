<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Usuarios</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<c:import url="/menu.jsp"></c:import>

<div  class=container>
	<legend>
		Lista de usuarios   
		<a href="CrudController.do?page=create&entidadeName=empresa&_method=get" class="btn btn-primary"> <span class="glyphicon glyphicon-plus"></span> Nova Empresa </a>
	</legend>
	<table class="table table-striped">

		<tr>
			<th>Razão social</th>
			<th>CNPJ</th>
			<th>Hora Abertura</th>
			<th>Hora Fechamento</th>
			<th>Conjunto</th>
			<th></th>
		</tr>
		<thead></thead>
		<c:forEach var="empresa" items="${entidades}">
		<tr>
			<td>${empresa.razaoSocial}</td>
			<td>${empresa.cnpj}</td>
			<td>${empresa.horarioAbertura}</td>
			<td>${empresa.horarioFechamento}</td>
			<td>Coluna</td>
			<td>
				<a href="CrudController.do?id=${empresa.id}&entidadeName=empresa&_method=get&page=update">
<span class="glyphicon glyphicon-edit"></span>
			</a>
				<a href="CrudController.do?id=${empresa.id}&entidadeName=empresa&_method=delete" class="text-danger"><span class="glyphicon glyphicon-remove"></span></a> 
				 </td>
		</tr>
	</c:forEach>

</table>
</div>
<script type="text/javascript" scr="../js/npm.js"></script>
<script type="text/javascript" scr="../js/bootstrap.min.js"></script>

</body>
</html>