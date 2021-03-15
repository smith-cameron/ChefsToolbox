<%@ tag language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chef ${currentUser.firstName}'s Toolkit</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<nav>
	<a class="pageLink" href="">Add Recipe</a> | <a class="pageLink" href="">Add Ingredient</a> | <a class="pageLink" href="">Recipes</a> | <a class="pageLink" href="">Ingredients</a> | <a class="pageLink" href="">Directory</a> | <a class="pageLink" href="/logOutUser">Logout</a>
	</nav>
	<jsp:doBody/>
</body>
</html>