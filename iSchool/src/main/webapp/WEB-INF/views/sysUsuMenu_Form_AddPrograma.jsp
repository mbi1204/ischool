<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:url var="actionUrl" value="sysUsuprograma/add" />


                                                     
<form:form id="Form_sysUsuMenu_ctPrograma" commandName="sysUsuprograma"
	method="post" action="${actionUrl}" class="pure-form pure-form-aligned">

	<fieldset>
		<legend></legend>


		<table>

			<tr>
				<td><form:label path="cUsuario">
						<spring:message text="Usuario" />
					</form:label></td>
				<td><form:input path="cUsuario" placeholder="Usuario" size="10"
						readonly="true" maxlength="10" /></td>
			</tr>
			<tr>
				<td><form:label path="iIdMenu">
						<spring:message text="Menu" />
					</form:label></td>
				<td><form:input path="iIdMenu" placeholder="Menu" size="10"	 maxlength="10" readonly="true" /></td>
				
			
				<td> <input type="text" name="cMenu" id="cMenu" readonly="readonly" ></td>
				
			</tr>
			
			<tr>
				<td><form:label path="iIdPrograma">
						<spring:message text="Programa" />
					</form:label></td>
				<td><form:select path="iIdPrograma"  itemValue="iIdPrograma" itemLabel="cNombre" /></td>
				
			</tr>
			

		</table>
	</fieldset>
</form:form>


