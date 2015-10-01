<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:url var="actionUrl" value="/ctCurso/add" />

<form:form id="Form_ctCurso" commandName="ctCurso" method="post"
	action="${actionUrl}" class="pure-form pure-form-aligned">

	<fieldset>
		<legend></legend>

		<table>
			<tr>
				<td><form:label path="iIdCurso">
						<spring:message text="ID" />
					</form:label></td>
				<td><form:input path="iIdCurso"  readonly="true" /></td>
			</tr>
			<tr>
				<td><form:label path="cNombre">
						<spring:message text="Curso" />
					</form:label></td>
				<td><form:input path="cNombre" placeholder="Ej. Tango" onkeypress="return soloLetras(event)"/></td>
			</tr>

			
			<tr>
				<td><form:label path="iMinCup">
						<spring:message text="Cupo Minimo" />
					</form:label></td>
				<td><form:input path="iMinCup" placeholder="Ej. 10" onkeypress="return soloNumero(event)"/></td>

			</tr>
			
			<tr>
				<td><form:label path="iMaxCup">
						<spring:message text="Cupo Maximo" />
					</form:label></td>
				<td><form:input path="iMaxCup" placeholder="Ej. 15" onkeypress="return soloNumero(event)"/></td>

			</tr>
			
			<tr>
				<td><form:label path="dePrecio">
						<spring:message text="Precio del Curso" />
					</form:label></td>
				<td><form:input path="dePrecio" id="currency" placeholder="Ej. 1000.00" onKeyDown="Decimal()"/></td>

			</tr>
			
			
			<tr>
				<td><form:label path="lEstatus">
						<spring:message text="Estatus" />
					</form:label></td>
				<td><form:checkbox path="lEstatus" /></td>

			</tr>

		</table>

	</fieldset>
	
</form:form>