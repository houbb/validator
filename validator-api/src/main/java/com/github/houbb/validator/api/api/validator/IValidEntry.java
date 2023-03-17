package com.github.houbb.validator.api.api.validator;

import com.github.houbb.validator.api.api.condition.ICondition;
import com.github.houbb.validator.api.api.constraint.IConstraint;

import java.lang.reflect.Field;
import java.util.List;

/**
 * 校验明细信息接口
 * @author binbin.hou
 * @since 0.1.0
 */
public interface IValidEntry {

    /**
     * 待校验的值
     * @return 待校验的值
     * @since 0.1.0
     */
    Object value();

    /**
     * 约束实现类
     * @return 约束实现类
     * @since 0.1.0
     */
    IConstraint constraint();

    /**
     * 约束进行验证的条件
     * @return 约束进行验证的条件
     * @since 0.1.0
     */
    ICondition condition();

    /**
     * 设置生效条件
     * @param condition 生效条件
     * @return this
     * @since 0.1.0
     */
    IValidEntry condition(final ICondition condition);

    /**
     * 设置消息信息
     * @param message 消息
     * @return this
     * @since 0.1.0
     */
    IValidEntry message(final String message);

    /**
     * 约束提示信息
     * @return 提示信息
     * @since 0.1.0
     */
    String message();

    /**
     * 设置约束分组信息
     * @param groupClass 分组信息
     * @since 0.1.0
     * @return this
     */
    IValidEntry group(final Class... groupClass);

    /**
     * 约束分组信息
     * @since 0.1.0
     * @return 约束分组信息
     */
    Class[] group();

    /**
     * 对应的实例对象
     * @return 实例对象
     * @since 0.1.0
     */
    Object instance();

    /**
     * 对应的字段列表
     * @return 实例对象
     * @since 0.1.0
     */
    List<Field> fieldList();

    /**
     * 当前字段信息
     *
     * @return 字段
     * @since 0.1.4
     */
    Field currentField();

}
