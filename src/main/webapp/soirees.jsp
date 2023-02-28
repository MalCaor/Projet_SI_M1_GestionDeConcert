<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css.css" type="text/css">
<title>Planning</title>
</head>
<body>
<a href="listeSoirees.html">Afficher toutes les soirées(vue js)</a>

<a href="SalleServlet?operation=listeSalles">liste salle </a>
	<h3>Liste de soirée organisé</h3>
	<table>
		<tr>
			<th>nom</th><th>salle</th><th>information concert</th>
		</tr>
	</table>
	<c:forEach items="${requestScope.soirees}" var="sp">
		<tr>
			<td>${sp.sorNom}</td>
			<td>${sp.sallId.salNom}</td>
			<td>
			<form action="SoireeServlet?operation=informationSoiree" method="post">
		<p>
			<input type="hidden" name="soiree" value="${sp.sorId}">
		</p>


			<input type="submit" value="details">
			
				</form>
			</td>
		</tr>
	</c:forEach>
	</table>
	<form action="SoireeServlet?operation=agendaSalle" method="post">
		<p>
			<input type="hidden" name="salleId" value="1">
		</p>


			<input type="submit" value="salle">
			
				</form>
</body>
</html>