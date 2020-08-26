package com.icd.annotation;

import java.lang.annotation.*;

/**
 * @author 李耀华
 * @since 2020年7月8日
 * 自定义注解 拦截Controller中的方法
 */

@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemControllerLog {

	String description() default "";

}
