<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="utf-8">
<title>Cadastro Usuário</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="css/form.css">
</head>

<body>
	<jsp:include page="menu.jsp" />
	<div class="container-fluid ">
		<form class="cadastro" action="CadastroServlet" method="POST">
		<% String mensagem = (String) session.getAttribute("mensagem"); %>
		<% if(mensagem != null){ %>
		<small style="color: green;"><%= mensagem %></small>
		<%}%>
		<% session.removeAttribute("mensagem"); %>
		<small style="color: red"></small>
		
			<h2 class="text-center">Cadastro</h2>
			<div class="form-group">
				<label for="nome" id="labelnome">Nome:</label> <input type="text"
					class="form-control" name="nome" id="nome" maxlength="50"
					required>
			</div>
			<div class="form-group">
				<label for="mail">E-mail:</label> <input type="email"
					class="form-control" name="email" id="mail" maxlength="30" required>
			</div>
			<div class="form-group">
				<label for="psw">Senha:</label> <input type="password"
					class="form-control" name="senha" id="psw" maxlength="15"
					pattern="[A-Za-z0-9]*" required>
			</div>
			<div class="form-group">
				<label for="fone">Telefones:</label>
				<div class="form-group ">
					<label for="ddd">DDD:</label> <input type="text"
						class="form-control" name="ddd" id="ddd" maxlength="3"
						required pattern="[?[0-9]{4}]">
				</div>
				<div class="form-group">
					<label for="fone">Número:</label> <input type="text"
						class="form-control" name="fone" id="fone" maxlength="10"
						required pattern="[(?[0-9]{4}-?[0-9]{4}]">
				</div>
				<div class="form-group">
					<label for="tipo">Tipo:</label> <input type="text"
						class="form-control" name="tipo" id="tipo" value="COMERCIAL" required>
				</div>
				<div class="form-group">
					<label for="dddCel">DDD:</label> <input type="text"
						class="form-control" name="dddCel" id="dddCel" maxlength="3"
						pattern="[(?[0-9]{4}]" required>
				</div>
				<div class="form-group">
					<label for="cel">Número:</label> <input type="text"
						class="form-control" name="cel" id="cel" maxlength="10"
						pattern="[(?[0-9]{4}-?[0-9]{4}]" required>
				</div>
				<div class="form-group">
					<label for="tipoCel">Tipo:</label> <input type="text"
						class="form-control" name="tipoCel" id="tipoCel" value="CELULAR"
						required>
				</div>			
	</div>

	<div class="text-center btn-orange">
		<button type="submit" class="btn btn-primary">Enviar</button>
		<button type="reset" class="btn btn-primary">Limpar</button>
	</div>
	</form>
	</div>
</body>
</html>
