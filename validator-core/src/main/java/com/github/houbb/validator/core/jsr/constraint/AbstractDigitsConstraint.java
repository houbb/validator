package com.github.houbb.validator.core.jsr.constraint;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.util.lang.NumUtil;
import com.github.houbb.validator.api.api.constraint.IConstraintContext;
import com.github.houbb.validator.core.api.constraint.AbstractConstraint;
import com.github.houbb.validator.core.constant.ContextAttrKeyConst;
import com.github.houbb.validator.core.i18n.I18N;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * {@link javax.validation.constraints.Digits} 约束注解实现
 * @author binbin.hou
 * @since 0.0.3
 * @see CharSequence
 * @see BigDecimal
 * @see BigInteger
 * @see Integer
 * @see Byte
 * @see Short
 * @see Long
 *
 * @param <T> 泛型
 * @since 0.0.3
 */
@ThreadSafe
abstract class AbstractDigitsConstraint<T> extends AbstractConstraint<T> {

    /**
     * 整数部分最多多少位
     * @since 0.0.3
     */
    private final int integer;

    /**
     * 小数部分最多多少位
     * @since 0.0.3
     */
    private final int fraction;

    /**
     * 构造器
     * @param integer 整数位数
     * @param fraction 小数位数
     * @since 0.0.3
     */
    public AbstractDigitsConstraint(int integer, int fraction) {
        this.integer = integer;
        this.fraction = fraction;
    }

    /**
     * 构造器
     * @param integer 整数位数
     * @since 0.0.3
     */
    public AbstractDigitsConstraint(int integer) {
        this(integer, 0);
    }

    /**
     * 获取整数部分位数
     * @param value 值
     * @return 位数
     * @since 0.0.3
     */
    protected abstract int getIntegerDigits(final T value);

    /**
     * 获取小数位数
     * @param value 值
     * @return 位数
     * @since 0.0.3
     */
    protected int getFractionDigits(final T value) {
        return 0;
    }

    /**
     * 对值进行处理
     * @param value  值
     * @return 格式化后的结果
     * @since 0.0.3
     */
    protected Object formatValue(final Object value) {
        // 字符串相关进行处理
        if(value instanceof CharSequence) {
            CharSequence charSequence = (CharSequence)value;
            return new BigDecimal(charSequence.toString());
        }
        // BigInteger/BigDecimal 返回本身
        if(value instanceof BigDecimal
            || value instanceof BigInteger) {
            return value;
        }

        // 转换为 long
        return NumUtil.parseLong(value);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected boolean pass(IConstraintContext context, Object value) {
        T actualValue = (T) formatValue(value);
        final int integerDigits = getIntegerDigits(actualValue);
        final int fractionDigits = getFractionDigits(actualValue);

        if(integerDigits <= integer
            && fractionDigits <= fraction) {
            return true;
        }

        // 不通过的时候设置属性
        context.putAttr(ContextAttrKeyConst.SYS_CONSTRAINT_CTX_INTEGER_DIGITS, integerDigits);
        context.putAttr(ContextAttrKeyConst.SYS_CONSTRAINT_CTX_FRACTION_DIGITS, fractionDigits);

        // 返回结果
        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    protected String expectValue(IConstraintContext context) {
        return String.format(I18N.get(I18N.Key.INTEGER_DIGITS_FRACTION_DIGITS),
                integer, fraction);
    }


    @Override
    @SuppressWarnings("unchecked")
    protected String actualValue(IConstraintContext context) {
        final int integerDigits = (int) context.getAttr(ContextAttrKeyConst.SYS_CONSTRAINT_CTX_INTEGER_DIGITS);
        final int fractionDigits = (int) context.getAttr(ContextAttrKeyConst.SYS_CONSTRAINT_CTX_FRACTION_DIGITS);

        return String.format(I18N.get(I18N.Key.INTEGER_DIGITS_FRACTION_DIGITS),
                integerDigits, fractionDigits);
    }

}
