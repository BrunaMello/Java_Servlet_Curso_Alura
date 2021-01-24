<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>

<!-- //fazendo o import -->
<%@ page import="java.util.List, br.com.alura.gerenciador.servlet.Empresa" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

	<h2>Lista Empresas Cadastradas</h2>
	<ul>
	<%
		//chamando a lista de empresas para essa pagina 
		List<Empresa> lista = (List<Empresa>)request.getAttribute("empresas");
		for (Empresa empresa : lista) {
	%>
	<li><%= empresa.getNome() %></li>
	<% } 
		%>
	</ul>
		
</body>
</html>