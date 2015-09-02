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

	<section class="container">
		<div class="login">

			<c:url var="actionUrl" value="sysUsuMenu/add" />



			<form:form id="Form_Login" commandName="ctUsuario" method="post"
				action="${actionUrl}" class="pure-form pure-form-aligned">

				<h1>Iniciar sesión</h1>


				<form:label path="cUsuario">
					<spring:message text="Usuario" />
				</form:label>
				<form:input path="cUsuario" placeholder="Usuario" size="10" readonly="true" maxlength="10" />
				
				<form:label path="c">
					<spring:message text="Usuario" />
				</form:label>
				<form:input path="cUsuario" placeholder="Usuario" size="10" readonly="true" maxlength="10" />
				



				<p>
					<font color="red"> ${cResultado}</font>
				</p>

				<p class="submit">
					<input type="submit" name="commit" value="Login">
				</p>



			</form:form>
		</div>

	</section>

</body>
</html>
