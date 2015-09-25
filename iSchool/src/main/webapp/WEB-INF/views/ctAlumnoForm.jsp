<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page session="false"%>
<html>
<head>
<style>

	fieldset{
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
	
	input{		
		margin: 10px;
	}
	
	td{
		
	}
	
	body{
		
	  	
	}	
	
	legend{
		font-size: x-large;	
		
		background-color: white;
		
		font-family: Arial;
	}
	
	
	
	
	.textoLargo{
		width: 300px;
	}
	
	.btnAdd{
		background-color: #FFBF00;		
	}
	
	.tablaCurso{
		border-bottom: 10px solid black;
	}	
	
	
	input:hover{
		border-color:#81F7F3;
	}
	
	button:hover{
		border-color:#81F7F3;
	}
	
	th{		
		background:-o-linear-gradient(bottom, #005fbf 5%, #003f7f 100%);	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #005fbf), color-stop(1, #003f7f) );
		background:-moz-linear-gradient( center top, #005fbf 5%, #003f7f 100% );
		filter:progid:DXImageTransform.Microsoft.gradient(startColorstr="#005fbf", endColorstr="#003f7f");	background: -o-linear-gradient(top,#005fbf,003f7f);
	
		background-color:#005fbf;
		border:0px solid #000000;
		text-align:center;
		border-width:0px 0px 1px 1px;
		font-size:14px;
		font-family:Arial;
		font-weight:bold;
		color:#ffffff;
	}
	
	.CSSTableGenerator {
		margin:0px;padding:0px;
		width:100%;
		
		border:1px solid #000000;
		
		-moz-border-radius-bottomleft:0px;
		-webkit-border-bottom-left-radius:0px;
		border-bottom-left-radius:0px;
		
		-moz-border-radius-bottomright:0px;
		-webkit-border-bottom-right-radius:0px;
		border-bottom-right-radius:0px;
		
		-moz-border-radius-topright:0px;
		-webkit-border-top-right-radius:0px;
		border-top-right-radius:0px;
		
		-moz-border-radius-topleft:0px;
		-webkit-border-top-left-radius:0px;
		border-top-left-radius:0px;
	}.CSSTableGenerator table{
	    
	    border-spacing: 0;
		width:100%;
		
		margin:0px;padding:0px;
	}.CSSTableGenerator tr:last-child td:last-child {
		-moz-border-radius-bottomright:0px;
		-webkit-border-bottom-right-radius:0px;
		border-bottom-right-radius:0px;
	}
	.CSSTableGenerator table tr:first-child td:first-child {
		-moz-border-radius-topleft:0px;
		-webkit-border-top-left-radius:0px;
		border-top-left-radius:0px;
	}
	.CSSTableGenerator table tr:first-child td:last-child {
		-moz-border-radius-topright:0px;
		-webkit-border-top-right-radius:0px;
		border-top-right-radius:0px;
	}.CSSTableGenerator tr:last-child td:first-child{
		-moz-border-radius-bottomleft:0px;
		-webkit-border-bottom-left-radius:0px;
		border-bottom-left-radius:0px;
	}.CSSTableGenerator tr:hover td{
		
	}
	.CSSTableGenerator tr:nth-child(odd){ background-color:#aad4ff; }
	.CSSTableGenerator tr:nth-child(even)    { background-color:#ffffff; }
	.CSSTableGenerator td{
		vertical-align:middle;
		
		
		border:1px solid #000000;
		border-width:0px 1px 1px 0px;
		text-align:center;
		padding:7px;
		font-size:10px;
		font-family:Arial;
		font-weight:normal;
		color:#000000;
		
	}.CSSTableGenerator tr:last-child td{		
		border-width:0px 1px 0px 0px;
	}.CSSTableGenerator tr td:last-child{
		border-width:0px 0px 1px 0px;		
	}.CSSTableGenerator tr:last-child td:last-child{
		border-width:0px 0px 0px 0px;
	}
	.CSSTableGenerator tr:first-child td{		
		border:0px solid #000000;
		text-align:center;
		border-width:0px 0px 1px 1px;
				
	}
	.CSSTableGenerator tr:first-child:hover td{
		
	}
	.CSSTableGenerator tr:first-child td:first-child{
		border-width:0px 0px 1px 0px;
	}
	.CSSTableGenerator tr:first-child td:last-child{
		border-width:0px 0px 1px 1px;
	}
	
	
	
	
		
	
</style>

<!--  <link rel="stylesheet" type="text/css" href="stylesheet.css"> -->
<title>Registro</title>
<meta name="viewport"
	content="width=device-width, 
              user-scalable=no, initial-scale=1.0, maximun-scale=1.0, minimum-scale=1.0">


<!--  It is advised to put the <script> tags at the end of the document body so they don't block rendering of the page -->
<script type="text/javascript"
	src='<c:url value="/resources/js/lib/jquery-1.10.2.js"/>'></script>
<script type="text/javascript"
	src='<c:url value="/resources/js/lib/jquery-ui-1.10.4.custom.js"/>'></script>
	
<script type="text/javascript" 		src='<c:url value="/resources/js/ctAlumno.js"/>'></script>
<script>


</script>	
	
</head>


<body>
	<div class="contenedor">
		<header> </header>

		<c:url var="addAction" value="/ctAlumno/agregar"></c:url>

		<form:form action="${addAction}" method="POST" commandName="ctAlumno" id="Form_ctAlumno">
			<fieldset>
				<legend>Datos Personales</legend>
				<table>
					<tr>
						<td>
							<form:label path="cNombre">
								<spring:message text="Nombre" />
							</form:label>											
						</td>
						<td>
							<form:input path="cNombre" cssClass="textoLargo" />	
						</td>
						<td>		
							<form:label path="cApellido">
								<spring:message text="Apellidos" />
							</form:label>							
						</td>
						<td>
							<form:input path="cApellido" cssClass="textoLargo"/>
						</td>
					</tr>
				</table>
				<table>
					<tr>						
						<td>		
							<form:label path="dtFechaNac">
								<spring:message text="Fecha de Nacimiento" />
							</form:label>							
						</td>
						<td>
							<form:input type="date" path="dtFechaNac" />
						</td>					
						<td>
							<form:label path="cTel">
								<spring:message text="Telefono" />
							</form:label>							
						</td>
						<td>
							<form:input path="cTel" />
						</td>
						<td>				
							<form:label path="cCorreo">
								<spring:message text="Correo" />
							</form:label>							
						</td>
						<td>
							<form:input path="cCorreo"/>
						</td>
					</tr>
				</table>
			</fieldset>

			<fieldset>
				<legend>Domicilio</legend>
				<table>
					<tr>
						<td>				
							<form:label path="cCalle">
								<spring:message text="Calle" />
							</form:label>							 
						</td>
						<td>
							<form:input path="cCalle" cssClass="textoLargo"/>
						</td>
					</tr>
				</table>
				<table>
					<tr>
						<td>
							<form:label path="cNumExt">
								<spring:message text="NumExt" />
							</form:label>							
						</td>
						<td>
							<form:input path="cNumExt" />
						</td>
						<td>			
							<form:label path="cNumInt">
								<spring:message text="NumInt" />
							</form:label>							
						</td>
						<td>
							<form:input path="cNumInt" />
						</td>
						<td>
							<form:label path="cColonia">
								<spring:message text="Colonia" />
							</form:label>							
						</td>
						<td>
							<form:input path="cColonia" />
						</td>
					</tr>
					<tr>						
						<td>
							<form:label path="cCP">
								<spring:message text="CP" />
							</form:label>							
						</td>
						<td>
							<form:input path="cCP" />
						</td>
						<td>
							<form:label path="cMunicipio">
								<spring:message text="Municipio" />
							</form:label>							
						</td>
						<td>
							<form:input path="cMunicipio" />
						</td>
						<td>
							<form:label path="cEstado">
								<spring:message text="Estado" />
							</form:label>							
						</td>
						<td>
							<form:input path="cEstado" />
						</td>											
					</tr>
				</table>
			</fieldset>
			
			<fieldset>
				<legend>Cursos Grupos Disponibles</legend>
				
				<form:label path="grupo.iIdGrupo">
					<spring:message text="Seleccione Grupo " />
				</form:label>				
				<form:select id = "idGrupo" path="grupo.iIdGrupo" items="${Lista_Grupo}"  	itemValue="iIdGrupo" itemLabel="cDescripcion"/>	
				
				<input type="button" name="Addcurso" value="Agregar Curso" 	onclick="Add_curso()" class="btnAdd">
				<div class="CSSTableGenerator">
					<table id="mytable">
						<thead>	
							<tr> 
								<th>Curso</th><th>Grupo</th><th>Horario</th><th>Precio</th>					
							</tr>
						</thead>
						<tbody></tbody>
						<tfoot></tfoot>
					</table>
				</div>	
				
				
			</fieldset>
			
			 <button onclick="Submit();">Guardar</button>

		</form:form>



	</div>
	

</body>
</html>