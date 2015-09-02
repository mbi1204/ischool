<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Home</title>

</head>
<body>



	<h1>Sistema de Inscripciones</h1>

	<ul id="menu">

		<li><a href="ctPuesto">Puesto</a></li>
		<li><a href="ctUsuario">Usuario</a></li>
		<li><a href="ctMenu">Menu</a></li>
		<li><a href="ctPrograma">Programa</a></li>
		<li><a href="configUsuario">Configuracion de Usuarios</a></li>				
		<li><a href="ctAlumno">Inscripcion</a></li>
		<li><a href="ctProfesor">Profesor</a></li>
		<li><a href="ctCurso">Curso</a></li>
		<li><a href="ctGrupo">Grupo</a></li>
	</ul>

	<section class="container">
		<div class="login">

			<c:url var="actionUrl" value="ctUsuario/Login" />



			<form:form id="Form_Login" commandName="ctUsuario" method="post"
				action="${actionUrl}" class="pure-form pure-form-aligned">

				<table style="margin: 0 auto;" >
					<tr>
						<td colspan="2" style="text-align: center">
							<h1>Iniciar sesión</h1>
						</td>
					</tr>

					<tr>
						<td><form:label path="cUsuario">
								<spring:message text="Usuario" />
							</form:label></td>
						<td><form:input path="cUsuario" placeholder="Usuario"
								size="20" maxlength="20" /></td>
					</tr>
					<tr>
						<td><form:label path="cPassword">
								<spring:message text="Password" />
							</form:label></td>

						<td><form:input type="password" path="cPassword"
								placeholder="Password" size="20" maxlength="20" /></td>
					</tr>

					<tr>
						<td colspan="2" style="text-align: center"><font color="red">
								${cResultado}</font></td>
					</tr>

					<tr>
						<td colspan="2" align="center"><input type="submit" name="aceptar" value="Aceptar" ></td>
					</tr>
				</table>
			</form:form>
		</div>

	</section>

</body>
</html>
