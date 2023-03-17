package com.github.houbb.validator.test.bean;

import com.github.houbb.validator.api.api.result.IResult;
import com.github.houbb.validator.core.api.fail.Fails;
import com.github.houbb.validator.core.api.result.ResultHandlers;
import com.github.houbb.validator.core.api.validator.Validators;
import com.github.houbb.validator.core.bs.ValidBs;
import com.github.houbb.validator.test.model.condition.ConditionUser;
import org.junit.Assert;
import org.junit.Test;

/**
 * 核心模块-条件注解基于 bean 进行校验
 * @author binbin.hou
 * @since 0.1.3
 */
public class ValidBsConditionBeanTest {

    /**
     * 新建时测试
     * @since 0.1.3
     */
    @Test
    public void createConditionTest() {
        ConditionUser conditionUser = new ConditionUser();
        conditionUser.operType("create").id("123").name("1");

        IResult result = ValidBs.on(conditionUser)
                .fail(Fails.failOver())
                .validator(Validators.defaults())
                .valid(ResultHandlers.detail())
                .print();

        Assert.assertFalse(result.pass());
        Assert.assertEquals(1, result.notPassList().size());
        Assert.assertEquals("1", result.notPassList().get(0).value());
    }

    /**
     * 编辑时条件测试
     */
    @Test
    public void editConditionTest() {
        ConditionUser conditionUser = new ConditionUser();
        conditionUser.operType("edit").id("123").name("1");

        IResult result = ValidBs.on(conditionUser)
                .fail(Fails.failOver())
                .validator(Validators.defaults())
                .valid(ResultHandlers.detail())
                .print();

        Assert.assertFalse(result.pass());
        Assert.assertEquals(1, result.notPassList().size());
        Assert.assertEquals("123", result.notPassList().get(0).value());
    }


}
