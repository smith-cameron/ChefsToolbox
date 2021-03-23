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
		<div >
			<table class="recipeShowTable">
			<thead>
			<tr>
				<th class="tHead">Yield</th>
				<th class="tHead">Cost P/UoM</th>
				<th class="tHead">Serving</th>
				<th class="tHead">Cost P/Serving</th>
				<th class="tHead">Markup %</th>
				<th class="tHead">Menu Price</th>
			</tr>
			</thead>
			<tbody>
			<tr>
				<td class="recipeData">${recipe.yield}${recipe.unitOfMeasure}</td>
				<td class="recipeData">$<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${batchCost/recipe.yield} "/>p/${recipe.unitOfMeasure}</td>
				<td class="recipeData">${recipe.serving }${recipe.unitOfMeasure}</td>
				<td class="recipeData">$<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${(batchCost/recipe.yield)*recipe.serving} "/>p/${recipe.unitOfMeasure}</td>
				<td class="recipeData"><fmt:formatNumber type="number" maxFractionDigits="0" minFractionDigits="0" value="${recipe.costPercentage*100}"/>%</td> 
				<td class="recipeData">$<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${((batchCost/recipe.yield)*recipe.serving)/(recipe.costPercentage)}"/></td>
			</tr>
			</tbody>
			</table>
		</div>
		<div class="recipeShowTable">
			<form id="amountForm" action="/toolbox/recipe/show/${recipe.id}" method="post">
			
			<select name="ingredient" >
				<c:forEach items="${ingredients}" var="ingredient">
					<option value="${ingredient.id}">${ingredient.product.name}</option>
				</c:forEach>
			</select>
				<input name="amount"/>
			<input type="submit" value="Update"/>
			</form>
		</div>
		<div >
			<table class="recipeShowTable">
			<thead>
			<tr>
				<th class="tHead">Name</th>
				<th class="tHead">Amount</th>
				<th class="tHead">Cost</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${products}" var="product">
				<tr>
				<td ><a class="tLink" href="/toolbox/product/edit/${product.id}">${product.name}</a></td>
				<td hidden="${product.cost}"/>
				<td hidden="${product.quantity}${product.unitOfMeasure}"/>
				<c:forEach items="${product.ingredientsMade}" var="ing">
					<td class="recipeData">${ing.amount }</td>
					<td class="recipeData">$<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${(product.cost/product.quantity)*(ing.amount)} "/></td>
				</c:forEach>
				</tr>
			</c:forEach>
			</tbody>
			</table>
		</div>
	</t:wrapper>
	</div>
</body>
</html>
