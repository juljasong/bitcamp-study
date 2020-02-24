# 32_3 - LMS 관리 데이터를 파일에서 로딩하고, 파일로 저장하기

## 학습목표

- 데이터 파일을 읽고 쓸 수 있다.

## 실습 소스 및 결과

- src/main/java/com/eomcs/lms/domain 패키지 생성
- src/main/java/com/eomcs/lms/domain/Board.java 추가
- src/main/java/com/eomcs/lms/domain/Lesson.java 추가
- src/main/java/com/eomcs/lms/domain/Member.java 추가
- src/main/java/com/eomcs/lms/context 패키지 생성
- src/main/java/com/eomcs/lms/context/ApplicationContextListener.java 추가
- src/main/java/com/eomcs/lms/DataLoaderListener.java 추가
- src/main/java/com/eomcs/lms/ServerApp.java 변경

## 실습  

### 훈련 1: 31번 프로젝트에서 데이터를 저장하고 로딩하는 코드 가져오기

- com.eomcs.lms.domain 패키지 생성
- com.eomcs.lms.damain.* 가져오기
- com.eomcs.lms.context 패키지 생성
- com.eomcs.lms.context.ApplicationContextListener 클래스 가져오기
- com.eomcs.lms.DataLoaderListener 가져오기
- ServerApp.java 변경
  - 옵저버 등록, 호출 코드 적용

