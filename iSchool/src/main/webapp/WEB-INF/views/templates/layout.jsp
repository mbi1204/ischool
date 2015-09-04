<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<style>
#header {
	background-color: white;
	color: white;
	text-align: center;
	padding: 5px;
}

#nav {
	line-height: 30px;
	background-color: #eeeeee;
	height: 300px;
	width: 100px;
	float: left;
	padding: 5px;
}

#section {
	width: 350px;
	float: left;
	padding: 10px;
}

#footer {
	/*background-color: #69c4e8;*/
	color: #69c4e8;
	clear: both;
	text-align: center;
	padding: 5px;
}
</style>
</head>


</head>
<body>

	<div id="header">
		<tiles:insertAttribute name="header" />
	</div>


	<div id="section">
		<tiles:insertAttribute name="body" />
	</div>

	<div id="footer">
		<tiles:insertAttribute name="footer" />
	</div>


</body>

</html>