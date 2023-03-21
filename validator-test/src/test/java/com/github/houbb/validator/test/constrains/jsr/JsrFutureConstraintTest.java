package com.github.houbb.validator.test.constrains.jsr;

import com.github.houbb.heaven.util.util.DateUtil;
import com.github.houbb.validator.api.api.result.IResult;
import com.github.houbb.validator.core.api.constraint.Constraints;
import com.github.houbb.validator.core.util.ValidHelper;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * 未来
 * @since 0.5.0
 */
public class JsrFutureConstraintTest {

    @Test
    public void assertFalseTest() {
        Date pastTime = DateUtil.parseDate("2023-01-01", "yyyy-MM-dd");
        Date currentTime = DateUtil.parseDate("2023-03-21", "yyyy-MM-dd");

        IResult result1 = ValidHelper.failOver(pastTime, Constraints.future(currentTime));
        Assert.assertFalse(result1.pass());

        // 取系统默认时间
        IResult result2 = ValidHelper.failOver(pastTime, Constraints.future());
        Assert.assertFalse(result2.pass());

        // 相等
        IResult resultEquals = ValidHelper.failOver(currentTime, Constraints.future(currentTime));
        Assert.assertFalse(resultEquals.pass());
    }


    @Test
    public void assertTrueTest() {
        Date futureTime = DateUtil.parseDate("2099-01-01", "yyyy-MM-dd");
        Date currentTime = DateUtil.parseDate("2023-03-21", "yyyy-MM-dd");

        IResult result1 = ValidHelper.failOver(futureTime, Constraints.future(currentTime));
        Assert.assertTrue(result1.pass());


        // 取系统默认时间
        IResult result2 = ValidHelper.failOver(futureTime, Constraints.future());
        Assert.assertTrue(result2.pass());
    }

}
