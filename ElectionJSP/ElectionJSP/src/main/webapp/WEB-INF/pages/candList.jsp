<%@page import="com.sunbeam.pojos.Candidate" %>
<%@ page import="java.util.List" %>
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
<h2>${initParam.appTitle}</h2>
<h2>${ab.ann}</h2>
<jsp:useBean id="lb" class="com.sunbeam.jbeans.CandBeans" />
<%--<% lb.getAll(); %>
     

<% List<Candidate> c1 = lb.getC(); %>
<% for (Candidate cand : c1) { %>
	<form method="post" action="vote.jsp">
  <input type='radio' name='candidate' value='<%= cand.getId() %>'/> <%= cand.getName() %> (<%= cand.getParty() %>) <br/>
<% } %>
<input type='submit' value='Vote'/>--%>
${ lb.getAll() }
<form method="post" action="ctl?page=vote">
<c:forEach var="cand" items="${lb.c }">
	<input type="radio" name="candidate" value="${cand.id}"/> ${ cand.name } ${ cand.party } <br/>
</c:forEach>	
<input type='submit' value='Vote'/>
</form>
</form>
</body>
</html>