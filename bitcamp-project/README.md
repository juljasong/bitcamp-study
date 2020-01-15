# 24_1 - `Iterator` 디자인 패턴의 활용

## 학습 목표

- `Iterator` 디자인 패턴의 용도를 이해하고 활용할 수 있다.
- 자료구조와 상관없이 일관된 방법으로 데이터를 조회할 수 있다.


## 실습 소스 및 결과

- src/main/java/com/eomcs/util/Iterator.java 추가
- src/main/java/com/eomcs/util/ListIterator.java 추가
- src/main/java/com/eomcs/util/AbstractList.java 변경
- src/main/java/com/eomcs/util/Stack.java 변경
- src/main/java/com/eomcs/util/Queue.java 변경
- src/main/java/com/eomcs/lms/App.java 변경

## 실습

### 훈련1. Stack 이나 Queue, List 에서 값을 꺼내는 방법을 통일하라.

- Iterator.java
    - 인터페이스로 값을 꺼내는 규칙을 정의한다.
    
### 훈련2. List에서 값을꺼내는 Iterator 구현체 정의
 
- ListIterator.java 생성
    -  List 객체에서 값을 꺼내는 일 수행
    - Iterator 사용법을 따른다
    
### 훈련3. 모든 List 구현체가 Iterator를 리턴하도록 규칙 추가
- List.java 변경
     - iterator() 메서드 추가

### 훈련4. 모든 List 구현체가 iterator 객체를 리턴하도록 하라 
- AbstractList.java 변경
     - List 인터페이스에 추가된 iterator() 규칙을 구현한다
     - ArrayList나 LinkedList는 이 클래스를 상속 받기 때문에 이 클래스에서 iterator() 구현
- Stack.java
    - `Iterator` 인터페이스의 구현체를 리턴하는 iterator() 를 정의한다.
    
### 훈련5. List에서 목록을 꺼내는 경우 Iterator 활용
- BoardHandler.java
  - list() 변경
- MemberHandler.java
  - list() 변경
- LessonHandler.java
  - list() 변경

### 훈련6. Stack에서 객체 꺼내줄 iterator 구현체 리턴
- StackIterator.java 생성
  - Iterator 인터페이스 구현
- Stack.java 변경
  - Iterator 구현체 리턴하는 iterator() 정의
  
### 훈련7. Queue에서 객체 꺼내줄 iterator 구현체 리턴
- QueueIterator.java 생성
  - Iterator 인터페이스 구현
- Queue.java 변경
  - Iterator 구현체 리턴하는 iterator() 정의  
  
### 훈련8. Stack과 Queue에서 값 꺼낼 때 Iterator 사용하도록 변경
- App.java
    - `history`, `history2` 명령을 처리할 때 Stack, Queue 객체에서 직접 값을 꺼내지 않고 Iterator 구현체를 통해서 꺼낸다.
