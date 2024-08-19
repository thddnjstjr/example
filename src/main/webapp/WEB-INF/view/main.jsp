<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ include file="/WEB-INF/view/layout/header.jsp" %>
<link rel="stylesheet" href="/css/user.css">
<div class = "post-list-container">
	<table class="post-table">
		<th>
			<td>제목</td>
			<td>내용</td>
			<td>작성자</td>
			<td>작성일</td>
		</th>
		<c:if test="${postList != null}">
		<c:forEach var="post" items="${postList}">
		<tr>
			<td></td>
			<td><a href="/board/detail?id=${post.id}">${post.title}</a></td>
			<td><a href="/board/detail?id=${post.id}">${post.content}</a></td>
			<td>${post.authorId}</td>
			<td>${post.createdAt}</td>
			<c:if test="${post.authorId eq principal.userName}">
			<td><button class="write-post-button" onclick="location.href='/main/update?id=${post.id}'">수정</button></td>
			<td><button class="write-post-button" onclick="location.href='/main/delete?id=${post.id}'">삭제</button></td>
			</c:if>
		</tr>
		</c:forEach>
		</c:if>
	</table>
 </div>
 <div class="write-post-button-container">
    <button class="write-post-button" onclick="location.href='/main/write'">글쓰기</button>
<ul class="page-list">
<c:forEach var="i" begin="1" end="${size}">
	<li style="margin-right: 5px"><a href="/main/select?number=${i}">${i}</a></li>
</c:forEach>
</ul>
</div>
 <%@ include file="/WEB-INF/view/layout/footer.jsp" %>