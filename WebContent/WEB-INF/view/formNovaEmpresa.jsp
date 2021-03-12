<!-- Importando a taglib jstl -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!-- declarando a variavel para o endereco da pagina -->
<c:url value="/entrada" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<!-- chamando a variavel dde endereco -->
	<form action="${ linkEntradaServlet }" method="POST">
		
		Nome : <input type="text" name="nome" />
		Data Abertura : <input type="text" name="data" />
		<input type="hidden" name="acao" value="NovaEmpresa">
		
		<input type="submit">
		
	</form>

</body>
</html>