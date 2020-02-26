package com.eomcs.lms.domain;

import java.io.Serializable;
import java.sql.Date;

public class PhotoBoard implements Serializable {

  private static final long serialVersionUID = 7726598698007351227L;

  int no, viewCount;
  String title;
  Date createdDate;

  Lesson lesson;

  public Lesson getLesson() {
    return lesson;
  }

  public void setLesson(Lesson lesson) {
    this.lesson = lesson;
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public int getViewCount() {
    return viewCount;
  }

  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  @Override
  public String toString() {
    return "PhotoBoard [no=" + no + ", viewCount=" + viewCount + ", title=" + title
        + ", createdDate=" + createdDate + ", lesson=" + lesson + "]";
  }



}
