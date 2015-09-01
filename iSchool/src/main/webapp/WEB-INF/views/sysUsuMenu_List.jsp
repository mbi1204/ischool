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

/*table.selector tbody tr:hover {
    background-color: orange;
    cursor: pointer;
}*/



 td {border: 1px #DDD solid; padding: 5px; cursor: pointer;}

     .selected {
        background-color: orange;
          }





</style>

</head>
<body onload="carga();">

	<h1>Configuracion de Usuarios</h1>
	
	
	<div id="AddsysUsuMenu_ctMenu" style="display: none;">
			<%@ include file="sysUsuMenu_Form_AddMenu.jsp"%>
	</div>
	
	
	
	 <div id="AddsysUsuMenu_ctprograma" style="display: none;">
			<%@ include file="sysUsuMenu_Form_AddPrograma.jsp"%>
	</div>
 


	<c:url var="actionUrl" value="configUsuario" />


	


	<form:form id ="Form_ctUsuario" commandName="ctUsuario" method="post" action="${actionUrl}"
		class="pure-form pure-form-aligned">

		<form:label path="cUsuario">
			<spring:message text="Usuario" />
		</form:label>
		<form:select path="cUsuario" items="${lista_ctUsuario}"
			itemValue="cUsuario" itemLabel="cNombre"
			onchange="carga_ctMenu(value);" />

	</form:form>
	
	<button class="pure-button pure-button-primary" onclick="add_sysUsuMenu()">
		<i class="fa fa-plus"></i> Agregar Menu
	</button>


	<table id="mytable"	class="pure-table pure-table-bordered  ">
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
	
	
	<button class="pure-button pure-button-primary" onclick="add_sysPrograma()">
		<i class="fa fa-plus"></i> Agregar Programa
	</button>
	
	
	<table id="mytable2"
		class="pure-table pure-table-bordered  ">
		<thead>
			<tr>
				<th width="4%">ID</th>
				<th width="12%">cPrograma</th>
				<th width="12%">cMenu</th>
				<th width="48%"></th>

			</tr>
		</thead>
		
		<tbody>
		</tbody>
	</table>








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