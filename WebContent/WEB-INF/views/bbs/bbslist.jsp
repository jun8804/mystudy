<%@page import="kh.com.c.util.BbsArrow"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/> 

<%
String category = (String)request.getAttribute("s_category");
if(category == null) category = "";

//System.out.println("category:" + category);

String keyword = (String)request.getAttribute("s_keyword");
if(keyword == null) keyword = "";
%>

<script>
var str = "<%=category %>";
var kstr = "<%=keyword %>";
$(document).ready(function () {
	document.frmForm1.s_category.value = str;
	
	$("#_s_keyword").val(kstr);
});


</script>

    

<div class="box_border" style="margin-top: 5px; margin-bottom: 10px">

<form action="" name="frmForm1" id="_frmFormSearch" method="post">

<table style="margin-left: auto;margin-right: auto;
				margin-top: 3px;margin-bottom: 3px; border: 0; padding: 0;">

<tr>
	<td>검색:</td>
	<td style="padding-left: 5px;">
		<select id="_s_category" name="s_category">
			<option value="" selected="selected">선택</option>
			<option value="title">제목</option>
			<option value="contents">내용</option>
		</select>
	</td>
	<td style="padding-left: 5px;">
		<input type="text" id="_s_keyword" name="s_keyword" value="">
	</td>
	<td style="padding-left: 5px;">
		<span class="button blue">
			<button type="button" id="_btnSearch">검색</button>
		</span>
	</td>
</tr>
</table>

<!-- controller로 넘겨주기 위한 값 -->
<input type="hidden" name="pageNumber" id="_pageNumber" value="${(empty pageNumber)?0:pageNumber }">
<input type="hidden" name="recordCountPerPage" id="_recordCountPerPage"
	value="${(empty recordCountPerPage)?10:recordCountPerPage }">

</form>
</div>

<!-- 
xml
<bean id="cls" class="kh.com.c.MyClass">
 -->

<!-- jsp -->
<jsp:useBean id="ubbs" class="kh.com.c.util.BbsArrow"/>
<%-- BbsArrow ubbs = new BbsArrow(); --%>

<table class="list_table" style="width: 85%">
	<colgroup>
		<col style="width:70px;">
		<col style="width:auto;">
		<col style="width:100px;">
	</colgroup>
	
<thead>
	<tr>
		<th>순서</th><th>제목</th><th>작성자</th>
	</tr>
</thead>

<tbody>
	<c:if test="${empty bbslist }">
	<tr>
		<td colspan="3">작성된 글이 없습니다</td>
	</tr>	
	</c:if>
	
	<!-- for(BbsDto bbs : bbslist) -->
	<c:forEach items="${bbslist }" var="bbs" varStatus="vs">
	
	<jsp:setProperty property="depth" name="ubbs" value="${bbs.depth }"/>
	<!-- depth = ubbs.getDepth(); -->
	
	<tr class="_hover_tr">
		<td>${vs.count }</td>
		<td style="text-align: left;">
			<jsp:getProperty property="arrow" name="ubbs"/>
			<c:if test="${bbs.del eq 1 }">
				이 글은 게시자에 의해서 삭제 되었습니다 	
			</c:if>
			<c:if test="${bbs.del eq 0 }">
				<a href="bbsdetail.do?seq=${bbs.seq }">
					${bbs.title }
				</a>			
			</c:if>
		</td>
		<td>${bbs.id }</td>	
	</tr>		
	</c:forEach>
</tbody>

</table>

<!-- 페이징 처리 -->
<div id="paging_wrap">	
	<jsp:include page="/WEB-INF/views/common/paging.jsp" flush="false">
		<jsp:param value="${pageNumber }" name="pageNumber"/>		
		<jsp:param value="${pageCountPerScreen }" name="pageCountPerScreen"/>
		<jsp:param value="${recordCountPerPage }" name="recordCountPerPage"/>
		<jsp:param value="${totalRecordCount }" name="totalRecordCount"/>	
	</jsp:include>	
</div>

<div id="buttons_wrap">
	<span class="button blue">	
		<button type="button" id="_btnAdd">글쓰기</button>
	</span>
</div>

<script>
$(document).ready(function () {
	$("._hover_tr").mouseover(function () {
		$(this).children().css("background-color", "#F0F5FF");
	}).mouseout(function () {
		$(this).children().css("background-color", "#FFFFFF");
	});	
});

$("#_btnAdd").click(function () {
	// alert("write");
	location.href = "bbswrite.do";
});

/* 검색을 했을 때 */
$("#_btnSearch").click(function () {
	alert("_btnSearch");
	$("#_pageNumber").val(0);
	$("#_frmFormSearch").attr({"target":"_self", "action":"bbslist.do"}).submit();
});

/* 페이지번호를 클릭했을때 */
function goPage(pageNumber) {
	$("#_pageNumber").val(pageNumber);
	$("#_frmFormSearch").attr({"target":"_self", "action":"bbslist.do"}).submit();
}



</script>











