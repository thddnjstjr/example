<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Green eta</title>
<link rel="stylesheet" href="/css/header.css">
</head>
<body>
<div class="main-content">
    <div class="headline">
        <a href="/main"><h3 class="title">그린 에타</h3></a>
    </div>
<div class="sidebar">
    <div class="status">
        <c:choose>
            <c:when test="${principal != null}">
                <img class="profile" src="${principal.setUpUserImage()}" alt="User Image">
                <span class="username">${principal.userName}</span>
                <div class="status-message">오늘도 좋은 하루!</div>
            </c:when>
            <c:otherwise>
                <a href="/user/sign-in" class="status-link">로그인</a>
                <a href="/user/sign-up" class="status-link">회원가입</a>
            </c:otherwise>
        </c:choose>
    </div>
</div>