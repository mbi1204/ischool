<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	
	<style>
ul#menu {
    padding: 0;
}

ul#menu li {
    display: inline;
}

ul#menu li a {
    background-color: black;
    color: white;
    padding: 10px 20px;
    text-decoration: none;
    border-radius: 4px 4px 0 0;
}

ul#menu li a:hover {
    background-color: orange;
}
</style>
	
	
</head>
<body>




<!-- 

<a href="ctMenu">Menu</a>
<a href="ctPrograma">Programa</a>
<a href="configUsuario">Configuracion de Usuarios</a>
 -->

<h1>Sistema de Inscripciones</h1>

<ul id="menu">

 <li><a href="ctPuesto">Puesto</a> </li>
 <li><a href="ctUsuario">Usuario</a> </li>
 <li><a href="configUsuario">Configuracion de Usuarios</a></li>
 <li><a href="ctAlumno">Inscripcion</a> </li>
 <li><a href="ctProfesor">Profesor</a> </li>
 <li><a href="ctCurso">Curso</a> </li>
 <li><a href="ctGrupo">Grupo</a> </li>
</ul>  



</body>
</html>
