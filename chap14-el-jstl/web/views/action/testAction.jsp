<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>testAction</title>
</head>
<body>
	<%-- <%@ include file = "common.jsp" %> --%>
	<%-- JSP Action Tag의 경우 여닫는 태그 반드시 작성해야함 --%>
	<jsp:include page="common.jsp"/>
	
	<%
	request.setAttribute("name", "홍길동"); //속성을 저장한다
	/*RequestDispatcher rd = request.getRequestDispatcher("testForward.jsp");
	rd.forward(request, response); */
	
	/*  주석처리한 부분을 jsp action태그로 변환할 수 있다 */
	%>
	
	<jsp:forward page="testForward.jsp"/>
</body>
</html>