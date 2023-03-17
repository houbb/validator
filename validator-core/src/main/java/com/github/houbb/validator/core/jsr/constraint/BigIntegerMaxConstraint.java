package com.github.houbb.validator.core.jsr.constraint;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.validator.core.api.constraint.AbstractLessThanConstraint;

import java.math.BigInteger;

/**
 * BigInteger max 约束
 * （1）value 必须小于等于 max
 * @author binbin.hou
 * @since 0.0.3
 * @see BigInteger
 */
@ThreadSafe
public class BigIntegerMaxConstraint extends AbstractLessThanConstraint<BigInteger> {

    public BigIntegerMaxConstraint(boolean inclusive, BigInteger expect) {
        super(inclusive, expect);
    }

    public BigIntegerMaxConstraint(BigInteger expect) {
        super(expect);
    }
}
