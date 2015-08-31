<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Grupos Registro, Actualizacion y Borrado</title>
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

<div style="width: 95%; margin: 0 auto;">
	
	<div id="AddCtGrupo_Dialog" style="display: none;">
			<%@ include file="ctGrupo_Form.jsp"%>
		</div>

		<h1>Lista de Grupos</h1>

		<button class="pure-button pure-button-primary" onclick="addGrupo()">
			<i class="fa fa-plus"></i> Agregar Grupo
		</button>
		<br>
		<table class="pure-table pure-table-bordered pure-table-striped">
			<thead>
				<tr>
					<th width="4%">No.</th>
					<th width="12%">Nombre del Grupo</th>
					<th width="12%">Curso</th>
					<th width="12%">Profesor</th>
					<th width="12%">Horario</th>
					<th width="48%"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${lista_ctGrupo}" var="ctGrupo">
					<tr>
						<td><c:out value="${ctGrupo.iIdGrupo}" /></td>
						<td><c:out value="${ctGrupo.cNomGrupo}" /></td>
						<td><c:out value="${ctGrupo.iIdCur}" /></td>
						<td><c:out value="${ctGrupo.iIdProfesor}" /></td>
						<td><c:out value="${ctGrupo.dtHorario}" /></td>
						
						<td><nobr>

								<button class="pure-button pure-button-primary"
									onclick="editGrupo('${ctGrupo.iIdGrupo}');">
									<i class="fa fa-pencil"></i> Editar
								</button>

								<a class="pure-button pure-button-primary"
									onclick="return confirm('¿Desea Eliminar el usuario  selecionado?');"
									href="eliminar/${ctGrupo.iIdGrupo}"> <i
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
		src='<c:url value="/resources/js/ctGrupo.js"/>'></script>

</body>
</html>