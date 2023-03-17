package com.github.houbb.validator.core.jsr.constraint;

import com.github.houbb.heaven.annotation.ThreadSafe;

/**
 * {@link javax.validation.constraints.Digits} 约束注解实现
 * @author binbin.hou
 * @since 0.0.3
 * @see Integer
 * @see Byte
 * @see Short
 * @see Long
 */
@ThreadSafe
public class DigitsLongConstraint extends AbstractDigitsConstraint<Long> {

    public DigitsLongConstraint(int integer, int fraction) {
        super(integer, fraction);
    }

    public DigitsLongConstraint(int integer) {
        super(integer);
    }

    @Override
    protected int getIntegerDigits(Long value) {
        String longStr = value.toString();
        return longStr.length();
    }

}
