<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    <%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<f:form action="signupdata" method="post" modelAttribute="bean">
<table>
<caption><b>SignUp Table</b></caption>
<tr>
<td>name : </td>
<td><f:input path="Name"/></td>
</tr>
<tr>
<td>email : </td>
<td><f:input path="email"/></td>
</tr>
<tr>
<td>password : </td>
<td><f:input path="password"/></td>
</tr>
<tr>
<td>submit :</td>
<td><input type="submit" value="submit"></td>
</tr>

</table>
</f:form>

</body>
</html>