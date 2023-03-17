package com.github.houbb.validator.core.jsr.constraint;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.util.common.ArgUtil;
import com.github.houbb.heaven.util.lang.NumUtil;
import com.github.houbb.validator.api.api.constraint.IConstraintContext;
import com.github.houbb.validator.core.api.constraint.AbstractCombineConstraint;
import com.github.houbb.validator.core.api.constraint.AbstractConstraint;
import com.github.houbb.validator.core.jsr.util.JsrSupportClassUtil;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * {@link javax.validation.constraints.DecimalMin} 约束注解实现
 * @author binbin.hou
 * @since 0.0.3
 * @see BigDecimal
 * @see BigInteger
 * @see Integer
 * @see Byte
 * @see Short
 * @see Long
 * @see CharSequence
 */
@ThreadSafe
public class DecimalMinConstraint extends AbstractCombineConstraint {

    /**
     * 是否包含
     */
    private final boolean inclusive;

    /**
     * 预期值
     * @since 0.0.3
     */
    private final Object expectValue;

    public DecimalMinConstraint(boolean inclusive, Object expectValue) {
        ArgUtil.notNull(expectValue, "expectValue");
        this.inclusive = inclusive;
        this.expectValue = expectValue;
    }

    public DecimalMinConstraint(Object expectValue) {
        this(true, expectValue);
    }

    @Override
    protected List<Class> getSupportClassList() {
        return JsrSupportClassUtil.getDecimalMaxMinSupportClassList();
    }

    /**
     * 获取对应的约束实现
     * @param context 上下文
     * @return 约束实现
     * @since 0.0.3
     */
    @Override
    protected AbstractConstraint getConstraintInstance(final IConstraintContext context) {
        final Object value = context.value();
        final Object exceptValue = super.formatValue(expectValue);

        if(value instanceof CharSequence) {
            return new BigDecimalMinConstraint(inclusive, (BigDecimal) exceptValue);
        }

        if(value instanceof BigDecimal) {
            return new BigDecimalMinConstraint(inclusive, (BigDecimal) exceptValue);
        }

        if(value instanceof  BigInteger) {
            return new BigIntegerMinConstraint(inclusive, (BigInteger) exceptValue);
        }

        // 其他，直接使用 Min long 进行处理
        Long longVal = NumUtil.parseLong(exceptValue);
        return new MinConstraint(inclusive, longVal);
    }

}
