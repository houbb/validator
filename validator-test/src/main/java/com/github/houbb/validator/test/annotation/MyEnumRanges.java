package com.github.houbb.validator.test.annotation;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MyEnumRangesValidator.class)
public @interface MyEnumRanges {

    Class<? extends Enum> value();

    String message() default "";

}
