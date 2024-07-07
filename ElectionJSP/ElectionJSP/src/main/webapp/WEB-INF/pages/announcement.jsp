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
<h3>Online Voting</h3>
	<form method="post" action="announce.jsp">
		Announcement: <br/>
		<textarea name="ann" rows="6" cols="80"></textarea>
		<br/><br/>
		<input type="submit" value="Announce"/>
	</form>
</body>
</html>