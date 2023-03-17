/*
 * Copyright (c)  2019. houbinbin Inc.
 * valid All rights reserved.
 */

package com.github.houbb.validator.core.annotation.constraint;

import com.github.houbb.validator.api.annotation.constraint.Constraint;
import com.github.houbb.validator.core.api.constraint.annotation.AtHasNotNullConstraint;

import java.lang.annotation.*;

/**
 * <p> 至少一个不为空 </p>
 *
 * <pre> Created: 2019/1/7 9:49 PM  </pre>
 * <pre> Project: valid  </pre>
 *
 * @author houbinbin
 * @since 0.0.1
 */
@Inherited
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(AtHasNotNullConstraint.class)
public @interface HasNotNull {

    /**
     * 当前字段及其指定的字段 至少有一个不为 null
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
