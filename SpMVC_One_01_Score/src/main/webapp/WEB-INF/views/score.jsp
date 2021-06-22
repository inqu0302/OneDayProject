<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적처리 시스템</title>
</head>
	<link href="${rootPath}/static/css/table.css?ver=2021-06-18-0052" rel="stylesheet"/>
<%@ include file="/WEB-INF/views/include/include_header.jspf" %>
<body>
	<table>
			<tr>
				<th>학번</th>
				<th>과목</th>
				<th>점수</th>
			</tr>
			<c:forEach items="${SCORE}" var="SCORE">
				<tr data-num="${SC.sc_stnum}">
					<td>${SC.sc_stnum}</td>
					<td>${SC.sc_subject}</td>
					<td>${SC.sc_score}</td>
				</tr>
			</c:forEach>
		</table>
</body>
</html>