<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp" %>
<link rel="stylesheet" href="/css/user.css">
	<div class="container">
        <form action="/action_page.php">
            <div class="form-group">
                <label for="username">아이디</label>
                <input type="text" class="form-control" placeholder="Enter username" id="username">
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" class="form-control" placeholder="Enter email" id="email">
            </div>
            <div class="form-group">
                <label for="password">비밀번호</label>
                <input type="password" class="form-control" placeholder="Enter password" id="password">
            </div>
            <button type="submit" class="btn btn-primary">회원가입하기</button>
        </form>
    </div>
<%@ include file="/WEB-INF/view/layout/footer.jsp" %>