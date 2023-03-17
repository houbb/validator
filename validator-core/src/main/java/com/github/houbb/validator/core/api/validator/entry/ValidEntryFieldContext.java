package com.github.houbb.validator.core.api.validator.entry;

import com.github.houbb.validator.api.api.validator.IValidEntryFieldContext;

import java.lang.reflect.Field;
import java.util.List;

/**
 * 验证明细单个字段上下文
 * @author binbin.hou
 * @since 0.2.0
 */
public class ValidEntryFieldContext implements IValidEntryFieldContext {

    /**
     * 验证分组信息
     * @since 0.2.0
     */
    private Class[] group;

    /**
     * 实例信息
     * @since 0.2.0
     */
    private Object instance;

    /**
     * 字段列表
     * @since 0.2.0
     */
    private List<Field> fieldList;

    /**
     * 创建对象实例
     * @return 上下文实例
     * @since 0.2.0
     */
    public static ValidEntryFieldContext newInstance() {
        return new ValidEntryFieldContext();
    }

    @Override
    public Class[] group() {
        return group;
    }

    public ValidEntryFieldContext group(Class[] group) {
        this.group = group;
        return this;
    }

    @Override
    public Object instance() {
        return instance;
    }

    public ValidEntryFieldContext instance(Object instance) {
        this.instance = instance;
        return this;
    }

    @Override
    public List<Field> fieldList() {
        return fieldList;
    }

    public ValidEntryFieldContext fieldList(List<Field> fieldList) {
        this.fieldList = fieldList;
        return this;
    }
}
