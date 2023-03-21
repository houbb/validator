package com.github.houbb.validator.test.valid;

import com.github.houbb.validator.api.api.result.IResult;
import com.github.houbb.validator.api.exception.ValidRuntimeException;
import com.github.houbb.validator.core.api.result.ResultHandlers;
import com.github.houbb.validator.core.bs.ValidBs;
import com.github.houbb.validator.core.api.constraint.Constraints;
import org.junit.Assert;
import org.junit.Test;

/**
 * 结果处理策略验证
 * @author binbin.hou
 * @since 0.1.2
 */
public class ValidBsResultTest {

    /**
     * 结果方法测试
     * @since 0.1.2
     */
    @Test(expected = ValidRuntimeException.class)
    public void methodsTest() {
        IResult result = ValidBs.on("12", Constraints.sizeMin(3))
                .valid(ResultHandlers.detail())
                .print()
                .throwsEx();

        Assert.assertFalse(result.pass());
        Assert.assertEquals(1, result.notPassList().size());
        Assert.assertEquals(1, result.allList().size());
    }

}
