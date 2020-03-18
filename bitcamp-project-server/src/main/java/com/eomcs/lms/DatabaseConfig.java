package com.eomcs.lms;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

// Spring IoC 컨테이너가 이 클래스를 Java Config를 자동 인식하려면
@Configuration

// Spring IoC 컨테이너가 탐색할 패키지 설정
@PropertySource("classpath:com/eomcs/lms/conf/jdbc.properties")
public class DatabaseConfig {

  // @PropertySource로 로딩한 파일을 사용하기 위해서는, @Value
  @Value("${jdbc.driver}")
  String jdbcDriver;
  @Value("${jdbc.url}")
  String jdbcUrl;
  @Value("${jdbc.username}")
  String jdbcUsername;
  @Value("${jdbc.password}")
  String jdbcPassword;

  public DatabaseConfig() {
    System.out.println("DataBaseConfig 객체 생성!");
  }

  // Spring IoC 컨테이너에 수동으로 등록할 객체는 메서드를 만들어 리턴
  // => 메서드 선언부에 @Bean 붙여야 함

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource ds = new DriverManagerDataSource();
    ds.setDriverClassName(jdbcDriver);
    ds.setUrl(jdbcUrl);
    ds.setUsername(jdbcUsername);
    ds.setPassword(jdbcPassword);
    return ds;
  }

  @Bean
  public PlatformTransactionManager platformTransactionManager(DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }

}
