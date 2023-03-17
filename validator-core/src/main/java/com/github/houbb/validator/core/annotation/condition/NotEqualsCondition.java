/*
 * Copyright (c)  2019. houbinbin Inc.
 * valid All rights reserved.
 */

package com.github.houbb.validator.core.annotation.condition;

import com.github.houbb.validator.api.annotation.condition.Condition;
import com.github.houbb.validator.core.api.condition.annotation.AtNotEqualsCondition;

import java.lang.annotation.*;

/**
 * <p> 字段值不等于什么的时候 </p>
 *
 * <pre> Created: 2019/1/7 9:49 PM  </pre>
 * <pre> Project: valid  </pre>
 *
 * @author houbinbin
 * @since 0.2.0
 */
@Inherited
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Condition(AtNotEqualsCondition.class)
public @interface NotEqualsCondition {

    /**
     * 字段值不等于什么的时候
     * @return 字符串
     */
    String value();

    /**
     * 字段名称
     * @return 字段名称
     */
    String fieldName() default "";

    /**
     * 包含的约束注解属性
     * @return 列表
     * @since 0.2.0
     */
    Class<? extends Annotation>[] includes() default {};

    /**
     * 包含的约束注解属性
     * @return 列表
     * @since 0.2.0
     */
    Class<? extends Annotation>[] excludes() default {};

}
