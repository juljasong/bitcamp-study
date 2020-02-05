package com.eomcs.lms.domain;

import java.io.Serializable;
import java.sql.Date;

// 객체를 seralize하려면 Serializable 인터페이스 구현.
// 버전 번호 명시
public class Lesson implements Serializable {

  private static final long serialVersionUID = -6190032284358359969L;
  private int no, totalHours, dayHours, count;
  private String title, description;
  private Date startDate, endDate;

  public static Lesson valueOf(String csv) {
    String[] data = csv.split(", "); // 한 줄을 ,로 나눔
    Lesson lesson = new Lesson();
    lesson.setNo(Integer.parseInt(data[0]));
    lesson.setTitle(data[1]);
    lesson.setDescription(data[2]);
    lesson.setStartDate(Date.valueOf(data[3]));
    lesson.setEndDate(Date.valueOf(data[4]));
    lesson.setTotalHours(Integer.parseInt(data[5]));
    lesson.setDayHours(Integer.parseInt(data[6]));
    return lesson;
  }

  public String toCsvString() {
    return String.format("%d, %s, %s, %s, %s, %d, %d\n", this.getNo(), this.getTitle(),
        this.getDescription(), this.getStartDate(), this.getEndDate(), this.getTotalHours(),
        this.getDayHours());
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + dayHours;
    result = prime * result + ((description == null) ? 0 : description.hashCode());
    result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
    result = prime * result + no;
    result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
    result = prime * result + ((title == null) ? 0 : title.hashCode());
    result = prime * result + totalHours;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj.getClass() != Lesson.class)
      return false;
    Lesson other = (Lesson) obj;
    if (this.no != other.no)
      return false;
    if (!this.title.equals(other.title))
      return false;
    if (!this.description.equals(other.description))
      return false;
    if (this.startDate.compareTo(other.startDate) != 0)
      return false;
    if (this.endDate.compareTo(other.endDate) != 0)
      return false;
    if (this.totalHours != other.totalHours)
      return false;
    if (this.dayHours != other.dayHours)
      return false;
    return true;
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public int getTotalHours() {
    return totalHours;
  }

  public void setTotalHours(int totalHours) {
    this.totalHours = totalHours;
  }

  public int getDayHours() {
    return dayHours;
  }

  public void setDayHours(int dayHours) {
    this.dayHours = dayHours;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }


}
