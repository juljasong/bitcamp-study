package com.eomcs.mybatis.ex04;

public class AttachFile {
  int no, boardNo;
  String filePath;

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public int getBoardNo() {
    return boardNo;
  }

  public void setBoardNo(int boardNo) {
    this.boardNo = boardNo;
  }

  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  @Override
  public String toString() {
    return "AttachFile [no=" + no + ", boardNo=" + boardNo + ", filePath=" + filePath + "]";
  }

}
