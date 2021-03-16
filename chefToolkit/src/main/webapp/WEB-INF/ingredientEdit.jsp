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
		<h1 id="head">Edit ${ingredient.name}</h1>
		<form:form action="/toolbox/ingredient/edit/${ingredient.id}" method="post" modelAttribute="ingredient">
					<form:errors class="validations" path="name"/>
				<div class="formGroup">
					<form:label path="name">Name:</form:label>
					<form:input class="formInput" path="name"/>
				</div>
					<form:errors class="validations" path="cost"/>
				<div class="formGroup">
					<form:label path="cost">Cost:</form:label>
					<form:input class="formInput" path="cost"/>
				</div>
					<form:errors class="validations" path="quantity"/>
				<div class="formGroup">
					<form:label path="quantity">Quantity:</form:label>
					<form:input class="formInput" path="quantity"/>
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
				<input class="button" type="submit" value="Update">
			</form:form>
	</t:wrapper>
	</div>
</body>
</html>