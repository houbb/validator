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
public class NullConstraintTest {

    @Test
    public void nullPassTest() {
        IResult result = ValidBs.on(null, Constraints.nulls())
            .valid();
        Assert.assertTrue(result.pass());
        System.out.println(result);
    }

    @Test
    public void nullNotPassTest() {
        IResult result = ValidBs.on("", Constraints.nulls())

                .valid();
        Assert.assertFalse(result.pass());
        System.out.println(result);
    }

}
