package com.github.houbb.validator.core.jsr.constraint;

import com.github.houbb.heaven.annotation.ThreadSafe;

import java.math.BigInteger;

/**
 * {@link javax.validation.constraints.Digits} 约束注解实现
 * @author binbin.hou
 * @since 0.0.3
 * @see BigInteger
 */
@ThreadSafe
public class DigitsBigIntegerConstraint extends AbstractDigitsConstraint<BigInteger> {

    public DigitsBigIntegerConstraint(int integer, int fraction) {
        super(integer, fraction);
    }

    public DigitsBigIntegerConstraint(int integer) {
        super(integer);
    }

    @Override
    protected int getIntegerDigits(BigInteger value) {
        return value.toString().length();
    }

}
