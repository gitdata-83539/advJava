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
<jsp:useBean id="lb" class="com.sunbeam.jbeans.RegisterBeans" />
<jsp:setProperty name="lb" property="*"/>
<%-- <jsp:setProperty name="lb" property="lastName" param="lastName"/>
<jsp:setProperty name="lb" property="email" param="email"/>
<jsp:setProperty name="lb" property="password" param="password"/>
<jsp:setProperty name="lb" property="dob" param="dob"/>
<jsp:setProperty name="lb" property="role" param="role"/>
<%lb.insertUser(); %>
<%if (lb.getCount()>0){ %>
<jsp:forward page="index.jsp" />
<%} %>--%>
${ lb.insertUser() }

<c:choose>
	<c:when test="${ lb.getCount()>0 }">
		<jsp:forward page="ctl?page=index" />
	</c:when>
</c:choose>		
</body>
</html>