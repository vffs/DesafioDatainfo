<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="bootstrap/css/bootstrap.css">
<title>Index Logado</title>
</head>
<body>
<jsp:include page="menuLogado.jsp" />
<p >
				Bem vindo(a)
				<%=request.getAttribute("nameUser")%>
			</p>
</body>
</html>