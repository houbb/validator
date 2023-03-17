/*
 * Copyright (c)  2019. houbinbin Inc.
 * valid All rights reserved.
 */

package com.github.houbb.validator.core.annotation.constraint;

import com.github.houbb.validator.api.annotation.constraint.Constraint;
import com.github.houbb.validator.core.api.constraint.annotation.AtEnumRangesConstraint;

import java.lang.annotation.*;

/**
 * <p> 枚举值范围判断 </p>
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
@Constraint(AtEnumRangesConstraint.class)
public @interface EnumRanges {

    /**
     * 当前字段必须在枚举值指定的范围内
     * @return 指定的字段列表
     */
    Class<? extends Enum> value();

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
