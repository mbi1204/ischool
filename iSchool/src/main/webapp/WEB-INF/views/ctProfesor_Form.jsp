<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<c:url var="actionUrl" value="ctProfesor/add" />



<form:form id="Form_ctProfesor_Add" commandName="ctProfesor" method="post"
	action="${actionUrl}" class="pure-form pure-form-aligned">

	<fieldset>
		<legend></legend>


		<table>
			<tr>
				<td><form:label path="iIdProfesor">
						<spring:message text="ID Profesor" />
					</form:label></td>
				<td><form:input path="iIdProfesor" placeholder="ID" size="5" maxlength="10"  /></td>
			</tr>

			<tr>
				<td><form:label path="cNombre">
						<spring:message text="Nombre" />
					</form:label></td>
				<td><form:input path="cNombre"  placeholder="Nombre del Profesor" size="20"  /></td>
			</tr>
			
			<tr>
				<td><form:label path="cApellido">
						<spring:message text="Apellidos" />
					</form:label></td>
				<td><form:input path="cApellido"  placeholder="Apellidos del Profesor" size="20"  /></td>
			</tr>

			<tr>
				<td><form:label path="cCalle">
						<spring:message text="Domicilio" />
					</form:label></td>
				<td><form:input path="cCalle" placeholder="Domicilio del Porfesor"  size="50" /></td>
			</tr>
			
			<tr>
				<td><form:label path="iNumExt">
						<spring:message text="NumeroExt" />
					</form:label></td>
				<td><form:input path="iNumExt"  size="5" /></td>
			</tr>
			
			<tr>
				<td><form:label path="lEstatus">
						<spring:message text="Activo" />
					</form:label></td>
				<td><form:checkbox path="lEstatus" /></td>

			</tr>
			
			


		</table>
		

	</fieldset>
</form:form>