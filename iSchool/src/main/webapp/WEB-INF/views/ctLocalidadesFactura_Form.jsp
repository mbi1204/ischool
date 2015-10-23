<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>





<form:form id="Form_ctPuesto" commandName="ctPuesto" method="post"
	action="${actionUrl}" class="pure-form pure-form-aligned">
	
	<table id="tableLocFac"  border="1">
		<thead>
			<tr>
				<th width="30%">Colonia</th>
				<th width="30%">Municipio</th>
				<th width="30%">Estado</th>
			</tr>
		</thead>

		<tbody>
		</tbody>
	</table>
	

</form:form>