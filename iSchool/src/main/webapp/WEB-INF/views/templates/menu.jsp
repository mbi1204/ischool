
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="<c:url value="/resources/css/menu/menu-styles.css" />"
	rel="stylesheet">



<div id='cssmenu'>


	<c:if test="${empty List_ctMenu}">
		<c:redirect url="/" />
	</c:if>

	<ul>
		<c:forEach items="${List_ctMenu}" var="Menu">
			<li><a href='#'><c:out value="${Menu.cMenu}" /></a>

				<ul>
					<c:forEach items="${List_ctPrograma}" var="Programa">

						<c:choose>
							<c:when test="${Menu.iIdMenu==Programa.iIdMenu}">
								<li><a href="${Programa.cPrograma}"><span><c:out
												value="${Programa.cNombre}" /></span></a></li>
							</c:when>
						</c:choose>

					</c:forEach>
				</ul></li>


		</c:forEach>
	</ul>



</div>