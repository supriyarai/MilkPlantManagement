<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="UserServlet" method="get">
 <center>
            <table border="1" width="30%" cellpadding="3">
                <thead>
                    <tr>
                        <th colspan="2">Login Here</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>User Name</td>
                        <td><input type="text" name="uname" value="" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="pass" value="" /></td>
                    </tr>
                    <tr>
                        <td>User Type</td>
                        <td><input type="text" name="userType" value="clerk" /></td>
                    </tr>
                    <tr>
                        <td>User Address</td>
                        <td><input type="text" name="userAddress" value="" /></td>
                    </tr>
                    
                    <tr>
                        <td>User Mobile</td>
                        <td><input type="text" name="userMobile" value="" /></td>
                    </tr>
                    <tr>
                    <th colspan="2">
                        <input type="submit" name="action" value="addClerk" />
                    </tr>
                   
                </tbody>
            </table>
            </center>
            </form>
</body>
</html>