package com.github.houbb.validator.core.api.condition.annotation;

import com.github.houbb.validator.api.api.condition.ICondition;
import com.github.houbb.validator.core.annotation.condition.NotEqualsCondition;
import com.github.houbb.validator.core.api.condition.Conditions;

/**
 * 抽象注解条件接口
 * @author binbin.hou
 * @since 0.2.0
 */
public class AtNotEqualsCondition extends AbstractAnnotationCondition<NotEqualsCondition> {

    @Override
    protected ICondition buildCondition(NotEqualsCondition annotation) {
        return Conditions.notEquals(annotation.value(), annotation.fieldName());
    }

}
