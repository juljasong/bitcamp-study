<%@page import="com.eomcs.lms.domain.Lesson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/header.jsp" />

<h1>수업 상세정보</h1>


<p>해당 번호의 강의가 없습니다.</p>

<form action='update' method='post'>
    번호: <input name='no' readonly type='text' value='${lesson.no}'><br>
    강의명: <input name='title' type='text' value='${lesson.title}'><br>
    내용:<br>
    <textarea name='description' rows='5' cols='60'>${lesson.description}</textarea><br>
    강의 시작일: <input name='startDate' type='date' value='${lesson.startDate}'><br>
    강의 종료일: <input name='endDate' type='date' value='${lesson.endDate}'><br>
    총 강의시간: <input name='totalHours' type='number' value='${lesson.totalHours}'><br>
    일 강의시간: <input name='dayHours' type='number' value='${lesson.dayHours}'><br>
    <p>
        <button>변경</button>
        <a href='delete?no=${lesson.no}'>삭제</a>
        <a href='../photoboard/list?lessonNo=${lesson.no}'>사진게시판</a>
    </p>
</form>

<jsp:include page="/footer.jsp" />