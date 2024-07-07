<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="eb" class="com.sunbeam.jbeans.EditBean"/>
	<jsp:setProperty name="eb" property="id" param="id"/>
	${eb.getCand() }
	<h3>initParam.apptitle</h3>
	<form method="post" action="ctl?page=update">
	<input type='hidden' name='id' value="${eb.cd.id}"/>
	Name: <input type='text' name='name' value="${eb.cd.name}"/>
	Party: <input type='text' name='party' value="${eb.cd.party}"/>
	Votes: <input type='text' name='votes' value="${eb.cd.votes}"/>
	<input type='submit' value='Update'/>
	</form>
	
</body>
</html>