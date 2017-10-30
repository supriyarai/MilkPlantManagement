<%@page import="com.allianz.dto.OrderDto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
OrderDto order=(OrderDto)request.getAttribute("orderDetails");
out.println(order.getTotalPrice());
%>
<form >
            <center>
            <table border="1" width="30%" cellpadding="3">
                <thead>
                    <tr>
                        <th colspan="2">Receipt are:</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Order Id</td>
                        <td><input type="text" name="orderId" value="<%=request.getParameter("orderid")%>" /></td>
                    </tr>
                    <tr>
                        <td>Product Name</td>
                        <td><input type="text" name="productName" value="<%=request.getParameter("productName")%>" /></td>
                    </tr>
                     <tr>
                        <td>User Id</td>
                        <td><input type="text" name="userId" value="<%=request.getParameter("userId")%>" /></td>
                    </tr>
                     <tr>
                        <td>Number Of Qunatity</td>
                        <td><input type="text" name="quantity" value="<%=request.getParameter("quantity")%>" /></td>
                    </tr>
                     <tr>
                        <td>Total Price</td>
                        <td><input type="text" name="price" value="<%=order.getTotalPrice()%>" /></td>
                    </tr>
                    <tr>
                    <th colspan="2">
                        <a href="DashBoard.jsp">Home</a></th>
                        
                    </tr>
                   
                </tbody>
            </table>
            </center>
</body>
</html>