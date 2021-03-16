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
		<h1 id="head">Adjust Ingredients In ${currentRecipe.name}</h1>
		<form:form action="/toolbox/recipe/adding/${currentRecipe.id}" method="post" modelAttribute="recipeItem">
		<form:hidden path="recipe" value="${currentRecipe.id}"/>
		<div class="formGroup">
			<form:select class="formInput" path="ingredient" >
				<c:forEach items="${ingredients}" var="ingredient">
					<form:option value="${ingredient.id }">${ingredient.name }</form:option>
				</c:forEach>
			</form:select>
		</div>
			<form:errors class="validations" path="amount"/>
		<div class="formGroup">
			<form:label path="amount">Amout:</form:label>
			<form:input class="formInput" path="amount"/>
		</div>
		<input class="button" type="submit" value="Add Ingredient">
		</form:form>
		<h1 id="head">Ingredients In ${currentRecipe.name}</h1>
		<div id="ingredientsTable">
			<table>
			<thead>
			<tr>
			<th class="tHead">Name</th>
			<th class="tHead">Cost</th>
			<th class="tHead">Quantity</th>
			<th class="tHead">UoM</th>
			<th class="tHead">Action</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${currentRecipeItems.ingredientid}" var="ingredient">
				<tr>
				<td class="tData"><a class="tLink" href="/toolbox/ingredient/edit/${ingredient.id}">${ingredient.name}</a></td>
				<td class="tData">$${ingredient.cost}</td>
				<td class="tData">${ingredient.quantity}</td>
				<td class="tData">${ingredient.unitOfMeasure}</td>
				<td><a class="tLink" href="/toolbox/ingredient/delete/${ingredient.id}">Delete</a></td>
				</tr>
			</c:forEach>
			</tbody>
			</table>
		</div>
	</t:wrapper>
	</div>
</body>
</html>