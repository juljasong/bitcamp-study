# 23_3 - 일반화(Generalization)을 통해 추출한 수퍼 클래스를 추상 클래스로 정의

## 학습 목표

- 추상 클래스 정의
- 추상 클래스 문법의 용도 이해
- 추상 메서드 정의
- 추상 메서드 문법의 용도 이해


## 실습 소스 및 결과

- src/main/java/com/eomcs/util/AbstractList.java 변경(<-List.java)
- src/main/java/com/eomcs/util/List.java 추가
## 실습

### 훈련1. List.java에 추상 클래스와 추상 메서드 문법 적용

- List.java
    - AbstractList 추상 클래스에 있는 추상 메서드를 추출하여 따로 메서드 사용 규칙을 정의한다.
- AbstractList.java
    - 추상 메서드를 List 인터페이스로 옮긴다.
    - List 규칙을 따른다.
