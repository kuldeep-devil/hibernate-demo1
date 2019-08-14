<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Welcome ${bean.name} please fill below datails</h3>

<form action="examcodecheck" method="post">
<select name="title">
<option value="SPRING CORE" selected="selected">SPCR :SPRING CORE</option>
<option value="SPRING BOOT">SPBT :SPRING BOOT</option>
</select>
<input type="submit" value="submit">
</form>
</body>
</html>