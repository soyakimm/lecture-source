<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el-jstl</title>
</head>
<body>
	<h1 align="center">JSP Action Tag</h1>
	<h3><a href="views/action/testAction.jsp">JSP Action Tag 테스트</a></h3>
	
	<br>
	
	<h2>EL test</h2>
	<h3><a href="test1">request.getAttribute() 테스트</a></h3>
	<h3><a href="test2">request에 저장 된 객체 출력 테스트</a></h3>
	<h3><a href="views/el/testEl3.jsp?name=galaxy&price=95&no=5&no=6&option=삼성">parameter로 값 전달한 경우 el 테스트</a></h3>
	<h3><a href="test4">requestScope와 sessionScope 테스트</a></h3>
	
	<br>
	
	<h2>JSTL test</h2>	
	<h3><a href="views/jstl/testJstlCore.jsp">Core Library Test</a></h3>
	<h3><a href="views/jstl/testJstlFmt.jsp">Fmt Library Test</a></h3>
	<h3><a href="views/jstl/testFunction.jsp">Function Library Test</a></h3>
</body>
</html>






