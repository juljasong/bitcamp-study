package com.eomcs.lms;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

// Mybatis DAO 프록시를 자동 생성 할 인터페이스 지정
@MapperScan("com.eomcs.lms.dao")
public class MybatisConfig {

  public MybatisConfig() {
    System.out.println("MybatisConfig 객체 생성!");
  }

  // Spring IoC 컨테이너에 수동으로 등록할 객체는 메서드를 만들어 리턴
  // => 메서드 선언부에 @Bean 붙여야 함
  @Bean
  public SqlSessionFactory sqlSessionFactory(DataSource dataSource, ApplicationContext appCtx)
      throws Exception {
    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setDataSource(dataSource);
    sqlSessionFactoryBean.setTypeAliasesPackage("com.eomcs.lms.domain");
    sqlSessionFactoryBean
        .setMapperLocations(appCtx.getResources("classpath:com/eomcs/lms/mapper/*Mapper.xml"));

    return sqlSessionFactoryBean.getObject();
  }

}
