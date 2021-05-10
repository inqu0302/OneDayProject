<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>식품정보 조회</h1>
	<h5>전체리스트 조회</h5>
	<a href="serch/selectAll">
		<button>전체조회</button>
	</a>
	
	<h5>상품코드로 검색</h5>
	<form action="serch/findId">
		<input name ="fd_code">
		<button>검색</button>
	</form>
	<h5>상품명으로 검색</h5>
	<form action="serch/findTitle">
		<input name ="fd_name">
		<button>검색</button>
	</form>
	
	<a href="/food/">Home</a>
	
</body>
</html>