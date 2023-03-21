package com.github.houbb.validator.test.jsr.constraint;

import com.github.houbb.validator.api.api.result.IResult;
import com.github.houbb.validator.core.bs.ValidBs;
import com.github.houbb.validator.core.api.constraint.Constraints;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author binbin.hou
 * @since 0.0.3
 */
public class DecimalMaxConstraintTest {

    @Test
    public void passTest() {
        IResult result = ValidBs.on(99, Constraints.decimalMax("100"))
            .valid();
        Assert.assertTrue(result.pass());
        System.out.println(result);
    }

    @Test
    public void passInclusiveTest() {
        IResult result = ValidBs.on(100, Constraints.decimalMax(true, "100"))
                .valid();
        Assert.assertTrue(result.pass());
        System.out.println(result);
    }

    @Test
    public void passNullTest() {
        IResult result = ValidBs.on(null, Constraints.decimalMax("100"))
                .valid();
        Assert.assertTrue(result.pass());
        System.out.println(result);
    }

    @Test
    public void notPassTest() {
        IResult result = ValidBs.on(101, Constraints.decimalMax("100"))

                .valid();
        Assert.assertFalse(result.pass());
        System.out.println(result);
    }

    @Test
    public void notPassNotInclusiveTest() {
        IResult result = ValidBs.on(100, Constraints.decimalMax(false,"100"))

                .valid();
        Assert.assertFalse(result.pass());
        System.out.println(result);
    }

    /**
     * TODO: 后期可以考虑添加 float double 的拓展支持。
     */
    @Test(expected = ClassCastException.class)
    public void classCastException() {
        IResult result = ValidBs.on(123.34f, Constraints.decimalMax("100"))

                .valid();
        System.out.println(result);
    }

}
