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
	<a class="pageLink" href="/toolbox/recipe/create">Add Recipe</a> | <a class="pageLink" href="/toolbox/ingredient/create">Add Ingredient</a> | <a class="pageLink" href="">Recipes</a> | <a class="pageLink" href="/toolbox/ingredient/">Ingredients</a> | <a class="pageLink" href="/toolbox/directory">Directory</a> | <a class="pageLink" href="/logOutUser">Logout</a>
	</nav>
	<jsp:doBody/>
</body>
</html>