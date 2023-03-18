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
public class NotBlankConstraintTest {

    @Test
    public void passTest() {
        IResult result = ValidBs.on(false, Constraints.assertFalseConstraint())
            .valid();
        Assert.assertTrue(result.pass());
        System.out.println(result);
    }

    @Test
    public void passNullTest() {
        IResult result = ValidBs.on(null, Constraints.assertFalseConstraint())
                .valid();
        Assert.assertTrue(result.pass());
        System.out.println(result);
    }

    @Test
    public void notPassTest() {
        IResult result = ValidBs.on(true, Constraints.assertFalseConstraint())
                .valid();
        Assert.assertFalse(result.pass());
        System.out.println(result);
    }

    @Test(expected = ClassCastException.class)
    public void unSupportClassTypeTest() {
        IResult result = ValidBs.on("123", Constraints.assertFalseConstraint())
                .valid();
        Assert.assertFalse(result.pass());
        System.out.println(result);
    }

}
