<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<form:form id="dialogoAlumno" commandName="ctAlumno" method="post"
	action="${actionUrl}" class="pure-form pure-form-aligned">
	
	<form:radiobutton path="lFactura" value="Cliente"/>Cliente
								
	
	<input type="radio" name="lFactura" value="Publico en general"/>Publico en general
	<input type="radio" name="lFactura" value="Cliente"/>Cliente
	
	
	

</form:form>