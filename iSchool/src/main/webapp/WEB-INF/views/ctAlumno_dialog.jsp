<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:url var="actionUrl" value="/ctAlumno/editar" />

<form:form id="ctAlumnoDialog" commandName="ctAlumno" method="post"
	action="${actionUrl}" class="pure-form pure-form-aligned">
	
	<fieldset><legend></legend>
		<table>
			<tr>
				
			</tr>
		</table>
	</fieldset>	
</form:form>