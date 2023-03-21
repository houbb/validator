package com.github.houbb.validator.core.jsr.constraint;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.util.lang.NumUtil;
import com.github.houbb.validator.core.api.constraint.AbstractLessThanConstraint;

import java.math.BigDecimal;

/**
 *
 * The annotated element must be a negative number or 0. (i.e. 0 is valid
 *
 * 也就是必须小于 0
 *
 * @author binbin.hou
 * @since 0.5.0
 */
@ThreadSafe
public class NegativeOrZeroConstraint extends AbstractLessThanConstraint<BigDecimal> {

    /**
     * 不包含临界值 0
     */
    public NegativeOrZeroConstraint() {
        super(true, BigDecimal.ZERO);
    }

    @Override
    protected BigDecimal formatValue(Object contextValue) {
        return NumUtil.toBigDecimal(contextValue);
    }

}
