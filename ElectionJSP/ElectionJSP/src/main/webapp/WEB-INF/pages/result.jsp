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
<h1>hello admin</h1>
<jsp:useBean id="rb" class="com.sunbeam.jbeans.ResultBean">
${rb.getAll() }
<table border="1px solid black" width="500px" height="500px">
<thead>
<tr>
<th>id</th>
<th>Name</th>
<th>Party</th>
<th>Votes</th>
<th colspan="2">Action</th>
</tr>
</thead>
<tbody>
<c:forEach var="cand" items="${rb.clist }">
	<tr>
	<td>${cand.id }</td>
	<td>${cand.name }</td>
	<td>${cand.party }</td>
	<td>${cand.votes }</td>
	<td><a href="ctl?page=edit&id=${cand.id}">Edit</a></td>
	<td><a href="ctl?page=delete&id=${cand.id}">Delete</a></td>
	</tr>
</c:forEach>	
</tbody>
</table>
<h3><a href="announcement.jsp">Announce</a></h3>
<h3><a href="logout.jsp">Signout</a></h3>
</jsp:useBean>
</body>
</html>