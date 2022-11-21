<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="Messages">

	<c:forEach var="M" items="${Msg}" varStatus="Status">
			
		<c:set var="Type" 	 value="${M.substring(0,1).toUpperCase().trim()}"/>
		<c:set var="Message" value="${M.substring(1).trim()}"/>	
	
		<c:choose>
			<c:when test='${Type.equals("S")}'>
				<c:set var="Title" value="Sucesso!"/>
				<c:set var="Class" value="Success"/>
				<c:set var="Icon" value="fa-solid fa-circle-check"/>
			</c:when>
	
			<c:when test='${Type.equals("E")}'>
				<c:set var="Title" value="Erro!"/>
				<c:set var="Class" value="Error"/>
				<c:set var="Icon" value="fa-solid fa-triangle-exclamation"/>
			</c:when>
	
			<c:when test='${Type.equals("A")}'>
				<c:set var="Title" value="Aviso!"/>
				<c:set var="Class" value="Warning"/>
				<c:set var="Icon" value="fa-solid fa-circle-exclamation"/>
			</c:when>
	
			<c:when test='${Type.equals("I")}'>
				<c:set var="Title" value="Informa��o!"/>
				<c:set var="Class" value="Info"/>
				<c:set var="Icon" value="fa-solid fa-circle-info"/>
			</c:when>
		</c:choose>
			
		<div id="Massage-${Status.count}" class="MainBoxMessage ${Class}">
			<div class="MainBoxMessage_Title">
				<div class="TitleIcon">
					<i class="${Icon}" style="margin-right: 10px; font-size: 30px;"></i>
					<p>${Title}</p>
				</div>
				<i class="fa-solid fa-xmark" onclick="CloseMessage('#Massage-${Status.count}')" style="margin: 5px; cursor: pointer; padding: 10px;"></i>
			</div>
			<div class="MainBoxMessage_Message">
				<p>${Message}</p>
			</div>
		</div>
	
	</c:forEach>

</section>

<c:set var="Msg" value="${Msg.clear()}"/>

