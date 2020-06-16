<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>userList_mybatis</title>
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
			<c:forEach items="${page.list}" var="user" varStatus="st">
				<tr>
					<td>${user.usrId}</td>
					<td>${user.usrName}</td>
					<td><a href="/mybatis/userpage/${user.usrId}">编辑</a></td>
					<td><a href="/mybatis/userpage/${user.usrId}">删除</a></td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<div>
			<a href="?start=1">[首 页]</a>
			<a href="?start=${page.pageNum-1}">[上一页]</a>
			<a href="?start=${page.pageNum+1}">[下一页]</a>
			<a href="?start=${page.pages}">[末 页]</a>
		</div>
		<br>
	</div>
</body>
</html>