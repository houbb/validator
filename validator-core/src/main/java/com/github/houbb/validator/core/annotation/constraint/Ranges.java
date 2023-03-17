/*
 * Copyright (c)  2019. houbinbin Inc.
 * valid All rights reserved.
 */

package com.github.houbb.validator.core.annotation.constraint;

import com.github.houbb.validator.api.annotation.constraint.Constraint;
import com.github.houbb.validator.core.api.constraint.annotation.AtRangesConstraint;

import java.lang.annotation.*;

/**
 * <p> 范围判断 </p>
 *
 * <pre> Created: 2019/1/7 9:49 PM  </pre>
 * <pre> Project: valid  </pre>
 *
 * 如果字段为 null，那么认为通过。
 *
 * @author houbinbin
 * @since 0.2.0
 */
@Inherited
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(AtRangesConstraint.class)
public @interface Ranges {

    /**
     * 当前字段必须在指定的范围内
     * @return 指定的字段列表
     */
    String[] value() default {};

    /**
     * 提示消息
     * @return 错误提示
     */
    String message() default "";

    /**
     * 分组信息
     * @return 分组类
     * @since 0.1.2
     */
    Class[] group() default {};

}
