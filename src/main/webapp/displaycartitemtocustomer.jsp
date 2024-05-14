<%@page import="com.jsp.ShoppingCart.dto.Item"%>
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
<%List<Item> items=(List<Item>)request.getAttribute("itemslist"); 
double totalprice=(double)request.getAttribute("totalprice");%>
<table cellpading="20px" border="1">
<th>Brand</th>
<th>Model</th>
<th>Category</th>
<th>Quantity</th>
<th>Price</th>
<%for(Item i:items) {%>
<tr>
<td><%=i.getBrand() %></td>
<td><%=i.getModel()%></td>
<td><%=i.getCategory() %></td>
<td><%= i.getQuantity()%></td>
<td><%= i.getPrice()%></td>

</tr>
<%} %>
<td colspan="4" style="text-align: center;"><a href="addorder">Buy Now</a></td>
<td>Total Price:<%=totalprice %></td>
</table>
</body>
</html>

