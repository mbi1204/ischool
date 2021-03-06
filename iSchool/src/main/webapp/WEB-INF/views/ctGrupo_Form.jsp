<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:url var="actionUrl" value="/ctGrupo/add" />

<form:form id="Form_ctGrupo" commandName="ctGrupo" method="post"
	action="${actionUrl}" class="pure-form pure-form-aligned">

	<fieldset>
		<legend></legend>
		<table>
			<tr>
				<td><form:label path="iIdGrupo">
						<spring:message text="ID" />
					</form:label></td>
				<td><form:input path="iIdGrupo" readonly="true" /></td>
			</tr>
			<tr>
				<td><form:label path="cNombre">
						<spring:message text="Nombre del Grupo" />
					</form:label></td>
				<td><form:input path="cNombre" /></td>
			</tr>

			<tr>		
				<td><form:label path="iIdCurso">
						<spring:message text="Curso" />
					</form:label></td>
				<td><form:select path="iIdCurso" items="${lista_ctCurso}"
						itemValue="iIdCurso" itemLabel="cNombre"/></td>
			</tr>
			
			<tr>
				<td><form:label path="iIdProfesor">
						<spring:message text="Profesor" />
					</form:label></td>
				<td><form:select path="iIdProfesor" items="${lista_ctProfesor}" 
						itemValue="iIdProfesor" itemLabel="cNombreApellido"/></td>
			</tr>
			
			
			<tr>
				<td><form:label path="cDias">
						<spring:message text="Dias" />
					</form:label></td>
				<td><form:input path="cDias" /></td>
			</tr>
			
			<tr>
				<td><form:label path="cHorario">
						<spring:message text="Horario" />
					</form:label></td>
				<td><form:input path="cHorario" /></td>
			</tr>


		</table>

	</fieldset>
</form:form>