 <%@page import="com.jsp.ShoppingCart.dto.Customer"%>
<%@page import="com.jsp.ShoppingCart.dto.Merchant"%>
<%@page import="com.jsp.ShoppingCart.dto.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%List<Product> products =(List<Product>)request.getAttribute("productslist"); %>
<h1><a href="fetchitemsfromcart">view Cart</a></h1>
<table cellpadding="20px" border="1">
<th>brand</th>
<th>model</th>
<th>category</th>
<th>price</th>
<th>Add TO Cart</th>
<% for(Product p: products)
	{%>
	<tr>
	<td><%=p.getBrand() %></td>
	<td><%=p.getModel()%></td>
	<td><%=p.getCategory()%></td>
	<td><%=p.getPrice() %></td>
	<td><a href="additem?id=<%=p.getId()%>">add</a></td>
	</tr>
	<%} %>
</table>
</body>
</html>