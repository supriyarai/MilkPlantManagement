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
            <table border="1" width="30%" cellpadding="5">
                <thead>
                    <tr>
                        <th colspan="2">Enter Product Details Here</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Product Name</td>
                        <td><input type="text" name="Pname" value="" /></td>
                    </tr>
                    <tr>
                        <td>Product Price</td>
                        <td><input type="text" name="Pprice" value="" /></td>
                    </tr>
                    <tr>
                        <td>Product Category</td>
                        <td><input type="text" name="Pcategory" value="" /></td>
                    </tr>
                    <tr>
                        <td>Plant Name</td>
                        <td><input type="text" name="plantName" value="" /></td>
                    </tr>
                    
                    <tr>
                    
                       <th colspan="2">
                        <input type="submit" name="action" value="addProduct" />
                        </th>
                    </tr>
                    <tr>
                        <th colspan="2"> <a href="DashBoard.jsp">Home</a></br></br>
</th>
                    </tr>
                   
                </tbody>
            </table>
            </center>
            </form>
</body>
</html>