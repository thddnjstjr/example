<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp" %>
<link rel="stylesheet" href="/css/detail.css">

<div class="post-detail-container">
    <!-- 게시글 상세 내용 -->
    <div class="post-detail">
        <h1>${post.title}</h1>
        <p class="post-author">작성자: ${post.authorId}</p>
        <p class="post-date">작성일: ${post.createdAt}</p>
        <div class="post-content">
            <c:if test="${post.image != null}">
                <img src="${post.image}" alt="Post Image" class="post-image">
            </c:if>
            <p>${post.content}</p>
        </div>
    </div>

    <!-- 댓글 목록 -->
    <div class="comments-section">
        <h2>댓글</h2>
        <c:if test="${commentList != null && !commentList.isEmpty()}">
            <c:forEach var="comment" items="${commentList}">
                <div class="comment">
                    <p class="comment-author">작성자: ${comment.authorId}</p>
                    <p class="comment-date">작성일: ${comment.createdAt}</p>
                    <p>${comment.content}</p>
                </div>
            </c:forEach>
        </c:if>
        <c:if test="${commentList == null || commentList.isEmpty()}">
            <p>아직 댓글이 없습니다. 첫 댓글을 작성해보세요!</p>
        </c:if>

        <!-- 댓글 작성 폼 -->
        <div class="comment-form">
            <h3>댓글 작성</h3>
            <form action="/board/comment" method="post">
                <input type="hidden" name="postId" value="${post.id}">
                <input type="hidden" name="authorId" value="${principal.userName}">
                <textarea name="content" class="form-control" rows="3" placeholder="댓글을 입력하세요" required></textarea>
                <button type="submit" class="submit-button">댓글 작성</button>
            </form>
        </div>
    </div>
</div>
	

 <%@ include file="/WEB-INF/view/layout/footer.jsp" %>