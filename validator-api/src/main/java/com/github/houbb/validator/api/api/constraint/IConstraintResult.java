package com.github.houbb.validator.api.api.constraint;

/**
 * 约束规则结果接口
 * @author binbin.hou
 * @since 0.1.0
 */
public interface IConstraintResult {

    /**
     * 是否通过约束限制
     * @return 是否
     * @since 0.1.0
     */
    boolean pass();

    /**
     * 消息信息
     * @return 消息
     * @since 0.1.0
     */
    String message();

    /**
     * 未通过的限制值
     * @return 结果
     * @since 0.1.0
     */
    Object value();

    /**
     * 约束类信息
     * @return 约束类信息
     * @since 0.1.0
     */
    String constraint();

    /**
     * 预期值
     * （1）主要用于约束验证链信息拼接。
     * @return 预期值
     * @since 0.2.0
     */
    String expectValue();

    /**
     * 字段名称
     * @return 字段名称
     * @since 0.3.0
     */
    String fieldName();

}
