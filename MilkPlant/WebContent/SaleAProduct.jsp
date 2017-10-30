<%@page import="com.allianz.dao.daoImplementation.ProductDao"%>
<%@page import="com.allianz.dto.ProductDto"%>
<%@page import="java.util.*"%>
<%@page import="com.allianz.serviceImplementation.ProductServiceImplementation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ProductServlet" method="get">
<center>
Category to be selected for sale
<%
ProductServiceImplementation product= new ProductServiceImplementation();
Set<String> set=product.getCategory();
 %>
 <select name="categories">
 <option value="Select Categories"><%= ("Select Categories") %></option>
 <option value="Select Categories"></option>
 <%
  for(String sets:set)
  {%>
  
	    <option value="<%= (sets) %>"><%= (sets) %></option>
  <%}%>
  </select>
  <br>
  <br>
  <input type="submit" name="action" value="selectCategories" /></br>
   ${notAvail}
  </center>
  


</form>
 </body>
</html>