<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp" %>
<link rel="stylesheet" href="/css/board.css">
<div class="post-write-container">
    <h2>게시글 작성</h2>
    <form action="/main/submitPost" method="post">
        <div class="form-group">
            <label for="title">제목</label>
            <input type="text" id="title" name="title" class="form-control" required placeholder="${post.title}">
        </div>
        <div class="form-group">
            <label for="content">내용</label>
            <textarea id="content" name="content" class="form-control" rows="10" required placeholder="${post.content}"></textarea>
        </div>
        <div class="form-group">
            <button type="submit" class="submit-button">게시글 수정</button>
        </div>
    </form>
</div>
 <%@ include file="/WEB-INF/view/layout/footer.jsp" %>