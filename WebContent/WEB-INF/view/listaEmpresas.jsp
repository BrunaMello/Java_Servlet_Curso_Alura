<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>

<!-- //fazendo o import do servlet -->
<%@ page import="java.util.List,br.com.alura.gerenciador.model.Empresa" %>

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

	<a href="entrada?acao=Logout">Sair</a>
	
	<br>
	<br>
	 
	
	Usuario Logado: ${ usuarioLogado.login }
	
	<br>

	<h2>Cadastro de Empresas</h2>
		
		<!-- if para caso ter cadastrado a empresa no formulario -->
		<c:if test="${ not empty empresa }">
			A empresa ${ empresa } cadastrada com sucesso!
		</c:if>
		
		<!-- if para caso nao ter cadastrado nenhuma empresa no formulario ou quando acessar essa pagina diretamente -->
		<c:if test="${ !not empty empresa }">
			Nenhuma empresa cadastrada ainda!
		</c:if>
		
		<br/>
		
		<!-- fazendo a lista usando a biblioteca jstl -->
		
		Lista de empresas: <br/>
		
		<ul>
			<c:forEach items="${empresas}" var="empresa"> <!-- expression languages são para usar junto com as taglib  -->
				
				<li>${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/> 
					<a href="/gerenciador/entrada?acao=RemoveEmpresa&id=${empresa.id}">Remover</a>
					<a href="/gerenciador/entrada?acao=MostraEmpresas&id=${empresa.id}">Alterar</a>
				</li>
			
			</c:forEach>
		</ul>
		
</body>
</html>