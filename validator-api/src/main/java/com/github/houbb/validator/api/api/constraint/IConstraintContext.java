package com.github.houbb.validator.api.api.constraint;

import com.github.houbb.validator.api.api.fail.IFail;

import java.lang.reflect.Field;

/**
 * 约束条件上下文接口
 * @author binbin.hou
 * @since 0.1.0
 */
public interface IConstraintContext {

    /**
     * 待验证的值
     * @return 待验证的值
     * @since 0.1.0
     */
    Object value();

    /**
     * 指定描述消息
     * @return 描述消息
     * @since 0.2.0
     */
    String message();

    /**
     * 失败模式
     * @return 失败模式
     * @since 0.2.0
     */
    IFail fail();

    /**
     * 设置属性值
     * @param key key
     * @param object 值
     * @return this
     * @since 0.2.0
     */
    IConstraintContext putAttr(final String key, final Object object);

    /**
     * 获取属性值
     * @param key key
     * @return this
     * @since 0.2.0
     */
    Object getAttr(final String key);

    /**
     * 根据字段名称，获取对应的字段值
     * （1）如果对应字段列表为空，或者对象实例为 null，则返回 null
     * （2）返回名称和指定 fieldName 相同的才返回对应的值信息。
     *
     * TRADE-OFF:
     *
     * 这样对于字段间的关系可以增强，但是不适合暴露太多信息，会让使用者变得混乱。
     * @param fieldName 字段名称
     * @return 该字段的值
     * @since 0.1.0
     */
    Object getFieldValue(final String fieldName);

    /**
     * 当前字段
     * @return 当前字段
     * @since 0.1.4
     */
    Field currentField();

    /**
     * 当前字段
     * @param field 设置当前字段
     * @return 当前字段
     * @since 0.1.4
     */
    IConstraintContext currentField(final Field field);

}
