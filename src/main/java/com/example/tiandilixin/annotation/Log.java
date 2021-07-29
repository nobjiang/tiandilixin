package com.example.tiandilixin.annotation;

import java.lang.annotation.*;

/**
 * @program: tranquil
 * @description: log
 * @author: zhaoliang
 * @create: 2021-07-23 15:34
 **/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

    int value() default 0;
}
