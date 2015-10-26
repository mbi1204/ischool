<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page session="false"%>
<html>
<head>
<style>
fieldset {
	margin-right: 200px;
	margin-left: 200px;
	margin-top: 15px;
	margin-bottom: 15px;
	padding: 10px;
	background-color: white;
	border-style: double;
	border-color: #3db2e1;
	border-width: 5px;
}

input {
	margin: 10px;
}

td {
	
}

body {
	
}

legend {
	font-size: x-large;
	background-color: white;
	font-family: Arial;
}

.textoLargo {
	width: 500px;
}

.btnAdd {
	background-color: #FFBF00;
}

.tablaCurso {
	border-bottom: 10px solid black;
}

.botonAceptar {
	background: rgb(28, 184, 65);
	border-radius: 6px;
	width: 100px;
	height: 30px;
	font-family: Arial;
	font-size: 17px;
	color: #ffffff;
	margin-right: 600px;
	margin-left: 600px; <!--
	position: absolute;
	left: 210px;
	-->
}

input:hover {
	border-color: #81F7F3;
}

button:hover {
	border-color: #81F7F3;
}

th {
	background: -o-linear-gradient(bottom, #005fbf 5%, #003f7f 100%);
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0.05, #005fbf
		), color-stop(1, #003f7f));
	background: -moz-linear-gradient(center top, #005fbf 5%, #003f7f 100%);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr="#005fbf",
		endColorstr="#003f7f");
	background: -o-linear-gradient(top, #005fbf, 003f7f);
	background-color: #005fbf;
	border: 0px solid #000000;
	text-align: center;
	border-width: 0px 0px 1px 1px;
	font-size: 14px;
	font-family: Arial;
	font-weight: bold;
	color: #ffffff;
}

.CSSTableGenerator {
	margin: 0px;
	padding: 0px;
	width: 100%;
	border: 1px solid #000000;
	-moz-border-radius-bottomleft: 0px;
	-webkit-border-bottom-left-radius: 0px;
	border-bottom-left-radius: 0px;
	-moz-border-radius-bottomright: 0px;
	-webkit-border-bottom-right-radius: 0px;
	border-bottom-right-radius: 0px;
	-moz-border-radius-topright: 0px;
	-webkit-border-top-right-radius: 0px;
	border-top-right-radius: 0px;
	-moz-border-radius-topleft: 0px;
	-webkit-border-top-left-radius: 0px;
	border-top-left-radius: 0px;
}

.CSSTableGenerator table {
	border-spacing: 0;
	width: 100%;
	margin: 0px;
	padding: 0px;
}

.CSSTableGenerator tr:last-child td:last-child {
	-moz-border-radius-bottomright: 0px;
	-webkit-border-bottom-right-radius: 0px;
	border-bottom-right-radius: 0px;
}

.CSSTableGenerator table tr:first-child td:first-child {
	-moz-border-radius-topleft: 0px;
	-webkit-border-top-left-radius: 0px;
	border-top-left-radius: 0px;
}

.CSSTableGenerator table tr:first-child td:last-child {
	-moz-border-radius-topright: 0px;
	-webkit-border-top-right-radius: 0px;
	border-top-right-radius: 0px;
}

.CSSTableGenerator tr:last-child td:first-child {
	-moz-border-radius-bottomleft: 0px;
	-webkit-border-bottom-left-radius: 0px;
	border-bottom-left-radius: 0px;
}

.CSSTableGenerator tr:hover td {
	
}

.CSSTableGenerator tr:nth-child(odd) {
	background-color: #aad4ff;
}

.CSSTableGenerator tr:nth-child(even) {
	background-color: #ffffff;
}

.CSSTableGenerator td {
	vertical-align: middle;
	border: 1px solid #000000;
	border-width: 0px 1px 1px 0px;
	text-align: center;
	padding: 7px;
	font-size: 10px;
	font-family: Arial;
	font-weight: normal;
	color: #000000;
}

.CSSTableGenerator tr:last-child td {
	border-width: 0px 1px 0px 0px;
}

.CSSTableGenerator tr td:last-child {
	border-width: 0px 0px 1px 0px;
}

.CSSTableGenerator tr:last-child td:last-child {
	border-width: 0px 0px 0px 0px;
}

.CSSTableGenerator tr:first-child td {
	border: 0px solid #000000;
	text-align: center;
	border-width: 0px 0px 1px 1px;
}

.CSSTableGenerator tr:first-child:hover td {
	
}

.CSSTableGenerator tr:first-child td:first-child {
	border-width: 0px 0px 1px 0px;
}

.CSSTableGenerator tr:first-child td:last-child {
	border-width: 0px 0px 1px 1px;
}

.selected {
	background-color: orange;
}
</style>


<!--  <link rel="stylesheet" type="text/css" href="stylesheet.css"> -->
<title>Registro</title>



<!--  It is advised to put the <script> tags at the end of the document body so they don't block rendering of the page -->
<script type="text/javascript"
	src='<c:url value="/resources/js/lib/jquery-1.10.2.js"/>'></script>
<script type="text/javascript"
	src='<c:url value="/resources/js/lib/jquery-ui-1.10.4.custom.js"/>'></script>

<link rel="stylesheet"
	href='<c:url value="/resources/css/jquery-ui-1.10.4.custom.css"/>'>



<script type="text/javascript"
	src='<c:url value="/resources/js/ctAlumno.js"/>'></script>


</head>


<body onload="carga();">


	<div id="Localidades_Dialog" style="display: none;">
		<%@ include file="ctLocalidades_Form.jsp"%>
	</div>
	
	<div id="LocalidadesFac_Dialog" style="display: none;">
		<%@ include file="ctLocalidadesFactura_Form.jsp"%>
	</div>



	<div class="contenedor">
		<header> </header>

		<c:url var="addAction" value="/ctAlumno/agregar"></c:url>

		<form:form action="${addAction}" method="POST" commandName="ctAlumno"
			id="Form_ctAlumno">
			<fieldset>
				<legend>Datos Personales</legend>
				<table border="0">
					<tr>
						<td><form:label path="cNombre">
								<spring:message text="Nombre" />
							</form:label></td>
						<td><form:input path="cNombre" cssClass="textoLargo"  /></td>
					</tr>					
					<tr>

						<td><form:label path="cApellido">
								<spring:message text="Apellidos" />
							</form:label></td>
						<td><form:input path="cApellido" cssClass="textoLargo" /></td>
					</tr>

					<tr>
						<td><form:label path="cEdad">
								<spring:message text="Edad" />
							</form:label></td>
						<td><form:input path="cEdad" /></td>
					</tr>
					<tr>
						<td><form:label path="cTel">
								<spring:message text="Telefono" />
							</form:label></td>
						<td><form:input path="cTel" /></td>
					</tr>
					<tr>
						<td><form:label path="cTelEmergencia">
								<spring:message text="Telefono de emergencias"/>
							</form:label>
						<td><form:input path="cTelEmergencia"/>
					</tr>
					<tr>
						<td><form:label path="cCorreo">
								<spring:message text="Correo" />
							</form:label></td>
						<td><form:input path="cCorreo" /></td>
					</tr>					
					<tr>
						<td><form:label path="cGenero">
								<spring:message text="Sexo"></spring:message>
							</form:label></td>
						<td>							
							<form:radiobutton path="cGenero" value="Hombre" checked="true"/>Hombre
								
							<form:radiobutton path="cGenero" value="Mujer"/>Mujer
								
						</td>
					</tr>					
					<tr>
						<td><form:label path="lAlergia">
								<spring:message text="¿Tiene alergias?" />
							</form:label></td>
						<td><form:checkbox path="lAlergia" id="checkAlergia" onclick="showAlergia();"/></td>						
					</tr>
					<tr id="textAlergia">
						<td><form:label path="cAlergia">
								<spring:message text="Describa" />
							</form:label></td>
						<td><form:textarea path="cAlergia" cols="45" rows="5"/></td>
					</tr>
					<tr>
						<td><form:label path="lMedicamento">
								<spring:message text="¿Usa Medicamento controlado?" />
							</form:label></td>
						<td><form:checkbox path="lMedicamento" id="checkMedicamento" onclick="showMedicamento();"/></td>						
					</tr>
					<tr id="textMedicamento">
						<td><form:label path="cMedicamento">
								<spring:message text="Describa" />
							</form:label></td>
						<td><form:textarea path="cMedicamento" cols="45" rows="5"/></td>
					</tr>
					<tr>
						<td><form:label path="lLesion">
								<spring:message text="¿Tiene alguna lesion?" />
							</form:label></td>
						<td><form:checkbox path="lLesion" id="checkLesion" onclick="showLesion();"/></td>						
					</tr>
					<tr id="textLesion">
						<td><form:label path="cLesion">
								<spring:message text="Describa" />
							</form:label></td>
						<td><form:textarea path="cLesion" cols="45" rows="5"/></td>
					</tr>
					<tr>
						<td><form:label path="lTratamiento">
								<spring:message text="¿Esta en algun tratamiento?" />
							</form:label></td>
						<td><form:checkbox path="lTratamiento" id="checkTratamiento" onclick="showTratamiento();"/></td>						
					</tr>
					<tr id="textTratamiento">
						<td><form:label path="cTratamiento">
								<spring:message text="Describa" />
							</form:label></td>
						<td><form:textarea path="cTratamiento" cols="45" rows="5"/></td>
					</tr>
					<tr>
						<td><form:label path="lSeguro">
								<spring:message text="¿Tiene seguro?"></spring:message>
							</form:label></td>
						<td>
							<form:checkbox path="lSeguro" />
						</td>
					</tr>
					<tr>
						<td><form:label path="lFactura">
								<spring:message text="¿Requiere factura?"></spring:message>
							</form:label></td>
						<td><form:checkbox path="lFactura" onclick="factura();" id="lFactura"/></td>
					</tr>

				</table>
			</fieldset>

			<fieldset>
				<legend>Domicilio</legend>
				<table border="0">
					<tr>
						<td colspan="1"><form:label path="cCalle">
								<spring:message text="Calle" />
							</form:label></td>
						<td colspan="5"><form:input path="cCalle"
								cssClass="textoLargo" /></td>
					</tr>

					<tr>
						<td><form:label path="cNumExt">
								<spring:message text="NumExt" />
							</form:label></td>
						<td><form:input path="cNumExt" /></td>
						<td><form:label path="cNumInt">
								<spring:message text="NumInt" />
							</form:label></td>
						<td><form:input path="cNumInt" /></td>


						<td><form:label path="cCP">
								<spring:message text="CP" />
							</form:label></td>
						<td><form:input path="cCP" /> <!--  <a href="#" onclick="get_localidad();"  class="btnAdd"> Buscar</a>-->
							<input type="button" name="AddLocalidad" value="Buscar Domicilio"
							onclick="get_localidad();" class="btnAdd"></td>
					</tr>
					<tr>
						<td><form:label path="cColonia">
								<spring:message text="Colonia" />
							</form:label></td>
						<td><form:input path="cColonia" /></td>


						<td><form:label path="cMunicipio">
								<spring:message text="Municipio" />
							</form:label></td>


						<td><form:input path="cMunicipio" /></td>
						<td><form:label path="cEstado">
								<spring:message text="Estado" />
							</form:label></td>
						<td><form:input path="cEstado" /></td>
					</tr>
				</table>
			</fieldset>
			
			<fieldset id="formFactura"><legend>Datos para facturacion</legend>					
				<table>
					<tr>
						<td><form:label path="cNombreFiscal">
								<spring:message text="Razon Social" />
							</form:label></td>
						<td><form:input path="cNombreFiscal" cssClass="textoLargo"/></td>							
					</tr>
					<tr>
						<td><form:label path="cCalleFiscal">
								<spring:message text="Calle" />
							</form:label></td>
						<td><form:input path="cCalleFiscal" cssClass="textoLargo"/>
					</tr>
					<tr>
						<td><form:label path="cNumeroFiscal">
								<spring:message text="Numero Ext"/>
							</form:label></td>
						<td><form:input path="cNumeroFiscal"/></td>
					</tr>
					<tr>
						<td><form:label path="cColoniaFiscal">
								<spring:message text="Colonia"/>
							</form:label></td>
						<td><form:input path="cColoniaFiscal" id="cColoniaFiscal"/></td>
					</tr>
					<tr>
						<td><form:label path="cMunicipioFiscal">
								<spring:message text="Municipio"/>
							</form:label></td>
						<td><form:input path="cMunicipioFiscal" id="cMunicipioFiscal"/></td>
					</tr>
					<tr>
						<td><form:label path="cCPFiscal">
								<spring:message text="CP"/>
							</form:label></td>
						<td><form:input path="cCPFiscal"/>
							<input type="button" name="AddLocalidadFac" value="Buscar Domicilio"
							onclick="get_localidadFactura();" class="btnAdd"></td>
					</tr>
					<tr>
						<td><form:label path="cCiudadFiscal">
								<spring:message text="Ciudad"/>
							</form:label></td>
						<td><form:input path="cCiudadFiscal"/></td>
					</tr>
					<tr>
						<td><form:label path="cEstadoFiscal">
								<spring:message text="Estado"/>
							</form:label></td>
						<td><form:input path="cEstadoFiscal" id="cEstadoFiscal"/></td>
					</tr>
					<tr>
						<td><form:label path="cRfcFiscal">
								<spring:message text="RFC"/>
							</form:label></td>
						<td><form:input path="cRfcFiscal"/></td>
					</tr>
				</table>
			</fieldset>

			<fieldset>
				<legend>Cursos Grupos Disponibles</legend>

				<form:label path="grupo.iIdGrupo">
					<spring:message text="Seleccione Grupo " />
				</form:label>
				<form:select id="idGrupo" path="grupo.iIdGrupo"
					items="${Lista_Grupo}" itemValue="iIdGrupo"
					itemLabel="cDescripcion" />

				<input type="button" name="Addcurso" value="Agregar Curso"
					onclick="Add_curso()" class="btnAdd">
				<div class="CSSTableGenerator">
					<table id="mytable">
						<thead>
							<tr>
								<th>ID</th>
								<th>Grupo</th>
								<th>ID Curso</th>
								<th>Curso</th>
								<th>Horario</th>
								<th>Precio</th>
							</tr>
						</thead>
						<tbody></tbody>
						<tfoot></tfoot>
					</table>
				</div>
				<form:input type="hidden" path="cGrupo" disabled="false" />
			</fieldset>

			<button type="submit" class="botonAceptar" onclick="return validaCampos()">Registrar</button>

		</form:form>
	</div>

</body>
</html>