
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<link href="<c:url value="/resources/css/menu/menu-styles.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/menu/menu-script.js" />"></script>
<script	src="<c:url value="http://code.jquery.com/jquery-latest.min.js" />"></script>





<!-- <div id='cssmenu'>
	
	<ul id="menu">

		<li><a href="ctPuesto">Puesto</a></li>
		<li><a href="ctUsuario">Usuario</a></li>
		<li><a href="ctMenu">Menu</a></li>
		<li><a href="ctPrograma">Programa</a></li>
		<li><a href="configUsuario">Configuracion de Usuarios</a></li>
		<li><a href="ctAlumno">Inscripcion</a></li>
		<li><a href="ctProfesor">Profesor</a></li>
		<li><a href="ctCurso">Curso</a></li>
		<li><a href="ctGrupo">Grupo</a></li>
	</ul>
		



	
</div>
 -->

<div id='cssmenu'>
<ul>
   <li><a href='#'>Home</a></li>
   <li class='active has-sub'><a href=''>Products</a>
      <ul>
         <li class='has-sub'><a href='ctPuesto'>Product 1</a>  </li>
         <li class='has-sub'><a href='ctUsuario'>Product 2</a>  </li>
      </ul>
   </li>
   <li><a href='#'>About</a></li>
   <li><a href='#'>Contact</a></li>
</ul>
</div>
