<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:url var="actionUrl" value="sysUsuMenu/add" />



<form:form id="Form_sysUsuMenu" commandName="sysUsuMenu" method="post"
	action="${actionUrl}" class="pure-form pure-form-aligned">

	<fieldset>
		<legend></legend>


		<table>

			<tr>
				<td><form:label path="cUsuario">
						<spring:message text="Usuario" />
					</form:label></td>
				<td><form:input path="cUsuario" placeholder="Usuario" size="10" readonly="true"
						maxlength="10" /></td>
			</tr>
			<tr>


				<td><form:label path="iIdMenu">
						<spring:message text="Menu" />
					</form:label></td>
				<td><form:select path="iIdMenu" items="${lista_ctMenu}"
						itemValue="iIdMenu" itemLabel="cMenu" /></td>


			</tr>

		</table>
	</fieldset>
</form:form>
