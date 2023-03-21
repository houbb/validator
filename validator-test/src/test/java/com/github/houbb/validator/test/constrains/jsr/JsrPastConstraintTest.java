package com.github.houbb.validator.test.constrains.jsr;

import com.github.houbb.heaven.util.util.DateUtil;
import com.github.houbb.validator.api.api.result.IResult;
import com.github.houbb.validator.core.api.constraint.Constraints;
import com.github.houbb.validator.core.util.ValidHelper;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * 过去
 * @since 0.5.0
 */
public class JsrPastConstraintTest {

    @Test
    public void assertTrueTest() {
        Date pastTime = DateUtil.parseDate("2023-01-01", "yyyy-MM-dd");
        Date currentTime = DateUtil.parseDate("2023-03-21", "yyyy-MM-dd");

        IResult result1 = ValidHelper.failOver(pastTime, Constraints.past(currentTime));
        Assert.assertTrue(result1.pass());

        // 取系统默认时间
        IResult result2 = ValidHelper.failOver(pastTime, Constraints.past());
        Assert.assertTrue(result2.pass());
    }

    @Test
    public void assertFalseTest() {
        Date futureTime = DateUtil.parseDate("2099-01-01", "yyyy-MM-dd");
        Date currentTime = DateUtil.parseDate("2023-03-21", "yyyy-MM-dd");

        IResult result1 = ValidHelper.failOver(futureTime, Constraints.past(currentTime));
        Assert.assertFalse(result1.pass());

        IResult resultEquals = ValidHelper.failOver(currentTime, Constraints.past(currentTime));
        Assert.assertFalse(resultEquals.pass());

        // 取系统默认时间
        IResult result2 = ValidHelper.failOver(futureTime, Constraints.past());
        Assert.assertFalse(result2.pass());
    }

}
