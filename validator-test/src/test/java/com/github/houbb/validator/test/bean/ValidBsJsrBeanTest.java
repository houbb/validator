package com.github.houbb.validator.test.bean;

import com.github.houbb.heaven.util.util.DateUtil;
import com.github.houbb.validator.api.api.result.IResult;
import com.github.houbb.validator.core.api.fail.Fails;
import com.github.houbb.validator.core.api.validator.Validators;
import com.github.houbb.validator.core.bs.ValidBs;
import com.github.houbb.validator.test.model.JsrUser;
import com.github.houbb.validator.test.model.JsrUserSimple;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 基于 bean 进行校验
 * @author binbin.hou
 * @since 0.1.2
 */
public class ValidBsJsrBeanTest {

    /**
     * 全部失败
     * @since 0.1.1
     */
    @Test
    public void beanFailTest() {
        Date future = DateUtil.getFormatDate("90190101", DateUtil.PURE_DATE_FORMAT);
        Date past = DateUtil.getFormatDate("20190101", DateUtil.PURE_DATE_FORMAT);

        JsrUser jsrUser = new JsrUser();
        jsrUser.assertFalse(true)
                .assertTrue(false)
                .decimalMin(new BigDecimal("1"))
                .decimalMax(new BigDecimal("55.55"))
                .min(5)
                .max(20)
                .digits(333333L)
                .future(past)
                .past(future)
                .nullVal("123")
                .notNullVal(null)
                .pattern("asdfasdf")
                .size("22222222222222222222");

        IResult result = ValidBs.on(jsrUser)
                .fail(Fails.failOver())
                .validator(Validators.defaults())
                .valid()
                .print();

        Assert.assertFalse(result.pass());
    }


    /**
     * 全部通过
     * @since 0.1.1
     */
    @Test
    public void beanPassTest() {
        Date future = DateUtil.getFormatDate("90190101", DateUtil.PURE_DATE_FORMAT);
        Date past = DateUtil.getFormatDate("20190101", DateUtil.PURE_DATE_FORMAT);

        JsrUser jsrUser = new JsrUser();
        jsrUser.assertFalse(false)
                .assertTrue(true)
                .decimalMin(new BigDecimal("55.55"))
                .decimalMax(new BigDecimal("1"))
                .min(20)
                .max(5)
                .digits(3L)
                .future(future)
                .past(past)
                .nullVal(null)
                .notNullVal("123")
                .pattern("13")
                .size("22")
        ;
        IResult result = ValidBs.on(jsrUser)
                .fail(Fails.failOver())
                .validator(Validators.defaults())
                .valid();

        Assert.assertTrue(result.pass());
    }

    /**
     * 全部通过
     * @since 0.1.1
     */
    @Test
    public void beanPassSimpleTest() {
        JsrUserSimple jsrUser = new JsrUserSimple();
        jsrUser.assertTrue(true);

        IResult result = ValidBs.on(jsrUser)
                .fail(Fails.failOver())
                .validator(Validators.defaults())
                .valid();

        Assert.assertTrue(result.pass());
    }

}
