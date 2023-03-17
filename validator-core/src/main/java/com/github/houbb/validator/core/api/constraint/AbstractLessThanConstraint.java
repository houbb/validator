package com.github.houbb.validator.core.api.constraint;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.validator.api.api.constraint.IConstraintContext;
import com.github.houbb.validator.core.i18n.I18N;

/**
 * 抽象小于等于约束实现
 * @author binbin.hou
 * @since 0.3.0
 */
@ThreadSafe
public class AbstractLessThanConstraint<T extends Comparable> extends AbstractConstraint {

    /**
     * 是否包含等于，默认为等于
     * @since 0.3.0
     */
    protected final boolean inclusive;

    /**
     * 预期的值
     * @since 0.3.0
     */
    protected final T expect;

    public AbstractLessThanConstraint(boolean inclusive, T expect) {
        this.inclusive = inclusive;
        this.expect = expect;
    }

    /**
     * 默认为包含等于的情况
     * @param expect 预期值
     * @since 0.3.0
     */
    public AbstractLessThanConstraint(T expect) {
        this(true, expect);
    }

    protected T formatValue(final Object contextValue) {
        return (T) contextValue;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected boolean pass(final IConstraintContext context, final Object value) {
        final T comparableValue = this.formatValue(value);
        if(inclusive) {
            return comparableValue.compareTo(expect) <= 0;
        }
        return comparableValue.compareTo(expect) < 0;
    }

    @Override
    protected String expectValue(IConstraintContext context) {
        final String value = expect.toString();

        if(inclusive) {
            return I18N.get(I18N.Key.LESS_THAN_OR_EQUALS) + value;
        }
        return I18N.get(I18N.Key.LESS_THAN) + value;
    }

}
