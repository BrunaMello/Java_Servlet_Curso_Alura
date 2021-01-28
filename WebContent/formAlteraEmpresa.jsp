<!-- Importando a taglib jstl -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!-- declarando a variavel para o endereco da pagina -->
<c:url value="/alteraEmpresa" var="linkServletAlteraEmpresa"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

	<!-- chamando a variavel dde endereco -->
	<form action="${ linkServletAlteraEmpresa }" method="POST">
		
		Nome : <input type="text" name="nome" value="${ empresa.nome }" />
		Data Abertura : <input type="text" name="data" value="<fmt:formatDate value="${ empresa.dataAbertura }" pattern="dd/MM/yyyy"/>" />
		<input type="hidden" name="id" value="${ empresa.id }"  />
		
		<input type="submit">
		
	</form>

</body>
</html>