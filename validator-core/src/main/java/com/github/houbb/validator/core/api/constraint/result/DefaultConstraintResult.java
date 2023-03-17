package com.github.houbb.validator.core.api.constraint.result;

import com.github.houbb.validator.api.api.constraint.IConstraintResult;

/**
 * 约束规则结果默认实现
 *
 * @author binbin.hou
 * @since 0.2.0
 */
public class DefaultConstraintResult implements IConstraintResult {

    /**
     * 是否通过约束限制
     *
     * @since 0.2.0
     */
    private boolean pass;

    /**
     * 消息信息
     *
     * @since 0.2.0
     */
    private String message;

    /**
     * 未通过的限制值
     *
     * @since 0.2.0
     */
    private Object value;

    /**
     * 约束类信息
     *
     * @since 0.2.0
     */
    private String constraint;

    /**
     * 预期值
     * @since 0.2.0
     */
    private String expectValue;

    /**
     * 字段名称
     * @since 0.3.0
     */
    private String fieldName;

    public static DefaultConstraintResult newInstance() {
        return new DefaultConstraintResult();
    }

    @Override
    public boolean pass() {
        return pass;
    }

    public DefaultConstraintResult pass(boolean pass) {
        this.pass = pass;
        return this;
    }

    @Override
    public String message() {
        return message;
    }

    public DefaultConstraintResult message(String message) {
        this.message = message;
        return this;
    }

    @Override
    public Object value() {
        return value;
    }

    public DefaultConstraintResult value(Object value) {
        this.value = value;
        return this;
    }

    @Override
    public String constraint() {
        return constraint;
    }

    public DefaultConstraintResult constraint(String constraint) {
        this.constraint = constraint;
        return this;
    }

    @Override
    public String expectValue() {
        return expectValue;
    }

    public DefaultConstraintResult expectValue(String expectValue) {
        this.expectValue = expectValue;
        return this;
    }

    @Override
    public String fieldName() {
        return fieldName;
    }

    public DefaultConstraintResult fieldName(String fieldName) {
        this.fieldName = fieldName;
        return this;
    }

    @Override
    public String toString() {
        return "DefaultConstraintResult{" +
                "pass=" + pass +
                ", message='" + message + '\'' +
                ", value=" + value +
                ", constraint='" + constraint + '\'' +
                ", expectValue='" + expectValue + '\'' +
                ", fieldName='" + fieldName + '\'' +
                '}';
    }

}
