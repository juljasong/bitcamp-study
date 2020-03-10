package com.eomcs.lms.dao.mariadb;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.domain.PhotoBoard;

public class PhotoBoardDaoImpl implements PhotoBoardDao {

  SqlSessionFactory sqlSessionFactory;

  public PhotoBoardDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public int insert(PhotoBoard photoBoard) throws Exception {

    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      int count = sqlSession.insert("PhotoBoardMapper.insertPhotoBoard", photoBoard);
      sqlSession.commit();

      return count;
    }
  }

  @Override
  public List<PhotoBoard> findAllByLessonNo(int lesson_id) throws Exception {

    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("PhotoBoardMapper.selectPhotoBoard", lesson_id);
    }
  }

  @Override
  public PhotoBoard findByNo(int no) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectOne("PhotoBoardMapper.selectByNo", no);
    }
  }

  @Override
  public int update(PhotoBoard photoBoard) throws Exception {

    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      int count = sqlSession.update("PhotoBoardMapper.updatePhotoBoard");
      sqlSession.commit();
      return count;
    }
  }

  @Override
  public int delete(int no) throws Exception {

    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      int count = sqlSession.delete("PhotoBoardMapper.deletePhotoBoard");
      sqlSession.commit();
      return count;
    }
  }

}
