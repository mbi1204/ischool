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
	<h1>Reporte De Alumnos Por Grupo</h1>
	

	<c:url var="actionUrl" value="configUsuario" />

	<form:form id="Form_ctGrupo" commandName="ctGrupo" method="post"
		action="${actionUrl}" class="pure-form pure-form-aligned">

		<form:label path="ctGrupo">
			<spring:message text="Grupo" />
		</form:label>
		<form:select path="cUsuario" items="${lista_ctGrupo}"
			itemValue="cUsuario" itemLabel="cNombre"
			onchange="carga_ctGrupo(value);" />

	</form:form>

	<button class="pure-button pure-button-primary"
		onclick="add_sysUsuMenu()">
		<i class="fa fa-plus"></i> Agregar Menu
	</button>


	<table id="mytable" class="pure-table pure-table-bordered  ">
		<thead>
			<tr>
				<th width="4%">ID</th>
				<th width="12%">Menu</th>
				<th width="12%">Activo</th>
				<th width="48%"></th>

			</tr>
		</thead>

		<tbody>
		</tbody>
	</table>


	<button class="pure-button pure-button-primary"
		onclick="add_sysPrograma()">
		<i class="fa fa-plus"></i> Agregar Programa
	</button>
	
</div>


	<!--  It is advised to put the <script> tags at the end of the document body so they don't block rendering of the page -->
	<script type="text/javascript"
		src='<c:url value="/resources/js/lib/jquery-1.10.2.js"/>'></script>
	<script type="text/javascript"
		src='<c:url value="/resources/js/lib/jquery-ui-1.10.4.custom.js"/>'></script>
	<script type="text/javascript"
		src='<c:url value="/resources/js/lib/jquery.ui.datepicker.js"/>'></script>


	<script type="text/javascript"
		src='<c:url value="/resources/js/configUsuario.js"/>'></script>


</body>
</html>