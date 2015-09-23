<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page session="false"%>
<html>
<head>
<title>Registro</title>
<meta name="viewport"
	content="width=device-width, 
              user-scalable=no, initial-scale=1.0, maximun-scale=1.0, minimum-scale=1.0">


<!--  It is advised to put the <script> tags at the end of the document body so they don't block rendering of the page -->
<script type="text/javascript"
	src='<c:url value="/resources/js/lib/jquery-1.10.2.js"/>'></script>
<script type="text/javascript"
	src='<c:url value="/resources/js/lib/jquery-ui-1.10.4.custom.js"/>'></script>
	
	
</head>


<body>
	<div class="contenedor">
		<header> </header>

		<c:url var="addAction" value="/ctAlumno/add"></c:url>

		<form:form action="${actionUrl}" method="post" commandName="ctAlumno">
			<fieldset>
				<legend>Datos Personales</legend>

				<form:label path="cNombre">
					<spring:message text="Nombre" />
				</form:label>
				<form:input path="cNombre" />


				<form:label path="cApellido">
					<spring:message text="Apellidos" />
				</form:label>
				<form:input path="cApellido" />


				<form:label path="dtFechaNac">
					<spring:message text="Fecha de Nacimiento" />
				</form:label>

				<form:input type="date" path="dtFechaNac" />

				<form:label path="cTel">
					<spring:message text="Telefono" />
				</form:label>
				<form:input path="cTel" />
				
				
				<form:label path="cCorreo">
					<spring:message text="Correo" />
				</form:label>
				<form:input path="cCorreo" />
				
			

			</fieldset>

			<fieldset>
				<legend>Domicilio</legend>
				<form:label path="cCalle">
					<spring:message text="Calle" />
				</form:label>
				<form:input path="cCalle" /> 
				<form:label path="cNumExt">
					<spring:message text="NumExt" />
				</form:label>
				<form:input path="cNumExt" />

				<form:label path="cNumInt">
					<spring:message text="NumInt" />
				</form:label>
				<form:input path="cNumInt" />

				<form:label path="cColonia">
					<spring:message text="Colonia" />
				</form:label>
				<form:input path="cColonia" />

				<form:label path="cCP">
					<spring:message text="CP" />
				</form:label>
				<form:input path="cCP" />


				<form:label path="cMunicipio">
					<spring:message text="Municipio" />
				</form:label>
				<form:input path="cMunicipio" />


				<form:label path="cEstado">
					<spring:message text="Estado" />
				</form:label>
				<form:input path="cEstado" />

				<form:label path="cMunicipio">
					<spring:message text="Municipio" />
				</form:label>
				<form:input path="cMunicipio" />
			</fieldset>
			
			<fieldset>
				<legend>Cursos Grupos Disponibles</legend>
				
				<form:label path="grupo.iIdGrupo">
					<spring:message text="Seleccione Grupo " />
				</form:label>				
				<form:select id = "idGrupo" path="grupo.iIdGrupo" items="${Lista_Grupo}"  	itemValue="iIdGrupo" itemLabel="cDescripcion"/>	
				
				<input type="button" name="Addcurso" value="Agregar Curso" 	onclick="Add_curso()">
				<table id="mytable">
					<thead>	
					<tr> 
						<th>ID</th> <th>Curso</th><th>Grupo</th> <th>Horario</th> <th>Precio</th>					
					</tr>
					</thead>
					<tbody></tbody>
					<tfoot></tfoot>
				</table>				
				
				
				
			</fieldset>

		</form:form>



	</div>
	<script type="text/javascript"
		src='<c:url value="/resources/js/ctAlumno.js"/>'></script>

</body>
</html>