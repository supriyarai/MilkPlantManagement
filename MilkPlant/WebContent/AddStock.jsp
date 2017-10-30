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
<form  action="StockServlet">
            <center>
            <table border="1" width="30%" cellpadding="5">
                <thead>
                    <tr>
                        <th colspan="2">Enter Stock Details Here</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Product Name</td>
                     <% 
                     List<String> productName=(List)request.getAttribute("listOfProduct");
              
                     %>
                        <td>
                        
                        <select name="Pname">
<% 
for(String product:productName)
{
out.println(product);
%>
 <option value="<%=product %>"><%=product %></option>
<% 	
}
%>
     </select>  </td>                
                    </tr>
                    <tr>
                        <td>Stock Quantity</td>
                        <td><input type="text" name="Pquantity" value="" /></td>
                    </tr>
                    
                    <tr>
                    
                       <th colspan="2">
                        <input type="submit" value="addstock" name="action"/></th>
                    </tr>
                    
                   
                </tbody>
            </table>
            </center>
</form>

</body>
</html>