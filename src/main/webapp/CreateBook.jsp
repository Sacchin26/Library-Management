<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.css">

</head>
<body class="container-fluid card" style="width:40rem;">
<h2 class="bg-danger text-white text-center">BOOK REGISTRATION</h2>

<form action="form" method="post">
<table class="table table-hover">
<tr>
<td>BNAME: </td><td><input type="text" name="bname"></td>
</tr>
<tr>
<td>AUTHOR: </td><td><input type="text" name="author"></td>
</tr>
<tr>
<td>PRICE: </td><td><input type="number" name="price"></td>
</tr>
<tr>
<td>QUNTITY: </td><td><input type="number" name="quntity"></td>
</tr>

<tr>
<td>
<input type="submit" value="Register"></td>
<td><input type="reset" value="cancel"></td>
</tr>
</table>
</form>
</body>
</html>