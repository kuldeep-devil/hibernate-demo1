<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>hello inside question</h1>

<form action="result" method="post">
<table border="1">
<caption>Student examination</caption>
<tr>
<th>Date</th>
<th>Duration in min</th>
<th>Exam Name</th>
<th>Total marks</th>
</tr>
<tr>
<td>${exam.date}</td>
<td>${exam.duration}</td>
<td>${exam.title}</td>
<td>${exam.totalmarks}</td>
</tr>
<tr></tr>
<tr></tr>
<c:forEach items="${question}" var="question">
<c:set var="i" value="${i+1}"></c:set>
<tr>
<td>Question <c:out value="${i}"/></td>
<td colspan="3">${question.question}</td>
</tr>
<tr>

<td><input type="radio" name="<c:out value="option${i}"/>" value="${question.option1}">${question.option1}</td>
<td><input type="radio" name="<c:out value="option${i}"/>" value="${question.option2}">${question.option2}</td>
<td><input type="radio" name="<c:out value="option${i}"/>" value="${question.option3}">${question.option3}</td>
<td><input type="radio" name="<c:out value="option${i}"/>" value="${question.option4}">${question.option4}
<input type="hidden" name="<c:out value="qid${i}"/>" value="${question.qid}"></td>
</tr>
</c:forEach>
<tr>
<td>Submit</td>
<td colspan="3"><input type="submit" value="submit"></td>
</tr>
</table>
</form>
</body>
</html>