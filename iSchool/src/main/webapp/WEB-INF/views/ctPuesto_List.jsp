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


		<div id="AddCtPuesto_Dialog" style="display: none;">
			<%@ include file="ctPuesto_Form.jsp"%>
		</div>




		<h1>Lista de Puestos</h1>

		<button class="pure-button pure-button-primary"
			onclick="add_ctPuesto()">
			<i class="fa fa-plus"></i> Agregar Puesto
		</button>
		<br>
		<table class="pure-table pure-table-bordered pure-table-striped">
			<thead >
				<tr>
					<th width="4%">ID</th>
					<th width="12%">Puesto</th>
					<th width="12%">Activo</th>
					<th width="48%"></th>
				</tr>
			</thead>
			<tbody >
				<c:forEach items="${lista_ctPuesto}" var="ctPuesto">
					<tr>

						<td><c:out value="${ctPuesto.iIdPuesto}" /></td>
						<td><c:out value="${ctPuesto.cPuesto}" /></td>
						<td><c:out value="${ctPuesto.lActivo}" /></td>


						<td><nobr>

								<button class="pure-button pure-button-primary"
									onclick="edit_ctPuesto(${ctPuesto.iIdPuesto});">
									<i class="fa fa-pencil"></i> Editar
								</button>


								<a class="pure-button pure-button-primary"
									onclick="return confirm('¿Desea Eliminar el puesto  selecionado?');"
									href="remove_ctPuesto/${ctPuesto.iIdPuesto}"> <i
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
		src='<c:url value="/resources/js/ctPuesto.js"/>'></script>
</body>
</html>