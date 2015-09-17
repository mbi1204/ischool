<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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



<script>
	alert("entro");
	
	
	
	function Add_curso(){		
	alert("entro al add");
	}

	$(document).ready(function() {
		function dataRow(value1, value2) {
			this.id = value1;
			this.nombre = value2;
		}
		
		$('#out').click(function() {
			// create array to hold your data
			var dataArray = new Array();
			// iterate through rows of table
			// * Start from '2' to skip the header row *
			for (var i = 2; i <= $("table tr").length; i++) {
				dataArray.push(new dataRow($(
						"table tr:nth-child("+ i + ") td").eq(0).html(), $(
						"table tr:nth-child("+ i + ") td").eq(1).html(), $(
						"table tr:nth-child("+ i + ") td").eq(2).html()));	
				}
			
			var sJson = JSON.stringify(dataArray);
			alert(sJson);
			
			$.ajax({
				type : "GET",
				url : "pruebaxx",
				dataType : "json",
				contentType : "application/json; charset=utf-8",				
				data : {
					cUsuario : 'israel mendoza',		
					dataArray1: JSON.stringify([
					                            {"firstName":"John", "lastName":"Doe"},
					                            {"firstName":"Anna", "lastName":"Smith"},
					                            {"firstName":"Peter","lastName": "Jones"}                   ]) ,
				},	           
				success : function(data, textStatus, jqXHR) {

					alert (data);
				},
				error : function() {
					error("al cargar la lista");

				}
			});
			
			
			
			})
   });
</script>





</head>


<body>
	<div class="contenedor">
		<header> </header>
		<c:url var="addAction" value="/ctAlumno/add"></c:url>
		<section>
			<form class="registro" action="${addAction}" method="post"
				name="registro">
				<fieldset>
					<legend>Datos Personales</legend>
					<ul>
						<li><label for="cNombre">Nombre:</label> <input type="text"
							name="cNombre" placeholder="Ej. Bogar Elias" required
							pattern="[a-z A-Z]*" /></li>
					</ul>
					<ul>
						<li><label for="cApellido">Apellidos:</label> <input
							type="text" name="cApellido" placeholder="Ej. Chavez Saavedra"
							required pattern="[a-z A-Z]*" /></li>
					</ul>
					<ul>
						<li><label for="dtFechaNac">Fecha de nacimiento:</label> <input
							type="date" name="dtFechaNac" /></li>
					</ul>

				</fieldset>
				<fieldset>
					<legend>Domicilio</legend>
					<ul>
						<li><label for="cCalle">Calle:</label> <input type="text"
							name="cCalle" placeholder="Ej. Saint Saenz" required
							pattern="[a-z A-Z]*" /></li>
					</ul>
					<ul>
						<li><label for="cNumExt">Numero Exterior:</label> <input
							type="text" name="cNumExt" placeholder="Ej. 62 o  Lt 15 Mz 410"
							required pattern=".{1,5}" /></li>
					</ul>
					<ul>
						<li><label for="cNumInt">Numero Interior:</label> <input
							type="text" name="cNumInt"
							placeholder="Ej. 102 o Edificio H Dep.205" required
							pattern=".{1,5}" /></li>
					</ul>
					<ul>
						<li><label for="cColonia">Colonia:</label> <input type="text"
							name="cColonia" placeholder="Ej. Vallejo" required
							pattern="[a-zA-Z]*" /></li>

					</ul>
					<ul>
						<li><label for="cCP">Codigo Postal:</label> <input
							type="text" name="cCP" placeholder="Ej. 05555" maxlength="5"
							required pattern="[0-9]{5}" /></li>

					</ul>
					<ul>
						<li><label for="cMunicipio">Municipio o Delegacion:</label> <input
							type="text" name="cMunicipio"
							placeholder="Ej. Naucalpan o Gustavo a Madero" required
							pattern="[a-z A-Z]*" /></li>
					</ul>
					<ul>
						<li><label for="cEstado">Estado:</label> <input type="text"
							name="cEstado" placeholder="Ej. Edo. Mex" required /></li>
					</ul>
					<ul>
						<li><label for="cTel">Telefono:</label> <input type="text"
							name="cTel" placeholder="Ej.(55)57395841 ext 45" required
							pattern="[0-9].{1,8}" /></li>
					</ul>
				</fieldset>

				<fieldset>
					<legend>Curso</legend>
					<ul>
						<li><label for="cNomCurso">Curso:</label>
							<ul>
								<select>
									<option value="cNomCurso">Salsa</option>
									<option value="cNomCurso">Danzon</option>
									<option value="cNomCurso">Baile Moderno</option>
									<option value="cNomCurso">Danza</option>
								</select>
							</ul>
					</ul>
					
					<input type="button" name="Addcurso" value="Agregar Curso" onclick="Add_curso()">
					
					<ul>
						<!-- Preguntar que hace esta linea vacia -->







					</ul>

				</fieldset>
				<button class="submit" type="submit">Registrar</button>
			</form>
		</section>
	</div>


	<table border="2px solid black">
		<tr id="header-row">
			<th>id</th>
			<th>nombre</th>
		</tr>
		<tr>
			<td>2</td>
			<td>Prueba 2</td>
		</tr>
		<tr>

			<td>3</td>
			<td>Prueba 3</td>
		</tr>
		<tr>

			<td>4</td>
			<td>prueba 4</td>
		</tr>
	</table>

	<br />
	<input type="button" value="Submit" id="out">
</body>
</html>