<%@page import="com.allianz.dao.daoImplementation.UserDaoImp"%>
<%@page import="com.allianz.dto.UserDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<form action="ProductServlet" method="post"></form>
<form action="UserServlet" method="get" ></form>

<center>
	<a href="ProductServlet?action=addProductServletLink">AddAProductServletLink</a>
	<br>
	<br>
	<a href="ProductServlet?action=updateProductServletLink">UpdateAProduct</a>
	<br>
	<br>
	<a href="ProductServlet?action=saleProductServletLink">SaleAProduct</a>
		<br>
	<br>
	<a href="StockServlet?action=addStocklink">Add Stock</a>
	<br>
	<br>
	<a href="StockServlet?action=updateStocklink">update the stock</a>
	</center>

</center>
</body>
</html>