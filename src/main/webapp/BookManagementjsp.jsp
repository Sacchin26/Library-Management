
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.css">



<body class="container-fluid card" style="width:40rem;">
<h2 class="bg-blue text-blue text-center">BOOK MANAGEMENT</h2><br><br>

<style>

body{
	
	background-image: url("book1.jpg");

background-position: right top;
background-attachment: fixed
}
</style>
</head>
<body>


<jsp:include page="CreateBook.jsp"/><br><br>
<jsp:include page="GetBookAll.jsp"/><br><br>
<jsp:include page="GetByIdData.jsp"/><br><br>
<jsp:include page="DeletedById.jsp"/><br><br>
<jsp:include page="UpdateBooK.jsp"/><br><br>
<jsp:include page="Getbyprice.jsp"/><br><br>


</body>
</html>