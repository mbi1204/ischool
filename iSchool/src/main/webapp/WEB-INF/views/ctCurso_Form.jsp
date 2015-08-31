<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:url var="actionUrl" value="/curso/adm/registro" />

<form:form id="Form_ctCurso" commandName="ctCurso" method="post"
	action="${actionUrl}" class="pure-form pure-form-aligned">

	<fieldset>
		<legend></legend>

		<table>
			<tr>
				<td><form:label path="iIdCur">
						<spring:message text="ID" />
					</form:label></td>
				<td><form:input path="iIdCur" readonly="true" /></td>
			</tr>
			<tr>
				<td><form:label path="cNomCurso">
						<spring:message text="Curso" />
					</form:label></td>
				<td><form:input path="cNomCurso" /></td>
			</tr>

			<tr>
				<td><form:label path="lEstCurso">
						<spring:message text="Estatus" />
					</form:label></td>
				<td><form:checkbox path="lEstCurso" /></td>

			</tr>
			
			<tr>
				<td><form:label path="iMinCup">
						<spring:message text="Cupo Minimo" />
					</form:label></td>
				<td><form:input path="iMinCup" /></td>

			</tr>
			
			<tr>
				<td><form:label path="iMaxCup">
						<spring:message text="Cupo Maximo" />
					</form:label></td>
				<td><form:input path="iMaxCup" /></td>

			</tr>
			
			<tr>
				<td><form:label path="dePrecioCur">
						<spring:message text="Precio del Curso" />
					</form:label></td>
				<td><form:input path="dePrecioCur" /></td>

			</tr>

		</table>

	</fieldset>
</form:form>