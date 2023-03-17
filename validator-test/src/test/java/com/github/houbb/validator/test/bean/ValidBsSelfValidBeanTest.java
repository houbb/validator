package com.github.houbb.validator.test.bean;

import com.github.houbb.validator.api.api.result.IResult;
import com.github.houbb.validator.core.api.fail.Fails;
import com.github.houbb.validator.core.bs.ValidBs;
import com.github.houbb.validator.test.model.SelfValidUser;
import org.junit.Assert;
import org.junit.Test;

/**
 * 核心模块-基于 bean 递归验证进行校验
 * （1）经验证不会进入死循环，符合预期。
 * @author binbin.hou
 * @since 0.1.2
 */
public class ValidBsSelfValidBeanTest {

    /**
     * 对象验证失败测试
     * @since 0.0.9
     */
    @Test
    public void beanFailTest() {
        SelfValidUser selfValidUser = new SelfValidUser();
        selfValidUser.password("old").password2("old");

        // 设置子节点，判断是否会死循环
        SelfValidUser child = new SelfValidUser();
        child.password("old").password2("new");
        selfValidUser.child(child);

        IResult result = ValidBs.on(selfValidUser)
                .fail(Fails.failOver())
                .valid()
                .print();

        Assert.assertFalse(result.pass());
    }

    @Test
    public void beanPassTest() {
        SelfValidUser selfValidUser = new SelfValidUser();
        selfValidUser.password("old").password2("old");

        // 设置子节点，判断是否会死循环
        SelfValidUser child = new SelfValidUser();
        child.password("old").password2("old");
        selfValidUser.child(child);

        IResult result = ValidBs.on(selfValidUser)
                .fail(Fails.failOver())
                .valid()
                .print();

        Assert.assertTrue(result.pass());
    }

}
