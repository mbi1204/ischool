<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!--variable jtsl  -->
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
				<td><form:input path="iIdProfesor" placeholder="ID Profesor" size="10" maxlength="10"  /></td>
			</tr>

			<tr>
				<td><form:label path="cNomProfesor">
						<spring:message text="Nombre" />
					</form:label></td>
				<td><form:input path="cNomProfesor"  placeholder="Nombre del Profesor" size="80"  /></td>
			</tr>
			
			<tr>
				<td><form:label path="cApeProfesor">
						<spring:message text="Apellidos" />
					</form:label></td>
				<td><form:input path="cApeProfesor"  placeholder="Apellidos del Profesor" size="80"  /></td>
			</tr>

			<tr>
				<td><form:label path="cCalleProfesor">
						<spring:message text="Domicilio" />
					</form:label></td>
				<td><form:input path="cCalleProfesor" placeholder="Domicilio del Porfesor"  size="80" /></td>
			</tr>

<!--  
			<tr>
				<td><form:label path="iIdPuesto">
						<spring:message text="Puesto" />
					</form:label></td>
				<td><form:input path="iIdPuesto" placeholder="Puesto" /></td>
			</tr>
			-->
			
			
			
			<!--
			<tr>
				<td><form:label path="iIdPuesto">
						<spring:message text="Puesto" />
					</form:label></td>
				<td><form:select path="iIdPuesto" items="${lista_ctPuesto}" itemValue="iIdPuesto" itemLabel="cPuesto" /></td>
			</tr>
			  -->
			


		</table>
		

	</fieldset>
</form:form>