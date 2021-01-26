<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>

<!-- //fazendo o import -->
<%@ page import="java.util.List, br.com.alura.gerenciador.servlet.Empresa" %>

<!-- Importando a taglib jstl -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Usando Java Standard Taglib</title>
</head>
<body>

	<h2>Cadastro de Empresas</h2>
		
		<!-- if para caso ter cadastrado a empresa no formulario -->
		<c:if test="${ not empty empresa }">
			A empresa ${ empresa } cadastrada com sucesso!
		</c:if>
		
		<!-- if para caso nao ter cadastrado nenhuma empresa no formulario ou quando acessar essa pagina diretamente -->
		<c:if test="${ empty empresa }">
			Nenhuma empresa cadastrada ainda!
		</c:if>
		
		<!-- fazendo a lista usando a biblioteca jstl -->
	<ul>
		<c:forEach items="${empresas}" var="empresa"> <!-- expression languages são para usar junto com as taglib  -->
			
			<li>${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/> </li>
		
		</c:forEach>
	</ul>
		
</body>
</html>