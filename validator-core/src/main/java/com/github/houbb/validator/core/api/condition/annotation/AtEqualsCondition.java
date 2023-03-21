package com.github.houbb.validator.core.api.condition.annotation;

import com.github.houbb.validator.api.api.condition.ICondition;
import com.github.houbb.validator.core.annotation.condition.EqualsCondition;
import com.github.houbb.validator.core.api.condition.Conditions;

/**
 * 相等注解实现类
 * @author binbin.hou
 * @since 0.2.0
 */
public class AtEqualsCondition extends AbstractAnnotationCondition<EqualsCondition> {

    @Override
    protected ICondition buildCondition(EqualsCondition annotation) {
        return Conditions.equals(annotation.value(), annotation.fieldName());
    }

}
