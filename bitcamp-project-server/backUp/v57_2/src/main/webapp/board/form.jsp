<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/header.jsp" />

<title>게시글 입력</title>
</head>

<body>
    <h1>게시물 입력</h1>
    <form action='add' method='post'>
        내용:<br>
        <textarea name='title' rows='5' cols='60'></textarea><br>
        <button>등록</button>
    </form>

<jsp:include page="/footer.jsp" />