package com.github.houbb.validator.test.core;

import com.github.houbb.validator.api.api.result.IResult;
import com.github.houbb.validator.api.constant.enums.FailTypeEnum;
import com.github.houbb.validator.core.api.constraint.Constraints;
import com.github.houbb.validator.core.bs.ValidBs;
import org.junit.Assert;
import org.junit.Test;

/**
 * 枚举指定范围内测试
 * @author binbin.hou
 * @since 0.1.2
 */
public class EnumsRangesConstraintTest {

    @Test
    public void notPassTest() {
        IResult result = ValidBs.on("DEFINE", Constraints.enumRangesConstraint(FailTypeEnum.class))
            .valid();

        Assert.assertFalse(result.pass());
    }

    @Test
    public void passTest(){
        IResult result = ValidBs.on("FAIL_FAST", Constraints.enumRangesConstraint(FailTypeEnum.class))
                .valid();

        Assert.assertTrue(result.pass());
    }

}
