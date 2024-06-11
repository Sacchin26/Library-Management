<%@ page import="com.besant.models.Book" %>

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
<% Integer book=(Integer)request.getAttribute("aa");%>
<p>BOOKID:<%=book %> ${requestScope.bb }</p><br><br>

<jsp:include page="GetBookAll.jsp"/>

</body>
</html>