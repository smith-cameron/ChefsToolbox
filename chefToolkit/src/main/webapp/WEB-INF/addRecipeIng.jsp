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
<title>Chefs Toolbox</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div id="wrapper">
	<t:wrapper>
		<h1 id="head">Find Products for ${recipe.name}</h1>
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
				<td><a class="link" href="/${recipe.id}/${product.id}/removeproduct">Remove</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	<div class="recByProd">
	<h2 class="subHead">Product Inventory:</h2>
		<div >
			<form id="inputForm" action="/toolbox/recipe/adding/${recipe.id}" method="post">
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
		<a href="/toolbox/recipe/"><button id="done">Done</button></a>
	</t:wrapper>
	</div>
</body>
</html>