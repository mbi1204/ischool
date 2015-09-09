<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<html>
<head>
<title>Usuario</title>

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
		<div id="AddCtPrograma_Dialog">
			<%@ include file="ctPrograma_Form.jsp"%>
		</div>

		<h1>Lista de Programas</h1>

		<button class="pure-button pure-button-primary"
			onclick="add_ctPrograma()">
			<i class="fa fa-plus"></i> Agregar Programa
		</button>

		<br>
		<table class=" pure-table  pure-table-bordered pure-table-striped">
			<thead>
				<tr>
					<th>ID Menu</th>
					<th>Menu</th>
					<th>ID Programa</th>
					<th>Nombre</th>
					<th>Programa</th>
					<th>Activo</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${lista_ctPrograma}" var="ctPrograma">
					<tr>
						<td><c:out value="${ctPrograma.iIdMenu}" /></td>
						<td><c:out value="${ctPrograma.menu.cMenu}" /></td>
						<td><c:out value="${ctPrograma.iIdPrograma}" /></td>
						<td><c:out value="${ctPrograma.cNombre}" /></td>
						<td><c:out value="${ctPrograma.cPrograma}" /></td>
						<td><c:out value="${ctPrograma.lActivo}" /></td>

						<td><nobr>
								<button class="pure-button pure-button-primary"
									onclick="edit_ctPrograma(${ctPrograma.iIdMenu} , ${ctPrograma.iIdPrograma});">
									<i class="fa fa-pencil"></i> Editar
								</button>

								<a class="pure-button pure-button-primary"
									onclick="return confirm('¿Desea Eliminar el Programa  selecionado?');"
									href="remove_ctPrograma/${ctPrograma.iIdMenu}&${ctPrograma.iIdPrograma}">
									<i class="fa fa-times"></i>Eliminar
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
		src='<c:url value="/resources/js/ctPrograma.js"/>'></script>


</body>
</html>