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
	<div id="wrapper">s
		<a class="directoryLink" href="">Ingredients</a>
		<a class="directoryLink" href="">Recipes</a>
		<a class="directoryLink" href="">Add Ingredient</a>
		<a class="directoryLink" href="">Add Recipe</a>
		<a class="directoryLink" href="">Import Spreadsheet</a>
		<a id="logoutLink" href="">Logout</a>
	</div>
</body>
</html>