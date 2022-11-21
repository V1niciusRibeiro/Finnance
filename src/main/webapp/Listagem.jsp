
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="pt-BR">
<head>

	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

  	<link rel="stylesheet" href="./Resources/CSS/reset.css">
	<link rel="stylesheet" href="./Resources/CSS/ListagemStyle.css">
	<link rel="stylesheet" href="./Resources/CSS/MovimentacaoTRN_Style.css">

	<script src="https://kit.fontawesome.com/7e3ab3f2af.js" crossorigin="anonymous"></script>

	<title>Finnance - ${Title}</title>

</head>
<body>

	<h1>${h1}</h1>

	<main>
		<section class="MainBox">
			<table class="MainBox_Table">
		
				<thead class="Table_Head">
					<tr>
						<c:forEach var="Value" items="${Titles}">
						
							<c:set var="Width" value="${Value.substring(1,3)}"/>
							<c:set var="Title_Head" value="${Value.substring(3)}"/>
				
							<c:choose>
								<c:when test="${Value.substring(0,1) == 'L'}">
									<c:set var="Align" value="left"/>
								</c:when>
								<c:when test="${Value.substring(0,1) == 'C'}">
									<c:set var="Align" value="center"/>
								</c:when>
								<c:when test="${Value.substring(0,1) == 'R'}">
									<c:set var="Align" value="rigth"/>
								</c:when>
							</c:choose>
				
							<th style="width: ${Width}%; text-align: ${Align};">${Title_Head}</th>

						</c:forEach>
					</tr>
					<tr>
						<td colspan="${Titles.size()}" style="padding: 0px;">
							<img src="./Resources/Images/TableDivider.png" alt="TableDividerGradient" style="width: 100%; height: 5px;">
						</td>
					</tr>
				</thead>
				
				<tbody>

					<c:choose>
						<c:when test="${Title.toUpperCase() == 'MOVIMENTAÇÕES'}">
							<%@ include file="TableMovimentacao.jsp" %>
						</c:when>
					</c:choose>

				</tbody>
				
			</table>
		</section>
		
		<c:if test='${param.Action.toUpperCase().trim() != "SHOW"}'>
			<%@ include file="MovimentacaoTRN.jsp" %>
		</c:if>
		
	</main>

<script type="text/javascript" src="./Resources/JS/MovimentacaoPopupApp.js"></script>

</body>
</html>