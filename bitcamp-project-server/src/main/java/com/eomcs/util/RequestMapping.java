package com.eomcs.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // 실행 중에 메서드에 붙은 어노테이션 정보 추출
@Target({ElementType.METHOD})
public @interface RequestMapping {


}
