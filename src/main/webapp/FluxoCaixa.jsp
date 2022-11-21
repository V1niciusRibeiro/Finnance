
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="MainBox">

	<p class="MainBox_Title">
		Fluxo de Caixa - ${MonthInFull}
	</p>

	<div class="MainBox_Total">	
		<p class="Total_Title">Saldo</p>
		<p class="Total_Value">${(ValuesError_FC == null) ? ContaSaldo : ValuesError_FC}</p>
	</div>
	
	<div style="width: 100%;">
		<div class="MainBox_Values">
		
			<div class="Values_Movement">
				<div class="Movement_Total">
					<img src="./Resources/Images/ArrowUp_Green.svg" alt="ArrowUp_Green">
					<div>
						<p class="Movement_Title">Receitas</p>
						<p class="Movement_Value Green">${(ValuesError_FC == null) ? TotalReceita : ValuesError_FC}</p>
					</div>
				</div>
				<c:forEach var="Receita" items="${Receitas}">
					<div class="Movement_Details Hide">
						<p class="Movement_Title"><fmt:formatDate pattern="dd/MM/yyyy" value="${Receita.dt_movimentacao.getTime()}"/></p>
						<p class="Movement_Value Green"><fmt:formatNumber value="${Receita.vl_movimentacao}" type="currency" /></p>
					</div>
				</c:forEach>
				<c:forEach var="Remaining_Rec" items="${Remaining_Rec}">
					<div class="Movement_Details Hide">
						<p class="Movement_Title">${Remaining_Rec}</p>
						<p class="Movement_Value Green">--</p>
					</div>
				</c:forEach>
			</div>
			
	
			<div class="Values_Movement">
				<div class="Movement_Total">
					<img src="./Resources/Images/ArrowDown_Red.svg" alt="ArrowDown_Red">
					<div>
						<p class="Movement_Title">Despesas</p>
						<p class="Movement_Value Red">${(ValuesError_FC == null) ? TotalDespesa : ValuesError_FC}</p>
					</div>
				</div>
				<c:forEach var="Despesa" items="${Despesas}">
					<div class="Movement_Details Hide">
						<p class="Movement_Title"><fmt:formatDate pattern="dd/MM/yyyy" value="${Despesa.dt_movimentacao.getTime()}"/></p>
						<p class="Movement_Value Red"><fmt:formatNumber value="${Despesa.vl_movimentacao}" type="currency" /></p>
					</div>
				</c:forEach>
				<c:forEach var="Remaining_Des" items="${Remaining_Des}">
					<div class="Movement_Details Hide">
						<p class="Movement_Title">${Remaining_Des}</p>
						<p class="Movement_Value Red">--</p>
					</div>
				</c:forEach>
			</div>
			
		</div>
	
		<div class="Hide" style='${(Msg.size() > 0) ? "display: none;" : ""}'>
			<div class="Movement_Add">
				<button class="Green" onclick='CallMovimentacaoTRN("INSR")'>+</button>
				<button class="Red"   onclick='CallMovimentacaoTRN("INSD")'>+</button>
			</div>
		</div>
	</div>

	<a href="ServletMovimentacao?User=${param.User}&Account=${param.Account}&Action=Show" style="text-decoration: none;">
		<button class="Values_ButtonHistory Hide" style='${(Msg.size() > 0) ? "display: none;" : ""}'>
				Histórico
		</button>
	</a>

	<button id="FC_Btn_Details" class="MainBox_Details">
		Mais Detalhes
	</button>

</section>

<c:if test='${param.Action.toUpperCase().trim() != "SHOW"}'>
	<%@ include file="MovimentacaoTRN.jsp" %>
</c:if>
