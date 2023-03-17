package com.github.houbb.validator.core.api.constraint;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.validator.api.api.constraint.IConstraintContext;
import com.github.houbb.validator.core.i18n.I18N;

/**
 * 抽象大于约束实现
 * @author binbin.hou
 * @since 0.0.3
 */
@ThreadSafe
public class AbstractGreatThanConstraint<T extends Comparable> extends AbstractConstraint {

    /**
     * 是否包含等于，默认为等于
     * @since 0.0.3
     */
    protected final boolean inclusive;

    /**
     * 预期的值
     * @since 0.0.3
     */
    protected final T expect;

    /**
     * 抽象构造器
     * @param inclusive 是否包含
     * @param expect 预期值
     * @since 0.0.3
     */
    public AbstractGreatThanConstraint(boolean inclusive, T expect) {
        this.inclusive = inclusive;
        this.expect = expect;
    }

    /**
     * 抽象构造器
     * @param expect 预期值
     * @since 0.0.3
     */
    public AbstractGreatThanConstraint(T expect) {
        this(true, expect);
    }

    protected T formatValue(final Object contextValue) {
            return (T) contextValue;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected boolean pass(final IConstraintContext context, final Object value) {
        final T comparableValue = formatValue(value);
        if(inclusive) {
            return comparableValue.compareTo(expect) >= 0;
        }
        return comparableValue.compareTo(expect) > 0;
    }

    @Override
    protected String expectValue(IConstraintContext context) {
        final String value = expect.toString();
        if(inclusive) {
            return I18N.get(I18N.Key.GREAT_THAN_OR_EQUALS) + value;
        }
        return I18N.get(I18N.Key.GREAT_THAN) + value;
    }

}
