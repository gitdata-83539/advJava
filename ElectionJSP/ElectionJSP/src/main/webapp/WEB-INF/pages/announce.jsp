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
<jsp:useBean id="ab" class="com.sunbeam.jbeans.Announce" scope="application">
<jsp:setProperty name="ab" property="ann" param="ann"/>
${ab.toString()}
<jsp:forward page="result.jsp"></jsp:forward>
</jsp:useBean>
</body>
</html>