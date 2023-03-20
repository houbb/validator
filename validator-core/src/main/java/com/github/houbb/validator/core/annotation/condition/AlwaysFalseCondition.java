/*
 * Copyright (c)  2019. houbinbin Inc.
 * valid All rights reserved.
 */

package com.github.houbb.validator.core.annotation.condition;

import com.github.houbb.validator.api.annotation.condition.Condition;
import com.github.houbb.validator.core.api.condition.annotation.AtAlwaysTrueCondition;

import java.lang.annotation.*;

/**
 * <p> 永远不生效 </p>
 *
 * <pre> Created: 2019/1/7 9:49 PM  </pre>
 * <pre> Project: valid  </pre>
 *
 * @author houbinbin
 * @since 0.4.0
 */
@Inherited
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Condition(AtAlwaysTrueCondition.class)
public @interface AlwaysFalseCondition {

}
