<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css.css" type="text/css">
<title><c:out value="${requestScope.soiree.sorNom }" /></title>
</head>
<body>

	<h3><c:out value="${requestScope.soiree.sorNom }" /></h3>
	<p>
		se déroule au <c:out value="${requestScope.soiree.sorNom}"/>
	</p>
	<c:forEach items="${requestScope.soiree.tConcertconSet}" var="sp">
		<p>
		salut
		</p>
		
	</c:forEach>
	
</body>
</html>
