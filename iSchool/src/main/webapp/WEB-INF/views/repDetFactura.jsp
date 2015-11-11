<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<form:form id="repDetFactura" commandName="DetFactura" method="post"
	action="${actionUrl}" class="pure-form pure-form-aligned">
	
	<table id="tableDet"  border="1">
		<thead>
			<tr>
				<th width="30%">Grupo</th>
				<th width="30%">Cantidad</th>
				<th width="30%">Subtotal</th>
				<th width="30%">Monto</th>
			</tr>
		</thead>

		<tbody>
		</tbody>
	</table>
	

</form:form>