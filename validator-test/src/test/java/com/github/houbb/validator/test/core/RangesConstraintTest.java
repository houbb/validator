package com.github.houbb.validator.test.core;

import com.github.houbb.validator.api.api.result.IResult;
import com.github.houbb.validator.core.api.constraint.Constraints;
import com.github.houbb.validator.core.bs.ValidBs;
import org.junit.Assert;
import org.junit.Test;

/**
 * 值指定范围内测试
 * @author binbin.hou
 * @since 0.1.2
 */
public class RangesConstraintTest {

    @Test
    public void notPassTest() {
        IResult result = ValidBs.on("DEFINE", Constraints.ranges("FAIL_OVER",
                "FAIL_FAST"))
            .valid();

        Assert.assertFalse(result.pass());
    }

    @Test
    public void passTest(){
        IResult result = ValidBs.on("FAIL_OVER", Constraints.ranges("FAIL_OVER",
                "FAIL_FAST"))
                .valid();

        Assert.assertTrue(result.pass());
    }

}
