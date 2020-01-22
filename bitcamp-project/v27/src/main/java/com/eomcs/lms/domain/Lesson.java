package com.eomcs.lms.domain;

import java.sql.Date;

public class Lesson {
  
  private int num, totalHours, dayHours, count;
  private String title, description;
  private Date startDate, endDate;
  
  @Override
  public boolean equals(Object obj) {
    if(obj.getClass() != Lesson.class)
      return false;
    Lesson other = (Lesson) obj;
    if(this.num != other.num)
      return false;
    if(!this.title.equals(other.title))
      return false;
    if(!this.description.equals(other.description))
      return false;
    if(this.startDate.compareTo(other.startDate) != 0)
      return false;
    if(this.endDate.compareTo(other.endDate) != 0)
      return false;
    if(this.totalHours != other.totalHours)
      return false;
    if(this.dayHours != other.dayHours)
      return false;
    return true;
  }
  
  public int getNum() {
    return num;
  }
  public void setNum(int num) {
    this.num = num;
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
