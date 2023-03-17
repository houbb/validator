package com.github.houbb.validator.test.core;

import com.github.houbb.validator.api.api.constraint.IConstraint;
import com.github.houbb.validator.api.api.constraint.IConstraintContext;
import com.github.houbb.validator.api.api.result.IResult;
import com.github.houbb.validator.core.api.constraint.AbstractConstraint;
import com.github.houbb.validator.core.api.constraint.AbstractStrictConstraint;
import com.github.houbb.validator.core.bs.ValidBs;
import org.junit.Assert;
import org.junit.Test;

/**
 * 自定义枚举值测试
 * @author binbin.hou
 * @since 0.1.2
 */
public class DefineConstraintTest {

    /**
     * 自定义非空判断实现
     * @since 0.0.8
     */
    @Test
    public void notNullTest() {
        IResult result = ValidBs.on(null, new AbstractStrictConstraint() {
            @Override
            protected boolean pass(IConstraintContext context, Object value) {
                return value != null;
            }
        }).valid();

        Assert.assertFalse(result.pass());
    }

    @Test
    public void assertTrueTest(){
        IConstraint assertTrueConstraint = new AbstractConstraint<Boolean>() {
            @Override
            protected boolean pass(IConstraintContext context, Boolean value) {
                return false;
            }
        };

        IResult nullValid = ValidBs.on(null, assertTrueConstraint)
                .valid();
        Assert.assertTrue(nullValid.pass());

        IResult falseValid = ValidBs.on(false, assertTrueConstraint)
                .valid();
        Assert.assertFalse(falseValid.pass());
    }

}
