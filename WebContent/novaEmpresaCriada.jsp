<%
 //Scriplet
 //pegando a requisicao 
 String nomeEmpresa = (String)request.getAttribute("empresa");
 System.out.println(nomeEmpresa);
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

<h2>Cadastro de Empresas</h2>

A empresa <%= nomeEmpresa %> cadastrada com sucesso!

</body>
</html>