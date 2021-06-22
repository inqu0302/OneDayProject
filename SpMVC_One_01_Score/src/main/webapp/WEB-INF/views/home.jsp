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
		<c:choose>
			<c:when test="${empty STUDENT}">
				<tr><td colspan="7">데이터가 없습니다</td></tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${STUDENT}" var="STUDENT">
					<tr data-num="${STUDENT.st_num}" class="list">
						<td>${STUDENT.st_num}</td>
						<td>${STUDENT.st_name}</td>
						<td>${STUDENT.st_dept}</td>
						<td>${STUDENT.st_grade}</td>
						<td>${STUDENT.st_subject}</td>
						<td>${STUDENT.st_avg}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	<form>
		<button id="insert">학생정보 입력</button>
	</form>
</body>
<script>
	documetn.addEventListener("DOMContentLoaded", ()=>{
		document.querySelector("table").addEventListener("click",(e)=>{
			
			let tagName = e.target.tagName
			
			if(tagName == "TD"){
				
				let urlPath= `${rootPath}`;
				let className = e.target.className;
				let num = e.target.closest("TR").dataset.num;
				
				if(className === "list"){
					urlPath = "/score/list?st_num=" + num
				}
			}
		})
		
		document.querySelector("button#insert").addEventListener("click", ()=>{
			location.href="${rootPath}/student";
		
	})
	
</script>
</html>
