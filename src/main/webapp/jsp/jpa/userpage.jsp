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
	<div align="center"></div>
	<div style="width: 500px; margin: 20px auto; text-align: center">
		<table align='center' border='1' cellspacing='0'>
			<tr>
				<td>id</td>
				<td>name</td>
				<td>编辑</td>
				<td>删除</td>
			</tr>
			<c:forEach items="${page.content}" var="user" varStatus="st">
				<tr>
					<td>${user.usrId}</td>
					<td>${user.usrName}</td>
					<td><a href="useredit?usrId=${user.usrId}">编辑</a></td>
					<td><a href="userdelete?usrId=${user.usrId}">删除</a></td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<div>
			<a href="?start=0">[首 页]</a>
			<a href="?start=${page.number-1}">[上一页]</a>
			<a href="?start=${page.number+1}">[下一页]</a>
			<a href="?start=${page.totalPages-1}">[末 页]</a>
		</div>
		<br>
		<form action="useradd" method="post">
			name: <input name="usrName"> <br>
			<button type="submit">提交</button>
		</form>
	</div>
</body>
</html>