<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!-- 자바 영역 - 지시 블럭으로 서비스 함수에서 가장 먼저 실행됨 -->


<% 
//자바 영역 - 지역변수		
/* 	int x=3;
	int y=4;
	
	int sum = add(x,y); */
		
%>

<%!	
//자바 영역 - 함수 모음
/* 	private int add(int x, int y){
	 return x+y; } */
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
	<form action="add" method="post">
		<table border="1">
			<tr>
				<td>더하고 싶은 두 값을 입력하세요</td>
			</tr>
			<tr>
				<td>
					<label>x : </label>
					<input type="text" name="x" />  
				</td>
			</tr>
			<tr>
				<td>
					<label>y : </label>
					<input type="text" name="y" /> 
				</td>
			</tr>
			<tr>
				<td> 
					<input type="submit" name="cmd" value="덧셈" />
					<input type="submit" name="cmd" value="application" />
					<input type="submit" name="cmd" value="session" />
					<input type="submit" name="cmd" value="cookie" />
				</td>
			</tr>
			<tr>
				<td>
					<%-- <label>덧셈결과 : <% out.print(sum); %></label> --%>
					<%-- <label>덧셈결과 : <%= sum %></label> --%>
					<label>sum : ${sum}  psum : ${param.ss}</label>
					
					<input type="hidden" name="sum" value="${sum}"/>
				</td>
			</tr>
		</table>
	</form>
	
	<a href="mypage.jsp"> 마이페이지 </a>
	
</body>
</html>