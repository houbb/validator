package com.github.houbb.validator.core.jsr.constraint;

import com.github.houbb.heaven.annotation.CommonEager;
import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.util.lang.NumUtil;
import com.github.houbb.validator.core.api.constraint.AbstractLessThanConstraint;

import java.math.BigDecimal;

/**
 *
 * The annotated element must be a strictly negative number (i.e. 0 is considered as an invalid value
 *
 * 也就是必须小于 0
 *
 * @author binbin.hou
 * @since 0.5.0
 */
@ThreadSafe
public class NegativeConstraint extends AbstractLessThanConstraint<BigDecimal> {

    /**
     * 不包含临界值 0
     */
    public NegativeConstraint() {
        super(false, BigDecimal.ZERO);
    }

    @Override
    protected BigDecimal formatValue(Object contextValue) {
        return NumUtil.toBigDecimal(contextValue);
    }

}
