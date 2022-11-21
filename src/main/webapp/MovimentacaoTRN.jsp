
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="Selected_Categoria" value="${(MovimentacaoTRN.categoria != null) ? MovimentacaoTRN.categoria : 0}"/>

<div class="Popup">
	<div class="Popup_Wrapper">
		<div class="Popup_Content">
		
			<p class="Popup_Title">${MovimentacaoTRN.title_mode} - ${MovimentacaoTRN.title_type}</p>
			<i class="Popup_Close fa-solid fa-xmark"></i>

			<form action="ServletMovimentacao" method="get" class="Popup_Form">

				<input type="hidden" name="User"     value="${param.User}">
				<input type="hidden" name="Account"  value="${param.Account}">
				<input type="hidden" name="Method"   value="${param.Method}">
				<input type="hidden" name="Code_Mov" value="${param.Method.substring(3)}">

				<fieldset class="Form_Type">
					<input type="radio"  name="Tipo" value="R" id="MovReceita" ${MovimentacaoTRN.receita_config[0]} required>
					<label for="MovReceita" class="${MovimentacaoTRN.receita_config[1]}">
						<em class="fa-solid fa-arrow-up" style="margin-right: 6px;"></em>
						Receita
					</label>

					<input type="radio"  name="Tipo" value="D" id="MovDespesa" ${MovimentacaoTRN.despesa_config[0]} required>
					<label for="MovDespesa" class="${MovimentacaoTRN.despesa_config[1]}">
						<em class="fa-solid fa-arrow-down" style="margin-right: 5px;"></em>						
						Despesa
					</label>
				</fieldset>

				<fieldset class="Form_Main">
					<div>
						<label for="MovValor">Valor</label>
						<input type="number" step="0.01" name="Valor" id="MovValor" value="${MovimentacaoTRN.vl_movimentacao}" required>
					</div>
					<div>
						<label for="MovData">Data</label>
						<input type="date" 	 name="Data" id="MovData" value="${MovimentacaoTRN.dt_movimentacao}" required>
					</div>
				</fieldset>

				<fieldset class="Form_Selection">					
					<label for="MovCategoria">Categoria</label>
					<select name="Categoria" id="MovCategoria">
						<option value="0">Selecione</option>
						<c:forEach var="Categoria" items="${MovimentacaoTRN.categorias}">
							<option value="${Categoria.cd_categoria}" ${(Selected_Categoria == Categoria.cd_categoria) ? "selected" : ""}>${Categoria.nm_categoria}</option>
						</c:forEach>
					</select>
				</fieldset>

					<fieldset class="Form_Buttons">
						<input type="button" value="Cancelar" class="Buttons_Cancel">
						<input type="submit" value="Salvar"  class="Buttons_Confirm">
					</fieldset>

			</form>
			
		</div>
	</div>
</div>
