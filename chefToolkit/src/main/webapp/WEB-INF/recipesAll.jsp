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
		<h1 id="head">Recipes</h1>
		<div id="displayTable">
			<table>
			<thead>
			<tr>
			<th class="tHead">Name</th>
			<th class="tHead">Yield</th>
			<th class="tHead"></th>
			<th class="tHead">Serving</th>
			<th class="tHead">Cost %</th>
			<th class="tHead">Action</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${recipes}" var="recipe">
				<tr>
				<td class="tData"><a class="tLink" href="/toolbox/recipe/show/${recipe.id}">${recipe.name}</a></td>
				<td class="tData">${recipe.yield}</td>
				<td class="tData">${recipe.unitOfMeasure}</td>
				<td class="tData">${recipe.serving}</td>
				<td class="tData">${recipe.costPercentage}</td>
				<td><a class="tLink" href="/toolbox/recipe/delete/${recipe.id}">Delete</a> | <a class="tLink" href="/toolbox/recipe/edit/${recipe.id}">Edit</a></td>
				</tr>
			</c:forEach>
			</tbody>
			</table>
		</div>
		
	</t:wrapper>
	</div>
</body>
</html>