package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.Member;

public interface MemberDao {

  public int insert(Member member) throws Exception;

  public List<Member> findAll() throws Exception;

  public Member findByNo(int no) throws Exception;

  public int update(Member member) throws Exception;

  public int delete(int no) throws Exception;

}


