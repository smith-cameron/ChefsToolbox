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
		<h1 id="head">${recipe.name}</h1>
		<div id="recipeShowTable">
			<table>
			<thead>
			<tr>
			<th class="tHead">Name</th>
			<th class="tHead">Cost</th>
			<th class="tHead">Quantity</th>
			<th class="tHead">UoM</th>
			<th class="tHead">Action</th>
			<th class="tHead">Amount</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${products}" var="product">
				<tr>
				<td >${product.name}</td>
				<td >$${product.cost}</td>
				<td >${product.quantity}</td>
				<td >${product.unitOfMeasure}</td>
				<td><a class="tLink" href="/toolbox/product/edit/${product.id}">Edit</a></td>
				<c:forEach items="${product.ingredientsMade}" var="ingredient">
				<td>${ingredient.amount}</td>
				</c:forEach>
				<td>
					<form:form id="amountForm" action="/toolbox/recipe/show/${recipe.id}" method="post" modelAttribute="ingredient">
					<form:hidden path="product" value="${product.id}"/>
					<form:hidden path="recipe" value="${recipe.id}"/>
					<form:errors class="validations" path="amount"/>
					<div >
						<form:input path="amount" value="${amount }"/>
					</div>
					<input type="submit" value="Update">
				</form:form>
				</td>
				</tr>
			</c:forEach>
			</tbody>
			</table>
		</div>
		
	</t:wrapper>
	</div>
</body>
</html>