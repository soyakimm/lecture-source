<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><%= request.getAttribute("name") %>님 환영합니다.</h1>
	
	<h2>jsp:useBean 활용하기</h2>
	<jsp:useBean id="member" class="com.greedy.el.model.dto.MemberDTO"/>
	<jsp:setProperty property="name" name="member" value="김소영"/>
	<jsp:setProperty property="age" name="member" value="20"/>
	<jsp:setProperty property="phone" name="member" value="010-1234-5678"/>
	<jsp:setProperty property="email" name="member" value="hello@greedy.com"/>
	
	이름 : <jsp:getProperty property="name" name="member"/> <br>
	나이 : <jsp:getProperty property="age" name="member"/> <br>
	전화번호 : <jsp:getProperty property="phone" name="member"/> <br>
	이메일 : <jsp:getProperty property="email" name="member"/> <br>
	
	
	
</body>
</html>