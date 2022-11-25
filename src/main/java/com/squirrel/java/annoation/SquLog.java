package com.squirrel.java.annoation;


import java.lang.annotation.*;

/**
 * @author moka
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface SquLog {
}
