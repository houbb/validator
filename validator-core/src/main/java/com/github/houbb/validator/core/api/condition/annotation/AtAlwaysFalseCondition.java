package com.github.houbb.validator.core.api.condition.annotation;

import com.github.houbb.validator.api.api.condition.ICondition;
import com.github.houbb.validator.core.annotation.condition.AlwaysFalseCondition;
import com.github.houbb.validator.core.api.condition.Conditions;

/**
 * 永远不生效
 * @author binbin.hou
 * @since 0.4.0
 */
public class AtAlwaysFalseCondition extends AbstractAnnotationCondition<AlwaysFalseCondition> {

    @Override
    protected ICondition buildCondition(AlwaysFalseCondition annotation) {
        return Conditions.alwaysFalseCondition();
    }

}
