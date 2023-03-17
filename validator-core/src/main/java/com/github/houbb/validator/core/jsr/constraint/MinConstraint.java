package com.github.houbb.validator.core.jsr.constraint;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.util.lang.NumUtil;
import com.github.houbb.validator.core.api.constraint.AbstractGreatThanConstraint;

/**
 * 元素 min 约束
 * （1）value 必须大于等于 min
 * @author binbin.hou
 * @since 0.0.3
 * @see Integer
 * @see Short
 * @see Byte
 * @see javax.validation.constraints.Min
 */
@ThreadSafe
public class MinConstraint extends AbstractGreatThanConstraint<Long> {

    public MinConstraint(boolean inclusive, Long expect) {
        super(inclusive, expect);
    }

    public MinConstraint(Long expect) {
        super(expect);
    }

    @Override
    protected Long formatValue(Object contextValue) {
        return NumUtil.parseLong(contextValue);
    }

}
