<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css.css" type="text/css">
<title>Agenda salle</title>
</head>
<body>

	<h3><c:out value="${requestScope.salle.salNom }" /></h3>
	
	<p>
		description : la salle <c:out value="${requestScope.salle.salNom }" /> est une salle avec une capacité de
		<c:out value="${requestScope.salle.salCapacité }" /> personnes, situé aux <c:out value="${requestScope.salle.salAdresse }" /> 
	</p>
	
	<h4>Gestionnaire</h4>
	
	<c:choose>
			<c:when test="${empty requestScope.salle.tGestionnaireGstGstId.gstAssocPres}">
				<p>
					contacter : <c:out value="${requestScope.salle.tGestionnaireGstGstId.gstPers}" />
				</p>
			</c:when>
			<c:otherwise>
				<p>
				    contacter l'association  <c:out value="${requestScope.salle.tGestionnaireGstGstId.gstAssocNom}" />
				    ou le président <c:out value="${requestScope.salle.tGestionnaireGstGstId.gstAssocPres}" />
				</p>	
			</c:otherwise>
	</c:choose>
	
	
	<c:choose>
			<c:when test="${empty requestScope.salle.tSoireesorSet}">
				<p>
					<i>Aucune réservation de prévu</i>
				</p>
			</c:when>
			<c:otherwise>
			<p>
			<h4>Liste soirée :</h4>
				<ul>
					<c:forEach items="${requestScope.salle.tSoireesorSet}" var="s">
						<li>${s.sorNom}
						<c:choose>
							<c:when test="${empty s.tConcertconSet}">		
							</c:when>
							<c:otherwise>
							<ul>
								<c:forEach items="${s.tConcertconSet}" var="c">
									<li>
										${c.conId}
									</li>
								</c:forEach>
							</ul>
							</c:otherwise>
						</c:choose>
							
						
						</li>
					</c:forEach>
				</ul>
		    </p>
			</c:otherwise>
	</c:choose>


</body>
</html>