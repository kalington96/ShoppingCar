<%@page import="com.jsp.ShoppingCart.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>	
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%Product p=(Product)request.getAttribute("productobj"); %>
<form action="additemtocart">
id : <input type="hidden" name="id" value=<%=p.getId()%>  readonly="true"><br>
Brand : <input type="text" name="brand" value=<%=p.getBrand()%> readonly="true"><br>
Model : <input type="text" name="model" value=<%=p.getModel()%> readonly="true"><br>
Category : <input type="text" name="category" value=<%=p.getCategory()%> readonly="true"><br>
Price : <input type="number" name="price" value=<%=p.getPrice()%> readonly="true"><br>
Quantity : <input type="number" name="quantity" ><br>
<input type="submit" value="Add To Cart"> 

</form>
</body>
</html>