<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:url var="actionUrl" value="ctPuesto/add" />



<form:form id="Form_ctPuesto" commandName="ctPuesto" method="post"
	action="${actionUrl}" class="pure-form pure-form-aligned">

	<fieldset>
		<legend></legend>


		<table>
			<tr>
				<td><form:label path="iIdPuesto">
						<spring:message text="ID" />
					</form:label></td>
				<td><form:input path="iIdPuesto" readonly="true" /></td>
			</tr>
			<tr>
				<td><form:label path="cPuesto">
						<spring:message text="Puesto" />
					</form:label></td>
				<td><form:input path="cPuesto" /></td>
			</tr>

			<tr>
				<td><form:label path="lActivo">
						<spring:message text="Activo" />
					</form:label></td>
				<td><form:checkbox path="lActivo" /></td>

			</tr>
		</table>


	</fieldset>
</form:form>