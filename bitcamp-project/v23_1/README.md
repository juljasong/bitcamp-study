# 23_1 - 일반화(Generalization) 상속 기법 사용해 ArrayList와 LinkedList 공통점 분리

## 학습 목표

- 상속 기법 중 이랍ㄴ화 기법 수행 가능
- 추상 클래스와 추상메서드의 용도와 이점 이해
- 클래스의 공통점 유지보수하기 쉽게 분리하기 위해 상속 이용 가능


## 실습 소스 및 결과

- src/main/java/com/eomcs/util/List.java 추가
- src/main/java/com/eomcs/util/ArrayList.java 변경
- src/main/java/com/eomcs/util/LinkedList.java 변경
- src/main/java/com/eomcs/lms/handler/LessonHandler.java 변경
- src/main/java/com/eomcs/lms/handler/MemberHandler.java 변경
- src/main/java/com/eomcs/lms/handler/BoardHandler.java 변경
- src/main/java/com/eomcs/lms/App.java 변경

## 실습

### 훈련1. 데이터 목록 다루는 ArrayList와 LinkedList의 공통점을 별도의 클래스로 분리

- AbstractList.java
    - ArrayList와 LinkedList의 공통멤버(필드, 메서드) 선언
    - 서브 클래스에서 반드시 재정의 해야 하는 메서드는 추상 메서드로 구현하지 않고 유지
- ArrayList.java
    - `AbstractList`를 상속받음
    - 상속 받은 추상 메서드 구현
- LinkedList.java
    - `AbstractList`를 상속받음
    - 상속 받은 추상 메서드 구현
- LessonHandler.java
    - ArrayList 또는 LinkedList를 직접 지정하는 대신에 추상클래스를 필드로 선언한다.
    - 생성자에서 구체적으로 구현한 서브 클래스를 공급받도록 변경
    - 특정 클래스(ArrayList나 LinkedList)에 의존하는 코드 제거
- MemberHandler.java
    - ArrayList 또는 LinkedList를 직접 지정하는 대신에 추상클래스를 필드로 선언한다.
    - 생성자에서 구체적으로 구현한 서브 클래스를 공급받도록 변경
    - 특정 클래스(ArrayList나 LinkedList)에 의존하는 코드 제거
- BoardHandler.java
    - ArrayList 또는 LinkedList를 직접 지정하는 대신에 추상클래스를 필드로 선언한다.
    - 생성자에서 구체적으로 구현한 서브 클래스를 공급받도록 변경
    - 특정 클래스(ArrayList나 LinkedList)에 의존하는 코드 제거
- App.java
    - XXXHandler가 사용한 의존 객체(AbstractList 객체) 준비
    - XXXHandler 생성할 떄 해당 의존 객체 넘겨줌