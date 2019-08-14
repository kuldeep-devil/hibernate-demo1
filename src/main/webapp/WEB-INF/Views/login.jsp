<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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

<f:form action="logindata" method="post" modelAttribute="">
<table>
<caption><b>Login Table</b></caption>
<tr>
<td>email : </td>
<td><f:input type="email" path="email"/></td><f:errors path="email"></f:errors>
</tr>
<tr>
<td>password : </td>
<td><f:input type="password" path="password"/></td><f:errors path="password"></f:errors>
</tr>
<tr>
<td>submit :</td>
<td><input type="submit" value="submit"></td>
</tr>

</table>
<input type="submit" value="submit">
</f:form>

</body>
</html>