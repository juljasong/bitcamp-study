// HashMap과 Iterator
package com.eomcs.corelib.ex08;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Exam0321 {
  public static void main(String[] args) {
    Member v1 = new Member("홍길동", 20);
    Member v2 = new Member("임꺽정", 30);
    Member v3 = new Member("유관순", 16);
    Member v4 = new Member("안중근", 20);
    Member v5 = new Member("윤봉길", 25);

    HashMap map = new HashMap();
    map.put("s01", v1);
    map.put("s02", v2);
    map.put("s03", v3);
    map.put("s04", v4);
    map.put("s05", v5);

    Set keys = map.keySet();
    Iterator iterator = keys.iterator();
    // Iterator 객체 생성시, 현재 목록 객체를 바탕으로 생성
    // => Iterator 생성 후 목록의 값 변경하면, 기존의 Iterator는 무효
    map.remove("s01");
    map.remove("s02");
    map.remove("s03");

    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }

}


