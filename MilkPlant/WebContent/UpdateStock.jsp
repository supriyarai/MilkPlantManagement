<%@page import="java.util.List"%>
<%@page import="com.allianz.serviceImplementation.StockServiceImplementation"%>
<%@page import="com.allianz.serviceInterface.StockServiceInterface"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form  action="StockServlet">
<% 
StockServiceInterface productDto=new StockServiceImplementation();
List<String> list=productDto.listOfProduct();
%>

 <center>
 Select the product:
<select name="product">
<% 
for(String product:list)
{
out.println(product);
%>
 <option value="<%=product %>"><%=product %></option>
<% 	
}
%>
</select >
</br>
Quantity to be added:
<input type="text" name="quantity" value="" /></br>
     <input type="submit" value="updateStock" name="action"/></th>
</center>
</form>




</body>
</html>