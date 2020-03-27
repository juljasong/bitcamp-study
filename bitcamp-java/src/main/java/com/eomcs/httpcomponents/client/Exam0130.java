// Apache HttpComponent 사용 - GET 요청
package com.eomcs.httpcomponents.client;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;

public class Exam0130 {

  public static void main(String[] args) throws Exception {

    try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
      HttpGet httpGet = new HttpGet("https://www.daum.net");
      CloseableHttpResponse response = httpclient.execute(httpGet);
      System.out.println();
    }
  }

}


