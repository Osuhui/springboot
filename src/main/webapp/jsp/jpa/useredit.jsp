<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>userList</title>
</head>
<body>
	<div style="margin: 0px auto; width: 500px">
		<form action="/jpa/userupdate" method="post">
			name: <input name="usrName" value="${user.usrName}"> <br>
			<input type="hidden" name="usrId" value="${user.usrId}">
			<button type="submit">提交</button>
		</form>
	</div>
</body>
</html>