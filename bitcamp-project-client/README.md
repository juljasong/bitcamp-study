# 32_3 - 게시물 관리에서 UI 기능 분리하여 클라이언트에 적용하기

## 학습목표

- 클라이언트와 서버 간 객체 주고 받기

## 실습 소스 및 결과

- src/main/java/com/eomcs/lms/ClientApp.java 변경
- src/main/java/com/eomcs/lms/domain/Board.java추가

## 실습  

### 훈련 1: 31번 프로젝트에서 Board 클래스 가져오기

- com.eomcs.lms.domain 패키지 생성 후 Board.java 가져오기

### 훈련 2: 31번 프로젝트에서 게시물 관리 처리하는 Command 객체 가져오기
- com.eomcs.lms.handler 패키지 생성
- Command.java, Board*Command.java 인터페이스 가져오기

### 훈련 3: 31번 프로젝트에서 util 패키지 가져오기
- com.eomcs.util 패키지 생성
- Prompt.java 가져오기

### 훈련 4: BoardListCommand에서 데이터 가져올 때 서버에서 가져오도록 변경
- ClientApp.java 변경

