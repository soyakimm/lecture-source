<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.greedy.el.model.dto.MemberDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>전달 된 request 객체에 저장 된 Member 객체 필드 값 출력하기</h2>
	
	<%-- <%
		MemberDTO member = (MemberDTO)request.getAttribute("member");
	%>
	이름 : <%= member.getName() %> <br>
	나이 : <%= member.getAge() %> <br>
	전화번호 : <%= member.getPhone() %> <br>
	이메일 : <%= member.getEmail() %> <br> --%>
	
	<!-- EL 표현식으로 작성 -->
	이름 : ${ requestScope.member.name } <br>
	나이 : ${ requestScope.member.age } <br>
	전화번호 : ${ requestScope.member.phone } <br>
	이메일 : ${ requestScope.member.email } <br>
	
	이름 : ${ member.name } <br>
	나이 : ${ member.age } <br>
	전화번호 : ${ member.phone } <br>
	이메일 : ${ member.email } <br>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>