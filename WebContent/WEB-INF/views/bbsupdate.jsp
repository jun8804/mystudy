<%@page import="kh.com.c.model.MemberDto"%>
<%@page import="kh.com.c.model.BbsDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>bbsupdate</title>
<style type="text/css">
.center{
	margin: auto;
	width: 60%;
	border: 3px solid #8AC007;
	padding: 10px;
}
input {
	size: 50;
}
</style>
</head>
<body>

<a href="logout.do">로그아웃</a>

<h1>글 수정</h1>

<%
BbsDto bbs = (BbsDto)request.getAttribute("bbs");
%>

<%
Object ologin = session.getAttribute("login");
MemberDto mem = null;
mem = (MemberDto)ologin;
%>

<div class="center">

<form action="bbsupdateAf.do" method="post">
<input type="hidden" name="seq" value="<%=bbs.getSeq() %>">
			
<table border="1">
<col width="200"><col width="500"> 

<tr>
	<td>아이디</td>
	<td>
		<input type="text" name="id" readonly="readonly" size="50" 
			value="<%=mem.getId() %>"> 		
	</td>	
</tr>
<tr>
	<td>제목</td>
	<td>
		<input type="text" name="title" size="50" value="<%=bbs.getTitle() %>">		
	</td>
</tr>
<tr>
	<td>내용</td>
	<td>
		<textarea rows="10" cols="50" name="content"><%=bbs.getContent() %></textarea>		
	</td>
</tr>
<tr>
	<td colspan="2">
		<input type="submit" value="글수정">
	</td>
</tr>

</table>

</form>

</div>

<a href="bbslist.do">글목록</a>

</body>
</html>