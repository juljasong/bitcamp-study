package com.eomcs.lms.dao.mariadb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MemberDaoImpl implements MemberDao {

  Connection con;

  public MemberDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public int insert(Member member) throws Exception {

    try (Statement stmt = con.createStatement()) {

      int result = stmt.executeUpdate("insert into lms_member(name, email, pwd, tel, photo) "
          + "values('" + member.getName() + "', '" + member.getEmail() + "', '"
          + member.getPassword() + "', '" + member.getTel() + "', '" + member.getPhoto() + "')");


      return result;
    }
  }

  @Override
  public List<Member> findAll() throws Exception {

    try (Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM lms_member")) {

      ArrayList<Member> list = new ArrayList<>();

      while (rs.next()) {
        Member member = new Member();
        member.setNo(rs.getInt("member_id"));
        member.setName(rs.getString("name"));
        member.setEmail(rs.getString("email"));
        member.setTel(rs.getString("tel"));
        member.setRegisteredDate(rs.getDate("cdt"));
        list.add(member);
      }
      return list;
    }
  }

  @Override
  public Member findByNo(int no) throws Exception {

    try (Statement stmt = con.createStatement();
        ResultSet rs =
            stmt.executeQuery("SELECT * FROM lms_member WHERE member_id = " + no + ";")) {

      if (rs.next()) {
        Member member = new Member();
        member.setNo(rs.getInt("member_id"));
        member.setName(rs.getString("name"));
        member.setEmail(rs.getString("email"));
        member.setPassword(rs.getString("pwd"));
        member.setPhoto(rs.getString("photo"));
        member.setTel(rs.getString("tel"));
        member.setRegisteredDate(rs.getDate("cdt"));
        return member;
      } else {
        return null;
      }
    }
  }

  @Override
  public int update(Member member) throws Exception {

    try (Statement stmt = con.createStatement()) {

      int result =
          stmt.executeUpdate("UPDATE lms_member SET name='" + member.getName() + "', email='"
              + member.getEmail() + "', pwd='" + member.getPassword() + "', tel='" + member.getTel()
              + "', photo = '" + member.getPhoto() + "' WHERE member_id=" + member.getNo() + ";");

      return result;
    }
  }


  @Override
  public int delete(int no) throws Exception {

    try (Statement stmt = con.createStatement()) {

      int result = stmt.executeUpdate("DELETE FROM lms_member WHERE member_id=" + no + ";");

      return result;
    }
  }

  @Override
  public List<Member> findByKeyword(String keyword) throws Exception {

    try (Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM lms_member WHERE name LIKE '%" + keyword
            + "%' OR email LIKE'%" + keyword + "%' OR tel LIKE '%" + keyword + "%'")) {

      ArrayList<Member> list = new ArrayList<>();

      while (rs.next()) {
        Member member = new Member();
        member.setNo(rs.getInt("member_id"));
        member.setName(rs.getString("name"));
        member.setEmail(rs.getString("email"));
        member.setTel(rs.getString("tel"));
        member.setRegisteredDate(rs.getDate("cdt"));
        list.add(member);
      }
      return list;
    }
  }

}
