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
<title>Chefs Toolkit</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div id="wrapper">
	<t:wrapper>
		<h1 id="head">Adjust ${recipe.name}</h1>
		<div id="formDiv">
		<form action="/toolbox/recipe/edit/${recipe.id}" method="post">
			<div class="formGroup">
				<label >Name:</label>
				<input class="formInput" name="name" value="${recipe.name}"/>
			</div>
			<div class="formGroup">
				<label >Yield:</label>
				<input class="formInput" name="yield" value="${recipe.yield}"/>
			</div>
			<div class="formGroup">
				<label >Unit Of Measure:</label>
				<select class="formInput" name="unitOfMeasure" >
					<option value="oz">oz</option>
					<option value="floz">floz</option>
					<option value="ea">ea</option>
				</select>
			</div>
			<div class="formGroup">
				<label >Serving Size:</label>
				<input class="formInput" name="serving" value="${recipe.serving}"/>
			</div>
			<div class="formGroup">
				<label >Cost %(as decimal):</label>
				<input class="formInput" name="costPercentage" value="${recipe.costPercentage}"/>
			</div>
			<input class="button" type="submit" value="Update">
		</form>
		</div>
		<div class="recByProd1">
		<table>
		<thead>
			<tr>
				<th><h2 class="subHead">Products In:</h2></th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${productsIn}" var="product">
			<tr>
				<td><a class="link" href="/toolbox/recipe/edit/${product.id}">${product.name}</a></td>
				<td><a class="link" href="/toolbox/recipe/edit//${recipe.id}/${product.id}/removeproduct">Remove</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	<div class="recByProd">
	<h2 class="subHead">Product Inventory:</h2>
		<div >
			<form id="inputForm" action="/toolbox/recipe/edit/adding/${recipe.id}" method="post">
				<div class="formDiv">
				<select class="formInput" name="product">
					<c:forEach items="${productsNotIn}" var="product">
						<option value="${product.id}">${product.name}</option>
					</c:forEach>
				</select>
				<input type="hidden" name="amount" value="${0.0}"></input>
				</div>
				<div class="formDiv">
				<input id="button" type="submit" value="Add"/>
				</div>
			</form>
		</div>
	</div>
	</t:wrapper>
	</div>
</body>
</html>