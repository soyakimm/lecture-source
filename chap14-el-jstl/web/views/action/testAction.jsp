<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>testAction</title>
</head>
<body>
	<%-- <%@ include file="common.jsp" %> --%>
	<!-- JSP Action Tag의 경우 여닫는 태그 반드시 작성해야 함 -->
	<jsp:include page="common.jsp"/>
	
	<%
		request.setAttribute("name", "김소영");
		/* RequestDispatcher rd = request.getRequestDispatcher("testForward.jsp");
		rd.forward(request, response); */
	%>
	<jsp:forward page="testForward.jsp"/>
</body>
</html>