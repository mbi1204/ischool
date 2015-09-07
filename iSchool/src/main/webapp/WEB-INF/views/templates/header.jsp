
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 
 
<link href="<c:url value="/resources/css/menu/menu-styles.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/menu/menu-script.js" />"></script>
<script
	src="<c:url value="http://code.jquery.com/jquery-latest.min.js" />"></script>


<div id='cssmenu'>

	 <ul>
		<c:forEach items="${List_ctMenu}" var="Menu">
			<li><a href='#'><c:out value="${Menu.cMenu}" /></a>

				<ul>
					<c:forEach items="${List_ctPrograma}" var="Programa">

						<c:choose>
							<c:when test="${Menu.iIdMenu==Programa.iIdMenu}">
							 	<li><a href="${Programa.cPrograma}"><c:out value="${Programa.cNombre}" /></a></li> 								
							</c:when>							
						</c:choose>						

					</c:forEach>
				</ul></li>


		</c:forEach>
	</ul> 

</div>