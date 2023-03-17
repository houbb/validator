package com.github.houbb.validator.test.valid;

import com.github.houbb.validator.api.api.condition.ICondition;
import com.github.houbb.validator.api.api.condition.IConditionContext;
import com.github.houbb.validator.api.api.result.IResult;
import com.github.houbb.validator.api.api.validator.IValidEntry;
import com.github.houbb.validator.core.api.fail.Fails;
import com.github.houbb.validator.core.api.result.ResultHandlers;
import com.github.houbb.validator.core.api.validator.entry.ValidEntry;
import com.github.houbb.validator.core.bs.ValidBs;
import com.github.houbb.validator.core.api.constraint.Constraints;
import org.junit.Assert;
import org.junit.Test;

/**
 * 失败处理策略验证
 * @author binbin.hou
 * @since 0.1.2
 */
public class ValidBsConditionTest {

    /**
     * 条件指定测试
     * @since 0.1.2
     */
    @Test
    public void conditionTest() {
        IValidEntry validEntry = ValidEntry.of(Constraints.sizeConstraintMin(3));

        final ICondition condition = new ICondition() {
            @Override
            public boolean condition(IConditionContext conditionContext) {
                final String value = conditionContext.value().toString();
                return value.startsWith("1");
            }
        };
        final ICondition condition2 = new ICondition() {
            @Override
            public boolean condition(IConditionContext conditionContext) {
                final String value = conditionContext.value().toString();
                return value.startsWith("2");
            }
        };

        IResult result = ValidBs.on("12", validEntry.condition(condition))
                .fail(Fails.failFast())
                .valid(ResultHandlers.detail())
                .print();
        Assert.assertFalse(result.pass());

        IResult result2 = ValidBs.on("12", validEntry.condition(condition2))
                .fail(Fails.failFast())
                .valid(ResultHandlers.detail())
                .print();
        Assert.assertTrue(result2.pass());
    }

}
