<%@ page language="Java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
	<s:form action="textaCics" method="post">
		<s:label name="Nome do programa CICS" />
		<s:label name="Nome da transação CICS" />
		<s:label name="Tamanho da CommArea" />
		<s:textarea  />
		<s:textarea />
	</s:form>
</body>
</html>