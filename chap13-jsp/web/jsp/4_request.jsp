<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>4_request</title>
</head>
<body>
	<h1 align="center">메뉴 주문</h1>
	<form action="<%= request.getContextPath() %>/menu/order" method="post">
		<select id="menu" name="menuName">
			<option value="햄버거">햄버거</option>
			<option value="짜장면">짜장면</option>
			<option value="짬뽕">짬뽕</option>
			<option value="순대국">순대국</option>
		</select>
		<input type="number" min="0" max="100" step="1" name="amount">
		<button type="submit">선택 완료</button>
	</form>
</body>
</html>