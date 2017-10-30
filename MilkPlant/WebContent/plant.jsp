<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="PlantServlet" method="get">
 <center>
            <table border="1" width="30%" cellpadding="3">
                <thead>
                    <tr>
                        <th colspan="2">Enter new plant</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Plant Name</td>
                        <td><input type="text" name="plantName" value="" /></td>
                    </tr>
                    <tr>
                        <td>Plant Location</td>
                        <td><input type="text" name="plantLoction" value="" /></td>
                    </tr>
                    <tr>
                        <td>Plant City</td>
                        <td><input type="text" name="plantCity" value="" /></td>
                    </tr>
                   
                    <tr>
                    <th colspan="2">
                        <input type="submit" name="action" value="addPlant" />
                    </tr>
                   
                </tbody>
            </table>
            </center>
            </form>
</body>
</html>