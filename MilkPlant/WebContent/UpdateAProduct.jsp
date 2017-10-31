<%@page import="com.allianz.serviceImplementation.ProductServiceImplementation"%>
<%@page import="com.allianz.dao.daoImplementation.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.*" %>
 <%@ page import="com.allianz.dto.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ProductServlet" method="get">
<center>
Product to be selected
<%
ProductServiceImplementation product= new ProductServiceImplementation();
List<ProductDto> products=product.getAllProduct();
 %>
  <select label="Product List" List="products" name="product">
  <%
  for(int i=0;i<products.size();i++)
  {%>
	    <option value="<%= (products.get(i).getProductName()) %>"><%= (products.get(i).getProductName()) %></option>
  <%}
  %>
    </select>
    <br>
    <br>
    <br>
    <tr>
    <td>Updated Price of this product</td>
    <input type="text" name="Updated Price of this product" value="" />
    <th colspan="2">
                        <input type="submit" name="action" value="updateProduct" />
                        </th>
                        </tr>
                   </br>
                   <tr>
                        <th colspan="2"> <a href="DashBoard.jsp">Home</a></br></br>
</th>
                    </tr>     
    </center>
    
    </form>
</body>
</html>