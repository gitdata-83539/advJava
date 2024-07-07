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
	<jsp:useBean id="lb" class="com.sunbeam.jbeans.LogginBeans" scope="session"/>
	<jsp:setProperty name="lb" property="email" param="email" />
	<jsp:setProperty name="lb" property="password" param="password" />
	<%--<% lb.authenticate(); %>
	<% if(lb.getUser()!=null){ %>
	      Hello, <jsp:getProperty name="lb" property="email"/>
	      <jsp:forward page="candList.jsp" />
	      <%} else { %>
	      Login Failed
	      <%} %>--%>
	      ${ lb.authenticate() }
	      <c:choose>
	      	<c:when test="${ lb.user!=null && lb.user.role=='voter'}">
	      		<%-- <c:redirect url="ctl?page=candList"/>--%>
	      		<jsp:forward page="/ctl">
		        <jsp:param name="page" value="candList"/>
	            </jsp:forward>
	      	</c:when>
	      	<c:when test="${ lb.user != null && lb.user.role == 'admin'}">
	      		<jsp:forward page="/ctl">
		        <jsp:param name="page" value="result"/>
	            </jsp:forward>
	      	</c:when>
	      	<c:otherwise>
	      		Login Failed
	      	</c:otherwise>
	      	
	      </c:choose>
	      	
	      		
</body>
</html>