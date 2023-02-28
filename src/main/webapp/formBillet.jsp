<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Achetet billet</title>
</head>
<body>
	Date : <c:out value="${requestScope.concert.conDateDebut }" /> -  <c:out value="${requestScope.concert.conDateFin }"/>
	Prix à l'unité (euro) : <c:out value="${requestScope.concert.conPrix }" />
	<form action="SoireeServlet?operation=acheterBillet" method="post">
		<p>
			<label for="adresseMail">email </label>
			<input name="adresseMail" required>
			</br>
			<label for="nbBillet">nbBillet </label>
			<input name="nbBillet" value=1 required>
			<input type=hidden name="concert" value=${requestScope.concert.conId} required>
		</p>

		<p>
			<input type="submit" value="confirmer">
		</p>
	</form>
</body>
</html>