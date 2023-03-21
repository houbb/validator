package com.github.houbb.validator.test.atconstrains.jsr;

import com.github.houbb.validator.api.api.result.IResult;
import com.github.houbb.validator.core.util.ValidHelper;
import com.github.houbb.validator.test.atconstrains.bean.JsrAtNegativeBo;
import com.github.houbb.validator.test.atconstrains.bean.JsrAtPositiveBo;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 负数
 * @since 0.5.0
 */
public class JsrAtPositiveConstraintTest {

    @Test
    public void assertFalseTest() {
        JsrAtPositiveBo bo = new JsrAtPositiveBo();
        bo.setIntVal(0);
        bo.setStringVal("-1");
        bo.setShortVal((short)-1);
        bo.setLongVal((long)-1);
        bo.setDoubleVal(-1.2);
        bo.setBigDecimalVal(new BigDecimal("-1"));
        bo.setBigIntegerVal(new BigInteger("-1"));

        IResult result1 = ValidHelper.failOver(bo);
        Assert.assertFalse(result1.pass());
    }

    @Test
    public void assertTrueTest() {
        JsrAtPositiveBo bo = new JsrAtPositiveBo();
        bo.setIntVal(1);
        bo.setStringVal("1");
        bo.setShortVal((short)1);
        bo.setLongVal((long)1);
        bo.setDoubleVal(1.2);
        bo.setBigDecimalVal(new BigDecimal("1"));
        bo.setBigIntegerVal(new BigInteger("1"));

        IResult result1 = ValidHelper.failOver(bo);
        Assert.assertTrue(result1.pass());
    }

}
