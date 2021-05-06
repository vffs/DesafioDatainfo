<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="css/form.css">
</head>
<body>
	<jsp:include page="menu.jsp" />
	<div class="container-fluid ">

		<form action="LoginServlet" method="post">
			<small style="color: red"> <%
 	if (request.getAttribute("falhalogin") == "Falhou") {
 %>
				<span>Usuário ou senha incorreta!</span>
				<%
					}
				%></small>
			<h2 class="text-center">Login</h2>
			<div class="form-group">
				<label for="usr">Email:</label> <input type="text"
					class="form-control" name="eml" id="eml"  required>
			</div>
			<div class="form-group">
				<label for="psw">Senha:</label> <input type="password"
					class="form-control" name="psw" id="psw" maxlength="15"
					pattern="[A-Za-z0-9]*" required>
			</div>
			<div class="text-center">
				<input type="submit" class="btn btn-primary" value="Entrar">
				<input type="reset" class="btn btn-primary" value="Limpar">
			</div>
		</form>

	</div>

</body>
</html>