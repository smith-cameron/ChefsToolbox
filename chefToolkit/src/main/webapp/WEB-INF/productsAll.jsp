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
		<h1 id="head">Product Inventory</h1>
		<div id="displayTable">
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
			<c:forEach items="${products}" var="product">
				<tr>
				<td class="tData"><a class="tLink" href="/toolbox/product/edit/${product.id}">${product.name}</a></td>
				<td class="tData">$${product.cost}</td>
				<td class="tData">${product.quantity}</td>
				<td class="tData">${product.unitOfMeasure}</td>
				<td><a class="tLink" href="/toolbox/ingredient/delete/${product.id}">Delete</a></td>
				</tr>
			</c:forEach>
			</tbody>
			</table>
		</div>
	</t:wrapper>
	</div>
</body>
</html>