<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>upload</title>
</head>
<body>
	<div style="margin: 0px auto; width: 500px">
		<form action="upload" method="post" enctype="multipart/form-data">
			选择图片:<input type="file" name="file" accept="image/*" />
			<br>
			<input type="submit" value="上传">
		</form>
	</div>
</body>
</html>