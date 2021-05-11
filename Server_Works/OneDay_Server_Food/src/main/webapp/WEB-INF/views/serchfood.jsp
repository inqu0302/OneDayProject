<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>식품정보 전체 리스트</h1>

	<form action="/food">
	<button>Home</button>
	</form>
	
	<table>
	<tr>
	<th>식품코드</th>
	<td><th>식품명</th>
	<td><th>출시연도</th>
	<td><th>제조사</th>
	<td><th>분류</th>
	<td><th>1회 제공량</th>
	<td><th>총 용량</th>
	<td><th>열량</th>
	<td><th>단백질</th>
	<td><th>지방</th>
	<td><th>탄수화물</th>
	<td><th>당류</th>
	</tr>

	
	<c:if test="${ empty FOOD }">식품정보없음</c:if>
	<c:forEach items="${FOOD}" var="FOOD">
	<tr>
	<th>${FOOD.fd_code}</th>
	<td><th>${FOOD.fd_name}</th>
	<td><th>${FOOD.fd_year}</th>
	<td><th>${FOOD.cp_name}</th>
	<td><th>${FOOD.it_name}</th>
	<td><th>${FOOD.fd_ssize}</th>
	<td><th>${FOOD.fd_gram}</th>
	<td><th>${FOOD.fd_kcal}</th>
	<td><th>${FOOD.fd_protein}</th>
	<td><th>${FOOD.fd_fat}</th>
	<td><th>${FOOD.fd_carbohydrate}</th>
	<td><th>${FOOD.fd_sugar}</th>
		 
		 </c:forEach>
	</table>

</body>
</html>