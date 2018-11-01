<%@page import="kh.com.c.model.BbsDto"%>
<%@page import="kh.com.c.model.MemberDto"%>
<%@page import="kh.com.c.model.BbsDto"%>
<%@page import="kh.com.c.model.MemberDto"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>bbslist.jsp</title>
 
<style type="text/css">
table{
	border-collapse: collapse; 
}
table, th, hd{
	border: 1px solid black;
}
th{
	background-color: green;
	color: white;
}
.tda{
	background-color: #abcdef;
	color: black;
}
.tdb{
	background-color: #fedcba;
	color: black; 
}

</style>

</head>
<body>

<%
Object ologin = session.getAttribute("login");
MemberDto mem = null;

if(ologin == null){
	%>
	<script type="text/javascript">
	alert("로그인 해 주십시오");
	location.href = "index.jsp";
	</script>
	<%
	return;
}
mem = (MemberDto)ologin;
%>
 
<%!
public String arrow(int depth){
	String rs = "<img src='./image/arrow.png' width='20px' height='20px'/>";
	String nbsp = "&nbsp;&nbsp;&nbsp;&nbsp;";
	String ts = "";
	
	for(int i = 0;i < depth; i++){
		ts += nbsp; 
	}
	return depth == 0 ? "":ts+rs;
}

%>


<%-- <h3>환영합니다 <%=mem.getName() %>님 반갑습니다</h3> --%>
<h3>환영합니다 ${login.name }님 반갑습니다</h3>

<a href="logout.do">로그아웃</a>
<hr>

<%
List<BbsDto> bbslist = (List<BbsDto>)request.getAttribute("bbslist");
%>

<table border="1">
<col width="70"><col width="500"><col width="150">

<tr>
<th>순서</th><th>제목</th><th>작성자</th>	
</tr>

<%
if(bbslist == null || bbslist.size() == 0){
	%>
	<tr>
		<td colspan="3">작성된 글이 없습니다</td>
	</tr>
	<%
}
for(int i = 0;i < bbslist.size(); i++){
	BbsDto bbs = bbslist.get(i);
	%>
	<tr <%=i%2==0?"class='tda'":"class='tdb'"%>>
	<td><%=i+1 %></td>
	<td class="title">
		<%=arrow(bbs.getDepth()) %>
		<%if(bbs.getDel() == 0){ %>
			<a href="bbsdetail.do?seq=<%=bbs.getSeq() %>">
				<%=bbs.getTitle() %>
			</a>
		<%}else{ %>
			이 글은 관리자에 의해서 삭제 되었습니다
		<%} %>
	</td>
	<td><%=bbs.getId() %> </td>
	</tr>	
	<%
}
%>
</table>


<a href="bbswrite.do">글쓰기</a>

</body>
</html>














