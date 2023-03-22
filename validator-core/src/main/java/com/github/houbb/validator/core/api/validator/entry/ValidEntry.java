package com.github.houbb.validator.core.api.validator.entry;

import com.github.houbb.heaven.util.common.ArgUtil;
import com.github.houbb.validator.api.api.condition.ICondition;
import com.github.houbb.validator.api.api.constraint.IConstraint;
import com.github.houbb.validator.api.api.validator.IValidEntry;

import java.lang.reflect.Field;
import java.util.List;

/**
 * 默认验证器上下文
 *
 * 希望后期可以拓展：
 * <pre>
 *  ValidatorEntryChain.notNull().notEmpty().size(12)
 * </pre>
 *
 * or
 *
 * <pre>
 *  ValidatorEntryChain.addValidatorEntry(XXX).addValidatorEntry(XXX);
 * </pre>
 *
 * 直接使用链式调用的方式，生成一个完整的约束调用链。
 * 允许用户自定定义。
 * @author binbin.hou
 * @since 0.1.0
 */
public class ValidEntry implements IValidEntry {

    /**
     * 待验证的值
     * @since 0.1.0
     */
    private Object value;

    /**
     * 约束实现
     * @since 0.1.0
     */
    private IConstraint constraint;

    /**
     * 约束对应的生效条件
     * @since 0.1.0
     */
    private ICondition condition;

    /**
     * 约束对应的消息提示
     * @since 0.1.0
     */
    private String message;

    /**
     * 分组信息
     * @since 0.1.0
     */
    private Class[] group;

    /**
     * 对应的实例对象
     * @since 0.1.0
     */
    private Object instance;

    /**
     * 对应的字段列表
     * @since 0.1.0
     */
    private List<Field> fieldList;

    /**
     * 当前字段
     * @since 0.1.4
     */
    private Field currentField;

    /**
     * 私有化构造器
     * @since 0.1.2
     */
    private ValidEntry(){}

    /**
     * 创建一个对象实例
     * @param constraint 约束实现
     * @return 验证明细
     * @since 0.1.2
     */
    public static ValidEntry of(final IConstraint constraint) {
        return of(constraint, null);
    }

    /**
     * 创建一个对象实例
     * @param constraint 约束实现
     * @return 验证明细
     * @since 0.7.0
     */
    public static ValidEntry of(final IConstraint constraint,
                                final String message) {
        ValidEntry validEntry = new ValidEntry();
        validEntry.constraint(constraint);
        validEntry.message(message);
        return validEntry;
    }

    @Override
    public Object value() {
        return value;
    }

    public ValidEntry value(Object value) {
        this.value = value;
        return this;
    }

    @Override
    public IConstraint constraint() {
        return constraint;
    }

    public ValidEntry constraint(IConstraint constraint) {
        ArgUtil.notNull(constraint, "constraint");

        this.constraint = constraint;
        return this;
    }

    @Override
    public ICondition condition() {
        return condition;
    }

    @Override
    public ValidEntry condition(ICondition condition) {
        this.condition = condition;
        return this;
    }

    @Override
    public String message() {
        return message;
    }

    @Override
    public ValidEntry message(String message) {
        this.message = message;
        return this;
    }

    @Override
    public Class[] group() {
        return group;
    }

    @Override
    public ValidEntry group(Class... group) {
        this.group = group;
        return this;
    }

    @Override
    public Object instance() {
        return instance;
    }

    public ValidEntry instance(Object instance) {
        this.instance = instance;
        return this;
    }

    @Override
    public List<Field> fieldList() {
        return fieldList;
    }

    public ValidEntry fieldList(List<Field> fieldList) {
        this.fieldList = fieldList;
        return this;
    }

    @Override
    public Field currentField() {
        return currentField;
    }

    public ValidEntry currentField(Field currentField) {
        this.currentField = currentField;
        return this;
    }
}
