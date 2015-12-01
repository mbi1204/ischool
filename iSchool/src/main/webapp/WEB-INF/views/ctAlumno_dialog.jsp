<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:url var="actionUrl" value="/repFactura/editar" />

<form:form id="ctAlumnoDialog" commandName="ctAlumno" method="post"
	action="${actionUrl}" class="pure-form pure-form-aligned">
	
	<fieldset><legend></legend>
		<table>
		<tr>
				<td><form:label path="iIdAlumno">
						<spring:message text="ID"/>
					</form:label></td>			
				<td><form:input path="iIdAlumno" readonly="true"/></td>
			</tr>
			<tr>
				<td><form:label path="cNombre">
						<spring:message text="Nombre"/>
					</form:label></td>			
				<td><form:input path="cNombre" readonly="true"/></td>
			</tr>
			<tr>
				<td><form:label path="cApellido">
						<spring:message text="Apellido"/>
					</form:label></td>			
				<td><form:input path="cApellido" readonly="true"/></td>
			</tr>			
			<tr>
				<td><form:label path="lFactura">
						<spring:message text="Factura"/>
					</form:label></td>
				<td><form:label path="lFactura" for="cliente">Cliente &nbsp;</form:label><form:radiobutton path="lFactura" value="true" id="cliente" onchange="showFactura();"/>&nbsp; &nbsp;
					<form:label path="lFactura" for="publico">Publico en general &nbsp;</form:label><form:radiobutton path="lFactura" value="false" id="publico" onchange="showFactura();"/>
				</td>
			</tr>
			<tr class="factura">
				<td><form:label path="cRfcFiscal">
						<spring:message text="RFC"/>
					</form:label></td>			
				<td><form:input path="cRfcFiscal"/></td>
			</tr>		
			<tr class="factura">
				<td><form:label path="cNombreFiscal">
						<spring:message text="Razon Social"/>
					</form:label></td>			
				<td><form:input path="cNombreFiscal"/></td>
			</tr>
			<tr class="factura">
				<td><form:label path="cCalleFiscal">
						<spring:message text="Calle"/>
					</form:label></td>			
				<td><form:input path="cCalleFiscal"/></td>
			</tr>
			<tr class="factura">
				<td><form:label path="cNumeroFiscal">
						<spring:message text="Numero Ext"/>
					</form:label></td>			
				<td><form:input path="cNumeroFiscal"/></td>
			</tr>
			<tr class="factura">
				<td><form:label path="cNumeroIntFiscal">
						<spring:message text="Numero Int"/>
					</form:label></td>			
				<td><form:input path="cNumeroIntFiscal"/></td>
			</tr>
			<tr class="factura">
				<td><form:label path="cCPFiscal">
						<spring:message text="CP"/>
					</form:label></td>			
				<td><form:input path="cCPFiscal"/>
					<input type="button" name="AddLocalidad" value="Buscar Domicilio"
							onclick="get_localidad();" class="btnAdd"></td>
			</tr>			
			<tr class="factura">
				<td><form:label path="cColoniaFiscal">
						<spring:message text="Colonia"/>
					</form:label></td>			
				<td><form:input path="cColoniaFiscal"/></td>
			</tr>
			<tr class="factura">
				<td><form:label path="cMunicipioFiscal">
						<spring:message text="Mpio/Deleg"/>
					</form:label></td>			
				<td><form:input path="cMunicipioFiscal"/></td>
			</tr>			
			<tr class="factura">
				<td><form:label path="cEstadoFiscal">
						<spring:message text="Estado"/>
					</form:label></td>			
				<td><form:input path="cEstadoFiscal"/></td>
			</tr>
			
		</table>
	</fieldset>	
</form:form>
