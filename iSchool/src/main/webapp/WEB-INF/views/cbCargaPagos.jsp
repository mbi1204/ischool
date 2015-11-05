<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
<title>Carga Pagos Alumno</title>
</head>
<body>

<%@ include file="/WEB-INF/views/templates/menu.jsp"%>	

	<form method="POST" action="uploadFile" enctype="multipart/form-data">
		Archivo de pagos: <input type="file" name="file"><br /> 
		<br /> <br /> 
		<input type="submit" value="Upload"> Press here to upload the file!
	</form>
	
</body>
</html>