package com.github.houbb.validator.core.api.condition;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.validator.api.api.condition.ICondition;
import com.github.houbb.validator.api.api.condition.IConditionContext;

/**
 * 永远为假条件
 * @author binbin.hou
 * @since 0.2.0
 */
@ThreadSafe
public class AlwaysFalseCondition implements ICondition {

    @Override
    public boolean condition(IConditionContext conditionContext) {
        return true;
    }

}
