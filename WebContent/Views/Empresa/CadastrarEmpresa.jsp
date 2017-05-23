<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar Usuario</title>

</head>
<body>
<c:import url="/menu.jsp"></c:import>
	<div class="container">
		<form action="CrudController.do" method="post"
			class="panel panel-primary col-xs-12 col-md-6 col-md-offset-3">

			<header class="panel-heading">
			<h3>Cadastro Empresa</h3>
			</header>

			<div class="form-group">
				<label>CNPJ:</label> 
				<input type="text" name="cnpj" value="${entidade.cnpj}"
					class="form-control" />
			</div>
			<div class="form-group">
				<label>Razão Social:</label> 
				<input type="text" name="razaoSocial" value="${entidade.razaoSocial}"
					class="form-control" />
			</div>
			<div class="form-group">
				<label>Hora Abertura:</label> <input type="time" name="horarioAbertura"
					value="${entidade.horarioAbertura}" class="form-control" />
			</div>
			<div class="form-group">
				<label>Hora Fechamento:</label> <input type="time" name="horarioFechamento"
					value="${entidade.horarioFechamento}" class="form-control" />
			</div>
			<div class="form-group">
				<label>Hora Inicio do Ar:</label> <input type="time" name="horaIniAr"
					value="${entidade.horaIniAr}" class="form-control" />
			</div>
			<div class="form-group">
				<label>Hora Fim do Ar:</label> <input type="time" name="horaFimAr"
					value="${entidade.horaFimAr}" class="form-control" />
			</div>
			<div class="form-group">
				<label>Temperatura Padrão do Ar:</label> <input type="number" name="temperaturaPadrao"
					value="${entidade.temperaturaPadrao}" class="form-control" />
			</div>
			
			<div class="form-group">
				<label>Conjunto: </label>
				<select name="conjuntoId">
					<option>Selecione</option>
					<c:forEach var="conjunto" items="${conjuntos}">
						<option value="${conjunto.id }" >${conjunto.nrConjunto }</option>
					</c:forEach>
				</select>
			</div>
			
			
			
			<div class="form-group">
				<input type="hidden" name="entidadeName" value="empresa">
				<input type="hidden" name="_method" value="${_metodo}">
				<input type="hidden" name="id" value="${entidade.id}">
	            <input type="hidden" name="idConjunto" value="1">		
			</div>

			<div class="form-group">
				<input type="submit" value="cadastrar"
					class="btn btn-lg btn-primary pull-right">
			</div>
		</form>

	</div>

	
</body>
</html>