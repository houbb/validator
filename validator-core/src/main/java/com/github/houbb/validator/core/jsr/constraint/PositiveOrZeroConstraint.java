package com.github.houbb.validator.core.jsr.constraint;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.util.lang.NumUtil;
import com.github.houbb.validator.core.api.constraint.AbstractGreatThanConstraint;

import java.math.BigDecimal;

/**
 *
 * The annotated element must be a positive number or 0.
 *
 * @author binbin.hou
 * @since 0.5.0
 */
@ThreadSafe
public class PositiveOrZeroConstraint extends AbstractGreatThanConstraint<BigDecimal> {

    /**
     * 包含临界值 0
     */
    public PositiveOrZeroConstraint() {
        super(true, BigDecimal.ZERO);
    }

    @Override
    protected BigDecimal formatValue(Object contextValue) {
        return NumUtil.toBigDecimal(contextValue);
    }

}
