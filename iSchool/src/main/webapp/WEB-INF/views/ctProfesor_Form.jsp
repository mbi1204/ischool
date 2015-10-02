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
				<td><form:input path="iIdProfesor" readonly="true"  /></td>
			</tr>

			<tr>
				<td><form:label path="cNombre">
						<spring:message text="Nombre" />
					</form:label></td>
				<td><form:input path="cNombre"  placeholder="Nombre del Profesor" size="20"  onkeypress="return soloLetras(event)"  /></td>
				
			</tr>
			
			
			<tr>
				<td><form:label path="cApellido">
						<spring:message text="Apellidos" />
					</form:label></td>
				<td><form:input path="cApellido" placeholder="Apellidos del Profesor" size="20" onkeypress="return soloLetras(event)" /></td>
			</tr>

			<tr>
				<td><form:label path="cCalle">
						<spring:message text="Domicilio" />
					</form:label></td>
				<td><form:input path="cCalle" placeholder="Domicilio del Porfesor"  size="50"  /></td>
			</tr>
			
			<tr>
				<td><form:label path="cNumExt">
						<spring:message text="NumeroExt" />
					</form:label></td>
				<td><form:input path="cNumExt" placeholder="Num Exterior" size="5" /></td>
			</tr>
			
			<tr>
				<td><form:label path="cNumInt">
						<spring:message text="NumeroInt" />
					</form:label></td>
				<td><form:input path="cNumInt" placeholder="Num Interior" size="5" /></td>
			</tr>
			
			<tr>
				<td><form:label path="cColonia">
						<spring:message text="Colonia" />
					</form:label></td>
				<td><form:input path="cColonia"  placeholder="Colonia" size="20" /></td>
			</tr>
		
			
			<tr>
				<td><form:label path="cMunicipio">
						<spring:message text="Municipio"/>
					</form:label></td>
				<td><form:input path="cMunicipio" placeholder="Municipio" size="20" /></td>
			</tr>
			
			<tr>
				<td><form:label path="cEdo">
						<spring:message text="Estado"/>
					</form:label></td>
				<td><form:input path="cEdo" placeholder="Estado" size="20" onkeypress="return soloLetras(event)" /></td>
			</tr>
			
			<tr>
				<td><form:label path="cCP">
						<spring:message text="Codigo Postal"/>
					</form:label></td>
				<td><form:input path="cCP" placeholder="Codigo Postal" size="11" onkeypress="return soloNumero(event)" pattern=".{5}"/></td>
			</tr>

			
			<tr>
				<td><form:label path="cTelefono">
						<spring:message text="Telefono"/>
					</form:label></td>
				<td><form:input path="cTelefono" placeholder="Telefono" size="10" onkeypress="return soloNumero(event)"/></td>
			</tr>
			
			<tr>
				<td><form:label path="dtContrato">
						<spring:message text="Fecha Contrato"/>
					</form:label></td>
				<td><input type="date" name="dtContrato" >
			</tr>
			
			
			<tr>
				<td><form:label path="dtFechaNac">
						<spring:message text="Fecha de Nacimiento" />
					</form:label></td>
				<td><input type="date" name="dtFechaNac"  >
			</tr>
			
			<tr>
				<td><form:label path="lEstatus">
						<spring:message text="Activo" />
					</form:label></td>
				<td><form:checkbox path="lEstatus"/></td>
			</tr>
			

		</table>
		

	</fieldset>
</form:form>