<%@page import="com.eomcs.lms.domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset='UTF-8'>
<title>Bitcamp-LMS</title>
<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css' integrity='sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh' crossorigin='anonymous'>

<style>
body {
  background-color: LightGray;
}
div.container {
  background: white;
  border: 1px solid gray;
  width: 600px;
}
</style>

</head>

<body>
<nav class='navbar navbar-expand-lg navbar-dark bg-dark'>
<a class='navbar-brand' href='/board/list'>Lesson Management System</a>
<button class='navbar-toggler' type='button' data-toggle='collapse' data-target='#navbarNav' aria-controls='navbarNav' aria-expanded='false' aria-label='Toggle navigation'>
  <span class='navbar-toggler-icon'></span>
</button>
<div class='collapse navbar-collapse' id='navbarNav'>
  <ul class='navbar-nav mr-auto'>
    <li class='nav-item'>
      <a class='nav-link' href='board/list'>게시글</span></a>
    </li>
    <li class='nav-item'>
      <a class='nav-link' href='lesson/list'>수업</a>
    </li>
    <li class='nav-item'>
      <a class='nav-link' href='member/list'>회원</a>
    </li>
  </ul>
<%
  Member loginUser = (Member) request.getSession().getAttribute("loginUser");
  if (loginUser != null) {
%>
  <span class='navbar-text'><%=loginUser.getName()%></span>
  <a href='auth/logout' class='btn btn-success btn-sm'>로그아웃</a>
<%
  } else {
%>
  <a href='auth/login' class='btn btn-success btn-sm'>로그인</a>
<%
  }
%>
  </div>
</nav>
<div class='container'>

<h1>환영합니다!</h1>

</div>
<script src='https://code.jquery.com/jquery-3.4.1.slim.min.js' integrity='sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n' crossorigin='anonymous'></script>
<script src='https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js' integrity='sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo' crossorigin='anonymous'></script>
<script src='https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js' integrity='sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6' crossorigin='anonymous'></script>
</body>
</html>

