<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Registro</title>
        <meta name="viewport" content="width=device-width, 
              user-scalable=no, initial-scale=1.0, maximun-scale=1.0, minimum-scale=1.0">
        <link href="<c:url value="/resources/css/inscripcion.css" />"rel="stylesheet"> 
        <link href="<c:url value="/resources/css/estilo.css" />"rel="stylesheet"> 
        <link href="<c:url value="/resources/css/fonts.css" />"rel="stylesheet"> 
        <script src="<c:url value="/resources/javascript/jquery-2.1.4.min.js" />"></script>
   		<script src="<c:url value="/resources/javascript/menu_move.js" />"></script>
   		<!--<script src="<c:url value="/resources/javascript/mensaje_error.js" />"></script>-->
   		<link rel="shortcut icon" href="<c:url value="/resources/imagenes/drawer.png" />" type="image/png" />
</head>
<body>
    <div class="contenedor">
        <header>
        <h1>Nombre de la escuela</h1>
        <div class="menu_bar">
            <a href="#" class="btn_menu"><span class="icon-menu">   </span>Menu</a>
        </div>
        <nav>
            <ul>
                <li><a href="/ischool/"><span class="icon-home3">   </span>Inicio   </a></li>
                <li><a href="/ischool/nosotros"><span class="icon-user-tie"></span>Nosotros </a></li>
                <li><a href="/ischool/curso"><span class="icon-books">   </span>Cursos   </a></li>
                <li><a href="/ischool/galeria"><span class="icon-camera">  </span>Galeria  </a></li>
                <li><a href="/ischool/alumno"><span class="icon-profile"> </span>Registro </a></li>
                
            </ul>
        </nav>
    </header>
        <c:url var="addAction" value="/ctAlumno/add" ></c:url>
        <section>
            <form class="registro" action="${addAction}" method="post" name="registro">
            <fieldset>
                	<legend>Datos Personales</legend>
                <ul>
                    <li><label for="cNombre">Nombre:</label>
                    <input type="text" name="cNombre" placeholder="Ej. Bogar Elias" required pattern="[a-z A-Z]*" /></li> 
                </ul>
                <ul>
                    <li><label for="cApellido">Apellidos:</label>
                    <input type="text" name="cApellido" placeholder = "Ej. Chavez Saavedra" required pattern="[a-z A-Z]*" /></li> 
                </ul>
                <ul>
                     <li><label for="dtFechaNac">Fecha de nacimiento:</label>
                     <input type="date" name="dtFechaNac"  /></li>
                </ul>
                <ul>
                    <li><label for="cCalle">Calle:</label>
                    <input type="text" name="cCalle" placeholder = "Ej. Saint Saenz" required pattern="[a-z A-Z]*" /></li> 
                </ul>
                <ul>
                    <li><label for="cNumExt">Numero Exterior:</label>
                    <input type="text" name="cNumExt" placeholder = "Ej. 62 o  Lt 15 Mz 410" required pattern=".{1,5}" /></li> 
                </ul>
                <ul>
                    <li><label for="cNumInt">Numero Interior:</label>
                    <input type="text" name="cNumInt" placeholder = "Ej. 102 o Edificio H Dep.205" required pattern=".{1,5}"/></li> 
                </ul>
                <ul>
                    <li><label for="cColonia">Colonia:</label>
                    <input type="text" name="cColonia" placeholder = "Ej. Vallejo" required pattern="[a-zA-Z]*"/></li>
                    
                </ul>
                <ul>
                    <li><label for="cCP">Codigo Postal:</label>
                    <input type="text" name="cCP" placeholder = "Ej. 05555" maxlength="5" required pattern="[0-9]{5}" /></li>
                   
                </ul>
                <ul>
                    <li><label for="cMunicipio">Municipio o Delegacion:</label>
                        <input type="text" name="cMunicipio" placeholder = "Ej. Naucalpan o Gustavo a Madero" required pattern="[a-z A-Z]*"/> </li> 
                </ul>
                <ul>
                    <li><label for="cEstado">Estado:</label>
                    <input type="text" name="cEstado" placeholder = "Ej. Edo. Mex" required /></li> 
                </ul>
                <ul>
                    <li><label for="cTel">Telefono:</label>
                    <input type="text" name="cTel" placeholder = "Ej.(55)57395841 ext 45" required pattern="[0-9].{1,8}" /></li> 
                </ul>            
            </fieldset>
            
            <fieldset>
            <legend>Curso</legend>
                <ul>
                    <li><label for="cNomCurso">Curso:</label>
                    	<ul>
                    	<select>
  							<option value="cNomCurso">Salsa</option>
  							<option value="cNomCurso">Danzon</option>
  							<option value="cNomCurso">Baile Moderno</option>
  							<option value="cNomCurso">Requezon</option>
						</select>
				    	</ul>
                </ul>
                <ul>
                <!-- Preguntar que hace esta linea vacia -->
                </ul>
            
            </fieldset>
            <button class="submit" type="submit">Registrar</button>
            </form>
        </section>
    </div>
</body>
</html>