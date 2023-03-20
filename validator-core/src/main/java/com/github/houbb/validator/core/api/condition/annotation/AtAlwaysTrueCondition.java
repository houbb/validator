package com.github.houbb.validator.core.api.condition.annotation;

import com.github.houbb.validator.api.api.condition.ICondition;
import com.github.houbb.validator.core.annotation.condition.AlwaysTrueCondition;
import com.github.houbb.validator.core.annotation.condition.EqualsCondition;
import com.github.houbb.validator.core.api.condition.Conditions;

/**
 * 永远生效
 * @author binbin.hou
 * @since 0.4.0
 */
public class AtAlwaysTrueCondition extends AbstractAnnotationCondition<AlwaysTrueCondition> {

    @Override
    protected ICondition buildCondition(AlwaysTrueCondition annotation) {
        return Conditions.alwaysTrueCondition();
    }

}
