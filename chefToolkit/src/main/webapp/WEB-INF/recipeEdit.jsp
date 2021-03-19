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
		<h1 id="head">Adjust ${recipe.name}</h1>
		<div id="formDiv">
		<form:form action="/toolbox/recipe/edit/${recipe.id}" method="post" modelAttribute="recipe">
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
			<form:errors class="validations" path="unitOfMeasure"/>
			<div class="formGroup">
				<form:label path="unitOfMeasure">Unit Of Measure:</form:label>
				<form:select class="formInput" path="unitOfMeasure">
					<form:option value="oz">oz</form:option>
					<form:option value="floz">floz</form:option>
					<form:option value="ea">ea</form:option>
				</form:select>
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
			<input class="button" type="submit" value="Update">
		</form:form>
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
				<td><a class="link" href="/toolbox/product/edit/${product.id}">${product.name}</a></td>
				<td><a class="link" href="/toolbox/recipe/edit/${recipe.id}/${product.id}/removeproduct">Remove</a></td>
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