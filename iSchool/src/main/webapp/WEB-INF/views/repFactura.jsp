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
<body>

<%@ include file="/WEB-INF/views/templates/menu.jsp"%>
	<div style="width: 95%; margin: 0 auto;">
	<h1>Reporte De Facturas</h1>
	
	<form:form id="repFactura" method="post" action="repFactura/pdf">
		<button type="submit" onclick="return getGrupo()">Imprimr Reporte</button>
		<input id="grupo" name="grupo" type="hidden"/>
	</form:form>		

	<c:url var="actionUrl" value="repFactura" />

	<form:form id="Form_ctGrupo" commandName="ctGrupo" method="post"  
		action="${actionUrl}"  class="pure-form pure-form-aligned">

		<form:label path="cNombre">
			<spring:message text="Grupo" />
		</form:label>
		<form:select path="cNombre" items="${lista_ctGrupo}" 
			itemValue="iIdGrupo" itemLabel="cNombre"
			onchange="carga_grupo(value);" />		
	</form:form>	

	<table id="mytable" class="pure-table pure-table-bordered  ">
		<thead>
			<tr>
				<th width="4%">ID</th>
				<th width="12%">Nombre</th>
				<th width="12%">Apellido</th>				
				<th width="12%">Serie</th>
				<th width="12%">Folio</th>				
				<th width="12%">Fecha</th>
				<th width="12%">% Desc</th>
				<th width="12%">Subtotal</th>
				<th width="12%">Descuento</th>
				<th width="12%">IVA</th>
				<th width="12%">Total</th>
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
		src='<c:url value="/resources/js/repFactura.js"/>'></script>

</body>
</html>