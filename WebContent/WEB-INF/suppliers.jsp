<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fornecedores</title>
</head>
<body>
	<table>
	   <c:forEach items="${suppliers}" var="supplier">
	       	Item <c:out value = "${supplier.nome}"/>
	    </c:forEach>
	    
	</table>

</body>
</html>