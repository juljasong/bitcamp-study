<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

<jsp:include page="/header.jsp" />

<h1>로그인</h1>
<form action='login' method='post'>

<%
  if(request.getAttribute("email") != null) {
%>

    이메일: <input name='email' type='email' value='<%=request.getAttribute("email")%>'>
    
<%
  } else {
%>

    이메일: <input name='email' type='email'>
    
<%
  }
%>

    <input type='checkbox' name='saveEmail'>이메일 저장하기<br>
    암호: <input name='password' type='password'><br>
    <button>로그인</button>
</form>

<jsp:include page="/footer.jsp" />