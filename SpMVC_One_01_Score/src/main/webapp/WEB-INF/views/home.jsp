<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<%@ page session="false" %>
<html>

<head>
	<title>성적처리 시스템</title>
	<link href="${rootPath}/static/css/table.css?ver=2021-06-18-0052" rel="stylesheet"/>
<%@ include file="/WEB-INF/views/include/include_header.jspf" %>
</head>
<body>

<table>
	<tr>
		<th>학번</th>
		<th>이름</th>
		<th>전공</th>
		<th>학년</th>
		<th>응시과목</th>
		<th>총점</th>
		<th>평균</th>
	</tr>
	<tr>
		<td>20210001</td>
		<td>홍길동</td>
		<td>컴퓨터</td>
		<td>2</td>
		<td>3</td>
		<td>275</td>
		<td>91.6</td>
	</tr>
</table>
</body>
<script>
	documetn.addEventListener("DOMContentLoaded", ()=>{
		document.querySelector("table").addEventListener("click",(ev)=>{
			
			let tagName = ev.target.tagName
			
			if(tagName == "TD"){
				let seq = ev.
			}
		})
	})
	
</script>
</html>
