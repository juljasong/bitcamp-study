# ArrayList 클래스 정의 과정

1) 최소 클래스 정의
2) 목록을 다룰 때 사용할 인스턴스 변수 준비
3) 생성자에서 인스턴스 변수 초기화
4) 배열의 초기 크기를 설정할 수 있는 생성자 추가
5) 생성자에 있는 수퍼 클래스 기본 생성자 호출 문장 생략
6) 배열의 기본 크기 상수로 정의
7) 생성자에서 배열을 만들 때, 초기 크기가 기본 크기 보다 작다면 기본 크기로 만듬
8) 객체를 목록에 저장하는 add() 메서드 정의
9) 객체를 검색하여 꺼내는 get() 메서드 정의
10) 목록의 저장된 특정 위치의 값을 변경하는 set() 메서드 정의
11) 목록에 저장된 특정 위치의 값을 삭제하는 remove() 메서드 정의
12) add() 변경 : 배열이 꽉차면 50% 증가
13) get() 변경 : 유효한 인덱스가 아니면 null 리턴
14) set() 변경 : 유효한 인덱스가 아니면 메서드 실행 X
15) set() 변경 : 변경한 후 변경 전 값 리턴
16) remove() 변경 : 유효한 인덱스가 아니면 메서드 실행 X
17) remove() 변경 : 변경한 후 변경 전 값 리턴
18) size 필드값을 리턴할 size() 메서드 정의
19) remove() 변경 : System.arraycopy() 사용하여 삭제 처리
20) 목록에 저장된 객체를 배열로 리턴
21) toArray() 변경 : Arrays.copyOf() 사용하여 리턴할 배열 만듬
22) ArrayList에 제네릭(generic) 적용
23) 제네릭으로 지정된 타입의 배열을 리턴하는 toArray() 생성
24) toArray(E[] arr) 변경 : 파라미터로 받은 배열이 넉넉하다면 새로 배열을 만들지 않고 그대로 사용.
25) 목록 중간에 값을 삽입하는 add(int,E) 메서드를 정의한다.
26) add()와 add(int,E)에 중복 작성된 배열을 늘리는 코드를 grow() 메서드로 분리한다.  
27) grow() 메서드에서 새 배열의 크기를 계산 코드를 newCapacity() 메서드로 분리한다. 