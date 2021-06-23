<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적처리 시스템</title>
</head>
	<link href="${rootPath}/static/css/table.css?ver=2021-06-18-0053" rel="stylesheet"/>
<%@ include file="/WEB-INF/views/include/include_header.jspf" %>
<body>
	<table>
			<tr>
				<th>학번</th>
				<th>이름</th>
				<th>학과</th>
				<th>학년</th>
				<th>전화번호</th>
				<th>주소</th>
			</tr>
			<c:forEach items="${STLIST}" var="ST">
				<tr data-num="${St.st_num}">
					<td>${ST.st_num}</td>
					<td>${ST.st_name}</td>
					<td>${ST.st_dept}</td>
					<td>${ST.st_grade}</td>
					<td>${ST.st_tel}</td>
					<td>${ST.st_addr}</td>
				</tr>
			</c:forEach>
		</table>
</body>
</html>