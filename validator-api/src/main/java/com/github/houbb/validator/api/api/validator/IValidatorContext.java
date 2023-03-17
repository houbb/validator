package com.github.houbb.validator.api.api.validator;

import com.github.houbb.validator.api.api.fail.IFail;

import java.util.List;

/**
 * 校验器上下文-接口
 * @author binbin.hou
 * @since 0.1.0
 */
public interface IValidatorContext {

    /**
     * 验证的属性值
     *
     * （1）主要是针对 bean 的注解处理。
     * （2）优先处理用户显示指定的验证方式，再执行默认的注解验证方式。
     * @return 验证的属性值
     * @since 0.1.0
     */
    Object value();

    /**
     * 失败策略
     * @return 失败策略
     * @since 0.1.0
     */
    IFail fail();

    /**
     * 验证分组信息
     * @return 分组信息
     * @since 0.1.0
     */
    Class[] group();

    /**
     * 显示指定的验证明细列表
     * @return 验证明细列表
     * @since 0.1.0
     */
    List<IValidEntry> validatorEntries();

}
