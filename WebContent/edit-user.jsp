<%@ page language="java" contentType="text/html; charset=UTF-8"
 	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit User</title>
</head>
<body>
<form action = "editUserServlet" method="post">
<h1> Edit User</h1>
Username: <input type ="text" name = "username" value= "${userToEdit.username}"> <br>
<br>
<input type = "hidden" name = "userId" value="${userToEdit.userId}">
<input type = "submit" value="Update Username">
</form>

<br>

<form action="navigateOwnedGames" method="post">
<table>
	<tr>
		<td> </td>
		<td>Game Name</td>
		<td>Price</td>
	</tr>
	<c:forEach var = "gameVal" items = "${userToEdit.gamesOwned}">
 	<tr>
 		<td><input type="radio" name="gameId" value="${gameVal.gameId}"> </td>
 		<td>${gameVal.name } </td>
 		<td>\$${gameVal.price } </td>
	</tr>
 	</c:forEach>
</table>
<input type = "hidden" name = "userId" value="${userToEdit.userId}">
<input type = "submit" value = "Delete Game" name="doThisToGame">
<input type="submit" value = "Add Game" name = "doThisToGame">
</form>

<br><br>
<a href = "viewAllUsersServlet">View All Users</a>
<br>
<a href = "index.html">Main Menu</a>
</body>
</html>