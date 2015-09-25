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
		
	
	legend{
		font-size: x-large;	
		
		background-color: white;
		
		font-family: Arial;
	}
	
	
	
	
	
	
	
		
	
</style>

<!--  <link rel="stylesheet" type="text/css" href="stylesheet.css"> -->
<title>Registro</title>



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
				
					<table id="mytable">
						<thead>	
							<tr> 
								<th>Curso</th><th>Grupo</th><th>Horario</th><th>Precio</th>					
							</tr>
						</thead>
						<tbody></tbody>
						<tfoot></tfoot>
					</table>
					
				
				<input type="text" id="txtCadena">
			</fieldset>
			
			<button type="submit">Aceptar</button>
			 <button type="button" onclick="Submit();">Registrar</button>  
			

		</form:form>


	</div>
	
	<div style="color:#0000FF" id="targetDiv">
	 <p>This is a paragraph.</p>
	 </div>
	

</body>
</html>