package com.github.houbb.validator.core.jsr.constraint;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.util.lang.NumUtil;
import com.github.houbb.validator.core.api.constraint.AbstractLessThanConstraint;

/**
 * 元素 max 约束
 * （1）value 必须小于等于 max
 * @author binbin.hou
 * @since 0.0.3
 */
@ThreadSafe
public class MaxConstraint extends AbstractLessThanConstraint<Long> {

    public MaxConstraint(boolean inclusive, Long expect) {
        super(inclusive, expect);
    }

    public MaxConstraint(Long expect) {
        super(expect);
    }

    @Override
    protected Long formatValue(Object contextValue) {
        return NumUtil.parseLong(contextValue);
    }
}
