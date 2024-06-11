<%@ page import="com.besant.models.Book" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
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
<h1>BOOK TABLE</h1>
<table border="1">
   <tr>
       <th>BOOKID</th>
       <th>BNAME</th>
       <th>AUTHOR</th>
       <th>PRICE</th>
       <th>QUNTITY</th>
   </tr>
   <% Book b=(Book)request.getAttribute("aa"); %>
    <tr>
      <td> <%=b.getBookid()%></td>
      <td> <%=b.getBname()%></td>
      <td> <%=b.getAuthor() %></td>
      <td> <%=b.getPrice() %></td>
      <td><%=b.getQuntity() %></td>
  </tr>
  </table>
</body>
</html>