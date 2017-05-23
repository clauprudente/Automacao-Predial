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
			<h3>Cadastro Usuario</h3>
			</header>

			<div class="form-group">
				<label>CPF:</label> 
				<input type="text" name="cpf" value="${entidade.CPF}"
					class="form-control" />
			</div>
			<div class="form-group">
				<label>Empresa:</label> 
				<select value="${entidade.empresa.id}" name="idEmpresa"
					class="form-control">
					<option>Selecione...</option>
					<c:forEach var="empresa" items="${empresas}">
						<option value="${empresa.id}"> ${empresa.razaoSocial}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label>Hora Acesso:</label> <input type="time" name="horaAcesso"
					value="${entidade.horaAcesso}" class="form-control" />
			</div>
			<div class="form-group">
				<label>Hora Saida:</label> <input type="time" name="horaSaida"
					value="${entidade.horaSaida}" class="form-control" />
			</div>
			<div class="form-group">
				<label>Login:</label> <input type="text" name="login" value="${entidade.login}"
					class="form-control" />
			</div>
			<div class="form-group">
				<label>senha:</label> <input type="password" name="senha"
					value="${entidade.senha}" class="form-control" />
			</div>
			<div class="form-group">
				<label>nome:</label> <input type="text" name="nome" value="${entidade.nome}"
					class="form-control" />
			</div>
			<div class="form-group">
				<label>perfil:</label> <select name="perfil" value="${entidade.perfil}"
					class="form-control">
					<option>Selecione...</option>
					<option value="Admin">Administrador</option>
					<option value="comum">Comum</option>
					<option value="comumComPrivilegio">Comum com Privilegio</option>
				</select>
			</div>
			<div class="form-group">
				<input type="hidden" name="entidadeName" value="usuario">
				<input type="hidden" name="_method" value="${_metodo}">]
				<input type="hidden" name="id" value="${entidade.id}">
			</div>

			<div class="form-group">
				<input type="submit" value="cadastrar"
					class="btn btn-lg btn-primary pull-right">
			</div>
		</form>

	</div>

	
</body>
</html>