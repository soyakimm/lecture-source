<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>5_response</title>
</head>
<body>
	<!-- 응답하기 위해 헤더에 text/html; charset=UTF-8 설정을 해주어야 하는데 이미 위에서 페이지 지시자 태그에 작성해 두었다. -->
	<%
		/* request에 setAttribute로 담은 값을 getAttribute로 꺼내올 수 있다. */
		String menuName = (String) request.getAttribute("menuName");
		int amount = (Integer) request.getAttribute("amount");
		int orderPrice = (Integer) request.getAttribute("orderPrice");
	%>
	<h3>주문하신 음식 : <%= menuName %></h3>
	<h3>주문하신 수량 : <%= amount %>인분</h3>
	<h3>결제하실 최종 금액 : <%= orderPrice %></h3>
</body>
</html>