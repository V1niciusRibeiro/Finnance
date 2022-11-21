
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach var="Movimentacao" items="${Movimentacoes}">
	<tr>
		<td>${("R".equals(Movimentacao.tp_movimentacao.toUpperCase().trim())) ? "Receita" : "Despesa"}</td>
		
		<c:if test="${Movimentacao.categoria != null}">
			<td>${Movimentacao.categoria.nm_categoria}</td>
		</c:if>
		<c:if test="${Movimentacao.categoria == null}">
			<td> </td>
		</c:if>
		
		<td><fmt:formatNumber value="${Movimentacao.vl_movimentacao}" type="currency" /></td>

		<td style="text-align: center;"><fmt:formatDate pattern="dd/MM/yyyy" value="${Movimentacao.dt_movimentacao.getTime()}"/></td>
	
		<td style="text-align: center;"><i class="fa-solid fa-pencil" style="padding: 10px; cursor: pointer;" onclick='CallMovimentacaoTRN("UPD${Movimentacao.cd_movimentacao}")'></i></td>
		<td style="text-align: center;"><i class="fa-solid fa-trash-can" style="padding: 10px; cursor: pointer;"></i></td>
	</tr>
</c:forEach>
