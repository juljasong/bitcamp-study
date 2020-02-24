package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.Member;

public class MemberObjectFileDao extends AbstractObjectFileDao<Member> {

  public MemberObjectFileDao(String filename) {
    super(filename);
  }

  public int insert(Member member) throws Exception {

    if (indexOf(member.getNo()) > -1) {
      return 0;
    }
    list.add(member);
    saveData();
    return 1;
  }

  public List<Member> findAll() throws Exception {
    return list;
  }

  public Member findByNo(int no) throws Exception {
    int index = indexOf(no);
    if (index == -1) {
      return null;
    }
    return list.get(index);
  }

  public int update(Member member) throws Exception {
    int index = indexOf(member.getNo());

    if (index == -1) {
      return 0;
    }
    list.set(index, member);
    saveData();
    return 1;
  }

  public int delete(int no) throws Exception {
    int index = indexOf(no);
    if (index == -1) {
      return 0;
    }
    list.remove(index);
    saveData();
    return 1;
  }

  @Override
  protected <K> int indexOf(K key) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getNo() == (int) key) {
        return i; // 해당 숫자 리턴
      }
    }
    return -1; // 해당 숫자 없으면 -1
  }
}


