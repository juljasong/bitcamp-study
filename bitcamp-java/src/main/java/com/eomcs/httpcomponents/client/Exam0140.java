// Apache HttpComponent 사용 - GET 요청
package com.eomcs.httpcomponents.client;

import org.apache.hc.client5.http.fluent.Request;

public class Exam0140 {

  public static void main(String[] args) throws Exception {
    // 더 간결하게 HTTP 요청하기
    // => httpclient-fluent 추가
    Request.get("http://daum.net").execute().returnContent();

  }
}


