<%@page import="com.allianz.serviceImplementation.ProductServiceImplementation"%>
<%@page import="com.allianz.dto.ProductDto"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="OrderServlet" method="get">
<center>


<%
List<String> list=(List)request.getAttribute("ProductNameList");

 %>
 <select name="ProductNames">
 <%
  for(String sets:list)
  {%>
  
	    <option value="<%= (sets) %>"><%=(sets) %></option>
  <%}%>
  </select>
  
  
  <tr>
                        <td>Enter the packets to be oredered</td>
                        <td><input type="text" name="Enter the packets to be oredered" value="" /></td>
                    </tr>
  
  
  
  <br>
  <br>
  <input type="submit" name="action" value="CheckAvailability" />
  
  ${notAvail}
   
  </center>
  
</form>
					
</body>
</html>