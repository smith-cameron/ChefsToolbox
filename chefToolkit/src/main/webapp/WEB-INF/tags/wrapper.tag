<%@ tag language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chef ${currentUser.firstName}'s Toolkit</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<nav id="headNav">
	<a class="pageLink" href="/toolbox/recipe/create">Add Recipe</a> | <a class="pageLink" href="/toolbox/product/create">Add Product</a> | <a class="pageLink" href="/toolbox/recipe/">Recipes</a> | <a class="pageLink" href="/toolbox/product/">Products</a> | <a class="pageLink" href="/logOutUser">Logout</a>
	</nav>
	<jsp:doBody/>
</body>
</html>