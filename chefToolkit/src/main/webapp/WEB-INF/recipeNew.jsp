<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "t" tagdir = "/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome!</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div id="wrapper">
	<t:wrapper>
		<h1 id="head">Initialize A New Recipe</h1>
		<form:form action="/toolbox/recipe/create" method="post" modelAttribute="recipe">
				<form:errors class="validations" path="name"/>
			<div class="formGroup">
				<form:label path="name">Name:</form:label>
				<form:input class="formInput" path="name"/>
			</div>
				<form:errors class="validations" path="yield"/>
			<div class="formGroup">
				<form:label path="yield">Yield:</form:label>
				<form:input class="formInput" path="yield"/>
			</div>
				<form:errors class="validations" path="serving"/>
			<div class="formGroup">
				<form:label path="serving">Serving Size:</form:label>
				<form:input class="formInput" path="serving"/>
			</div>
				<form:errors class="validations" path="costPercentage"/>
			<div class="formGroup">
				<form:label path="costPercentage">Cost %(as decimal):</form:label>
				<form:input class="formInput" path="costPercentage"/>
			</div>
			<input class="button" type="submit" value="Create">
		</form:form>
	</t:wrapper>
	</div>
</body>
</html>