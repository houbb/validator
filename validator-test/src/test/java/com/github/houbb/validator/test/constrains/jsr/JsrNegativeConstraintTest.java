package com.github.houbb.validator.test.constrains.jsr;

import com.github.houbb.validator.api.api.result.IResult;
import com.github.houbb.validator.core.api.constraint.Constraints;
import com.github.houbb.validator.core.util.ValidHelper;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 负数
 * @since 0.5.0
 */
public class JsrNegativeConstraintTest {

    @Test
    public void passTest() {
        IResult result1 = ValidHelper.failOver(-1, Constraints.negative());
        Assert.assertTrue(result1.pass());

        IResult result2 = ValidHelper.failOver(-1L, Constraints.negative());
        Assert.assertTrue(result2.pass());

        IResult result3 = ValidHelper.failOver(-1.22, Constraints.negative());
        Assert.assertTrue(result3.pass());

        IResult result4 = ValidHelper.failOver("-2", Constraints.negative());
        Assert.assertTrue(result4.pass());

        IResult result5 = ValidHelper.failOver(new BigDecimal("-5"), Constraints.negative());
        Assert.assertTrue(result5.pass());

        IResult result6 = ValidHelper.failOver(new BigInteger("-7"), Constraints.negative());
        Assert.assertTrue(result6.pass());
    }

    @Test
    public void notPassTest() {
        IResult result0 = ValidHelper.failOver(0, Constraints.negative());
        Assert.assertFalse(result0.pass());

        IResult result1 = ValidHelper.failOver(1, Constraints.negative());
        Assert.assertFalse(result1.pass());

        IResult result2 = ValidHelper.failOver(1L, Constraints.negative());
        Assert.assertFalse(result2.pass());

        IResult result3 = ValidHelper.failOver(1.22, Constraints.negative());
        Assert.assertFalse(result3.pass());

        IResult result4 = ValidHelper.failOver("2", Constraints.negative());
        Assert.assertFalse(result4.pass());

        IResult result5 = ValidHelper.failOver(new BigDecimal("5"), Constraints.negative());
        Assert.assertFalse(result5.pass());

        IResult result6 = ValidHelper.failOver(new BigInteger("7"), Constraints.negative());
        Assert.assertFalse(result6.pass());
    }

}
