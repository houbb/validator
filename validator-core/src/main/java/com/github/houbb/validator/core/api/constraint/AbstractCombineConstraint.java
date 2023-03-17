package com.github.houbb.validator.core.api.constraint;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.validator.api.api.constraint.IConstraintContext;

import java.math.BigDecimal;

/**
 * 抽象组合约束实现
 * 适用场景：一个注解对应多个约束实现类。
 * @author binbin.hou
 * @since 0.3.0
 */
@ThreadSafe
public abstract class AbstractCombineConstraint extends AbstractConstraint {

    /**
     * 获取对应的约束实现
     * @param context 上下文
     * @return 约束实现
     * @since 0.3.0
     */
    protected abstract AbstractConstraint getConstraintInstance(final IConstraintContext context);

    /**
     * 对值进行处理
     * @param value  值
     * @return 格式化后的结果
     * @since 0.3.0
     */
    protected Object formatValue(final Object value) {
        // 字符串相关进行处理
        if(value instanceof CharSequence) {
            CharSequence charSequence = (CharSequence)value;
            return new BigDecimal(charSequence.toString());
        }

        return value;
    }

    @Override
    @SuppressWarnings("unchecked")
    protected boolean pass(IConstraintContext context, Object value) {
        AbstractConstraint abstractConstraint = getConstraintInstance(context);
        final Object formatValue = this.formatValue(value);
        return abstractConstraint.pass(context, formatValue);
    }

    @Override
    protected String expectValue(IConstraintContext context) {
        AbstractConstraint abstractConstraint = getConstraintInstance(context);
        return abstractConstraint.expectValue(context);
    }

}
