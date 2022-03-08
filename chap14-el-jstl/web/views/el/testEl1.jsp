<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>전달 된 request 객체에서 저장된 정보 출력하기</h2>
<%-- 	<%
		String name = (String)request.getAttribute("name");
		int age = (Integer)request.getAttribute("age");
		String phone = (String)request.getAttribute("phone");
	%>
	name : <%= name %> <br>
	age : <%= age %> <br>
	phone : <%= phone %> <br> --%>
	
	<!-- EL 표현식으로 출력하기 -->
	name : ${ requestScope.name } <br>
	age : ${ requestScope.age } <br>
	phone : ${ requestScope.phone } <br>
	
	<!-- 스코프 범위 생략 가능함(알아서 찾음) -->
	name : ${ name } <br>
	age : ${ age } <br>
	phone : ${ phone } <br>
	
	<br>
	
	<h2>items 이름으로 저장 된 리스트 정보 출력하기</h2>
	<%-- <%
		ArrayList items = (ArrayList)request.getAttribute("items");
	%>
	
	<% for(int i = 0; i < items.size(); i++) { %>
		<%= i %> : <%= items.get(i) %> <br>
	<% } %> --%>
	
	0 : ${ requestScope.items[0] } <br>
	1 : ${ requestScope.items[1] } <br>
	2 : ${ requestScope.items[2] } <br>
	
	0 : ${ items[0] } <br>
	1 : ${ items[1] } <br>
	2 : ${ items[2] } <br>
	
	
</body>
</html>