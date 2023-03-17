package com.github.houbb.validator.api.annotation.constraint;


import com.github.houbb.validator.api.api.constraint.annotation.IAnnotationConstraint;

import java.lang.annotation.*;

/**
 * 用于指定注解约束的元注解
 * @author binbin.hou
 * @since 0.1.0
 */
@Inherited
@Documented
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Constraint {

    /**
     * 约束条件实现类
     * @return 实现类 class
     */
    Class<? extends IAnnotationConstraint> value();

}
