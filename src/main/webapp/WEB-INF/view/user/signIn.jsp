<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp" %>
<link rel="stylesheet" href="/css/user.css">
 <div class="container">
            <form action="/login" method="post">
                <div class="form-group">
                    <label for="username">아이디</label>
                    <input type="text" class="form-control" id="username" name="username" placeholder="Enter username">
                </div>
                <div class="form-group">
                    <label for="password">비밀번호</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="Enter password">
                </div>
                <button type="submit" class="btn btn-primary">로그인</button>
            	<a href="https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=8bb6c018765bb2c344effb3d2a16636a&redirect_uri=http://localhost:8080/user/kakao">
            	<img class="kakao-login" src="/image/kakao_login_small.png"></a>
            </form>
        </div>
<%@ include file="/WEB-INF/view/layout/footer.jsp" %>