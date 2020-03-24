// 특정 메서드 호출 전후에 실행되는 클래스
package com.eomcs.spring.ioc.ex13.e;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {

  // 타겟 객체의 메서드를 호출하기 전에 그 메서드가 받을 파라미터를 먼저 받기
  /*
   * <aop:before pointcut="execution(* com.eomcs.spring.ioc.ex13.e.X.*(..)) and args(x,y)"
   * method="doBefore"/>
   */
  @Before("execution(* com.eomcs.spring.ioc.ex13.e.X.*(..)) and args(x,y)")
  public void doBefore(int x, int y) {
    System.out.printf("MyAdvice.doBefore(): %d, %d\n", x, y);
  }

  // 타겟 객체의 메서드를 호출한 후 그 결과를 받기
  // => 설정 파일에 정의된 이름을 사용하여 파라미터를 선언해야 한다.
  /*
   * <aop:after-returning pointcut="execution(* com.eomcs.spring.ioc.ex13.e.X.*(..))"
   * method="doAfterReturning" returning="returnValue"/>
   */
  @AfterReturning(pointcut = "execution(* com.eomcs.spring.ioc.ex13.e.X.*(..))",
      returning = "returnValue")
  public void doAfterReturning(Object returnValue) {
    System.out.printf("MyAdvice.doAfterReturning(): %d\n", returnValue);
  }

  // 타겟 객체의 메서드를 호출할 때 예외가 발생했다면 그 예외 객체를 받기
  // => 설정 파일에 정의된 이름을 사용하여 파라미터를 선언해야 한다.
  /*
   * <aop:after-throwing pointcut="execution(* com.eomcs.spring.ioc.ex13.e.X.*(..))"
   * method="doAfterThrowing" throwing="error"/>
   */
  @AfterThrowing(//
      pointcut = "execution(* com.eomcs.spring.ioc.ex13.e.X.*(..))", //
      throwing = "error")
  public void doAfterThrowing(Exception error) {
    System.out.printf("MyAdvice.doAfterThrowing(): %s\n", error.getMessage());
  }
}
