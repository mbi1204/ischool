<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<html>
<head>
<title>Carga Pagos Alumno</title>
</head>
<body>

	<%@ include file="/WEB-INF/views/templates/menu.jsp"%>
	<div style="width: 95%; margin: 0 auto;">

		<h1>Carga de pagos</h1>

		<form method="POST" action="uploadFile" enctype="multipart/form-data">
			Archivo de pagos: <input type="file" name="file"><br /> <br />
			<br /> <input type="submit" value="Procesar"> Presione aquí
			para cargar el archivo!
		</form>
	</div>
</body>
</html>