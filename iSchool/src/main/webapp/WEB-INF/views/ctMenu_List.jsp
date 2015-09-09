<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<html>
<head>
<title>Menu</title>

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
</style>


</head>

<body>
<%@ include file="/WEB-INF/views/templates/menu.jsp"%>
	<div style="width: 95%; margin: 0 auto;">
	
	
		<div id="AddctMenu_Dialog" style="display: none;">
			<%@ include file="ctMenu_Form.jsp"%>
		</div>

	


		<h1>Lista de Menus</h1>

		<button class="pure-button pure-button-primary" onclick="add_ctMenu()">
			<i class="fa fa-plus"></i> Agregar Menu
		</button>
		<br>
		<table class="pure-table pure-table-bordered pure-table-striped">
			<thead>
				<tr>
					<th width="4%">ID</th>
					<th width="12%">Menu</th>
					<th width="12%">Activo</th>
					<th width="48%"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${lista_ctMenu}" var="ctMenu">
					<tr>
						
						<td><c:out value="${ctMenu.iIdMenu}" /></td>
						<td><c:out value="${ctMenu.cMenu}" /></td>
						<td><c:out value="${ctMenu.lActivo}" /></td>						


						<td><nobr>

								<button class="pure-button pure-button-primary"
									onclick="edit_ctMenu(${ctMenu.iIdMenu});">
									<i class="fa fa-pencil"></i> Editar
								</button>


								<a class="pure-button pure-button-primary"
									onclick="return confirm('¿Desea Eliminar el Menu  selecionado?');"
									href="remove_ctMenu/${ctMenu.iIdMenu}"> <i
									class="fa fa-times"></i>Eliminar
								</a>

							</nobr></td>
					</tr>
				</c:forEach>
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
		src='<c:url value="/resources/js/ctMenu.js"/>'></script>
</body>
</html>