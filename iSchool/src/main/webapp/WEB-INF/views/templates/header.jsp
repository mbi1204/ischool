
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/script.js" />"></script>
<script	src="<c:url value="http://code.jquery.com/jquery-latest.min.js" />"></script>





<div id='cssmenu'>
	<ul>

		<c:if test="${ not empty  Usuario}">

			<c:if test="${not empty listCompanias}">
				<li><a href='#'>Empresas</a>
					<ul>
						<c:forEach items="${listCompanias}" var="Companias">

							<li><a
								href="getCompania.do?action=Menu&cCompania=<c:out value="${Companias.cCveCia}"/>">
									<span><c:out value="${Companias.cCveCia}" /></span>
							</a></li>

						</c:forEach>
					</ul></li>
			</c:if>

			<c:forEach items="${listMenu}" var="Modulo">
				<li class='has-sub'><a href='#'> <span> <c:out
								value="${Modulo.cModulo}" />
					</span></a>
					<ul>
						<c:forEach items="${listSubMenu}" var="Evento">
							<c:choose>
								<c:when test="${Evento.cModulo==Modulo.cModulo}">
									<li><a href="${Evento.cEvento}" ><c:out	value="${Evento.cNombre}" /></a></li>
								</c:when>
							</c:choose>
						</c:forEach>
					</ul></li>
			</c:forEach>


			<li><a href="<c:url value='logout.do' />">Cerrar sesión</a></li>
		</c:if>



	</ul>
</div>

