package org.bd.java_exercise.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.CLASS)
public @interface Getter {
}
