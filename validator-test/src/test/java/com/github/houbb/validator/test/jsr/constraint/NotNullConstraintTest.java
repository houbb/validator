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
public class NotNullConstraintTest {

    @Test
    public void notNullPassTest() {
        IResult result = ValidBs.on("", Constraints.notNull())
            .valid();
        Assert.assertTrue(result.pass());
        System.out.println(result);
    }

    /**
     * not null 约束验证不通过场景
     */
    @Test
    public void notNullNotPassTest() {
        IResult result = ValidBs.on(null, Constraints.notNull())
                .valid()
                .print();
        Assert.assertFalse(result.pass());
    }

}
