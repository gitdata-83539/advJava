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
<jsp:useBean id="db" class="com.sunbeam.jbeans.DeleteBean">
<jsp:setProperty name="db" property="id" param="id"/>
${db.deleteById()}
<c:choose>
<c:when test="${db.count>0 }">
<jsp:forward page="result.jsp"></jsp:forward>
</c:when>

</c:choose>
</jsp:useBean>
</body>
</html>