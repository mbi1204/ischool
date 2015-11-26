<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet"
	href='<c:url value="/resources/css/pure-0.4.2.css"/>'>

<link rel="stylesheet"
	href='<c:url value="/resources/css/font-awesome-4.0.3/css/font-awesome.css"/>'>

<link rel="stylesheet"
	href='<c:url value="/resources/css/jquery-ui-1.10.4.custom.css"/>'>

<style type="text/css">
th {
	text-align: left
}

td {
	border: 1px #DDD solid;
	padding: 5px;
	cursor: pointer;
}

.selected {
	background-color: orange;
}
</style>

</head>
<body onload="carga();">


<%@ include file="/WEB-INF/views/templates/menu.jsp"%>
	<div style="width: 95%; margin: 0 auto;">
	<h1>Pagos</h1>		

	<c:url var="actionUrl" value="cbPagoReporte" />
	
	<p/><input type="radio" name="caso" value="Todos" checked="checked"/>Todos
	<p/><input type="radio" name="caso" value="NoIdentificados" />No identificados

	<button type="button" onclick="carga_reporte();">Buscar</button>

	<table id="mytable" class="pure-table pure-table-bordered  ">
		<thead>
			<tr>
				<th width="4%">ID</th>
				<th width="12%">Fecha de pago</th>
				<th width="12%">Monto</th>
				<th width="12%">Referencia</th>
				<th width="12%">Concepto</th>
				<th width="12%">Fecha de aplicacion</th>
				<th width="12%">Monto x aplicar</th>				
				<th width="12%">Observaciones</th>								
				<th width="12%">Activo?</th>								
				<th width="12%"></th>
				<th width="48%"></th>
			</tr>
		</thead>

		<tbody>
		</tbody>
	</table>
	
</div>


	<!--  It is advised to put the <script> tags at the end of the document body so they don't block rendering of the page -->
	<script type="text/javascript"
		src='<c:url value="/resources/js/lib/jquery-1.10.2.js"/>'></script>
	<script type="text/javascript"
		src='<c:url value="/resources/js/lib/jquery-ui-1.10.4.custom.js"/>'></script>
	<script type="text/javascript"
		src='<c:url value="/resources/js/lib/jquery.ui.datepicker.js"/>'></script>


	<script type="text/javascript"
		src='<c:url value="/resources/js/cbPago.js"/>'></script>

</body>
</html>