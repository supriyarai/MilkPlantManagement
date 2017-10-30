<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="get" action="OrderServlet">
            <center>
            <table border="1" width="30%" cellpadding="3">
                <thead>
                    <tr>
                        <th colspan="2">Make the Order</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Order Id</td>
                        <%out.println(request.getParameter("idOfOrder"));%>
                        <td><input type="text" name="orderid" value=${idOfOrder} } /></td>
                    </tr>
                    <tr>
                        <td>Product Name</td>
                        <td><input type="text" name="productName" value="<%=request.getParameter("ProductNames")%>" /></td>
                    </tr>
                     <tr>
                        <td>User Id</td>
                        <td><input type="text" name="userId" value="" /></td>
                    </tr>
                     <tr>
                        <td>Number Of Qunatity</td>
                        <td><input type="text" name="quantity" value="<%=request.getParameter("Enter the packets to be oredered") %>" /></td>
                    </tr>
                    <tr>
                    <th colspan="2">
                        <input type="submit" name="action" value="PlaceOrder" /></th>
                        
                    </tr>
                   
                </tbody>
            </table>
            </center>
        </form>
</body>
</html>