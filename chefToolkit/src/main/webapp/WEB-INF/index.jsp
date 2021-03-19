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
<title>Welcome ${currentUser.firstName}!</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div id="wrapper">
			<a id="logoutLink" href="/logOutUser">Logout</a>
	<h1 id="head">Welcome Chef ${currentUser.firstName}</h1>
		<div id="contentLinks">
			<a class="directoryLink" href="/toolbox/product/">Ingredients</a>
			<a class="directoryLink" href="/toolbox/recipe/">Recipes</a>
			<a class="directoryLink" href="/toolbox/product/create">Add Ingredient</a>
			<a class="directoryLink" href="/toolbox/recipe/create">Add Recipe</a>
		</div>
	</div>
</body>
</html>