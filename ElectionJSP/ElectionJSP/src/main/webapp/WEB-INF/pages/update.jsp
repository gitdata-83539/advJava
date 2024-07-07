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
	<jsp:useBean id="ub" class="com.sunbeam.jbeans.UpdateBean">
	<jsp:setProperty name="ub" property="id" param="id"/>
	<jsp:setProperty name="ub" property="name" param="name"/>
	<jsp:setProperty name="ub" property="party" param="party"/>
	<jsp:setProperty name="ub" property="votes" param="votes"/>
	${System.out.println(ub.toString())}
	${ub.updateCand()}
	<c:choose>
	<c:when test="${ub.count>0 }">
	<jsp:forward page="ctl?page=result"></jsp:forward>
	</c:when>
	</c:choose>
	</jsp:useBean>
</body>
</html>