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




	<c:url var="actionUrl" value="Login" />



	<form:form id="Form_Login" commandName="ctUsuarioSession" method="post"
		action="${actionUrl}" class="pure-form pure-form-aligned">

		<table style="margin: 0 auto;">
			<tr>
				<td colspan="2" style="text-align: center">
					<h1>Iniciar sesión</h1>
				</td>
			</tr>

			<tr>
				<td><form:label path="cUsuario">
						<spring:message text="Usuario" />
					</form:label></td>
				<td><form:input path="cUsuario" placeholder="Usuario" size="20"
						maxlength="20" /></td>
			</tr>
			<tr>
				<td><form:label path="cPassword">
						<spring:message text="Password" />
					</form:label></td>

				<td><form:input type="password" path="cPassword"
						placeholder="Password" size="20" maxlength="20" /></td>
			</tr>


			<tr>
				<td colspan="2" align="center"><input type="submit"
					name="aceptar" value="Aceptar"></td>
			</tr>
		</table>

		<font color="red"> ${vcRespuesta}</font>
	</form:form>


</body>
</html>
