package com.github.houbb.validator.core.api.condition.context;

import com.github.houbb.heaven.util.lang.ObjectUtil;
import com.github.houbb.heaven.util.lang.reflect.ReflectFieldUtil;
import com.github.houbb.heaven.util.util.CollectionUtil;
import com.github.houbb.validator.api.api.condition.IConditionContext;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 默认的条件上下文
 * @author binbin.hou
 * @since 0.2.0
 */
public class DefaultConditionContext implements IConditionContext {

    /**
     * 当前验证值
     */
    private Object value;

    /**
     * 约束类分组信息
     * @since 0.2.0
     */
    private Class[] group;

    /**
     * 期望验证的分组信息
     * @since 0.2.0
     */
    private Class[] validGroup;

    /**
     * 属性 map
     * @since 0.2.0
     */
    private Map<String, Object> attrMap = new ConcurrentHashMap<>();

    /**
     * 所有的字段列表信息
     * @since 0.2.0
     */
    private List<Field> fieldList;

    /**
     * 当前对应的对象实例信息
     * @since 0.2.0
     */
    private Object instance;

    public static DefaultConditionContext newInstance() {
        return new DefaultConditionContext();
    }

    @Override
    public Object value() {
        return value;
    }

    public DefaultConditionContext value(Object value) {
        this.value = value;
        return this;
    }

    @Override
    public Class[] group() {
        return group;
    }

    public DefaultConditionContext group(Class[] group) {
        this.group = group;
        return this;
    }

    @Override
    public Class[] validGroup() {
        return validGroup;
    }

    public DefaultConditionContext validGroup(Class[] validGroup) {
        this.validGroup = validGroup;
        return this;
    }

    @Override
    public DefaultConditionContext putAttr(String key, Object object) {
        this.attrMap.put(key, object);
        return this;
    }

    @Override
    public Object getAttr(String key) {
        return attrMap.get(key);
    }

    @Override
    public Object getFieldValue(String fieldName) {
        if(CollectionUtil.isEmpty(fieldList)
                || ObjectUtil.isNull(instance)) {
            return null;
        }

        for(Field field : fieldList) {
            if(field.getName().equals(fieldName)) {
                return ReflectFieldUtil.getValue(field, instance);
            }
        }
        return null;
    }

    public List<Field> fieldList() {
        return fieldList;
    }

    public DefaultConditionContext fieldList(List<Field> fieldList) {
        this.fieldList = fieldList;
        return this;
    }

    public Object instance() {
        return instance;
    }

    public DefaultConditionContext instance(Object instance) {
        this.instance = instance;
        return this;
    }
}
