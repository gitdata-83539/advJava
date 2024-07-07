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
	<jsp:useBean id="vb" class="com.sunbeam.jbeans.VoteBeans" />
	<jsp:setProperty name="vb" property="candidate" param="candidate"/>
	${ vb.incrementVote() }
	<c:choose>
	<c:when test="${ vb.getCount()>0 }">
		<h3>Voted sucessfully</h3>
		<a href="index.jsp">SignOut</a>
	</c:when>
	<c:otherwise>
		Error occured!!!
	</c:otherwise>	
	</c:choose>	
</body>
</html>