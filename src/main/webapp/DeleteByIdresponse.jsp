<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style >

body{
	
	background-image: url("book1.jpg");

background-position: right top;
background-attachment: fixed
}
</style>
</head>
<body>
<%Integer r=(Integer)request.getAttribute("bb"); %>

<p>BOOKID:<%=r %> ${requestScope.aa }</p>
</body>
</html>