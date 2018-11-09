<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="utf-8"/>  

<div class="menu_table">
	<ul style="width: 100%">
		<li class="title">답변형게시판</li>
		<li class="subtitle">답변형게시판</li>
		<li class="menu_item">
			<a href="#none" onclick="url_bbslist()" title="글목록">글목록</a>			
		</li>
		<li class="menu_item">
			<a href="#none" onclick="url_bbswrite()" title="글쓰기">글쓰기</a>			
		</li>				
	</ul>
</div>

<script>
function url_bbslist() {
	location.href = "bbslist.do";
}
function url_bbswrite() {
	location.href = "bbswrite.do";
}

</script>






