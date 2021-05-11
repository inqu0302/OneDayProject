 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다이어트 헬퍼</title>
</head>
<body>
	<h1>다이어트 헬퍼에 오신걸 환영합니다.</h1>
	<table>
	<tr>
	<th>날짜</th>
	<td><th>식품명</th>
	<td><th>섭취량</th>
	<td><th>총에너지</th>
	<td><th>단백질</th>
	<td><th>지방</th>
	<td><th>탄수화물</th>
	<td><th>당류</th>
	</tr>
	
	<c:if test="${ empty EAT }">정보 없음</c:if>
	<c:forEach items="${EAT}" var="EAT">
	<tr>
	<th>${EAT.mf_date}</th>
	<td><th>${EAT.fd_name}</th>
	<td><th>${EAT.mf_eat}</th>
	<td><th>${EAT.mf_kcal}</th>
	<td><th>${EAT.mf_protein}</th>
	<td><th>${EAT.mf_fat}</th>
	<td><th>${EAT.mf_carbohydrate}</th>
	<td><th>${EAT.mf_sugar}</th>
		 </c:forEach>
	</table>
	
	<table>
	<th>
	<form action="/food/serch">
	<button>식품 정보 조회</button>
	</form>
	</th>
	<th>
	<form action="/food/eatfood">
	<button>섭취 정보</button>
	</form>
	</th>
	</table>
</body>
</html>