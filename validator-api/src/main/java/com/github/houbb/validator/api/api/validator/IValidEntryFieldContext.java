package com.github.houbb.validator.api.api.validator;

import java.lang.reflect.Field;
import java.util.List;

/**
 * 校验明细对象上下文接口
 *
 * @author binbin.hou
 * @since 0.1.0
 */
public interface IValidEntryFieldContext extends IValidEntryInstanceContext {

    /**
     * 对应的实例对象
     *
     * @return 实例对象
     * @since 0.1.0
     */
    Object instance();

    /**
     * 对应的字段列表
     *
     * @return 实例对象
     * @since 0.1.0
     */
    List<Field> fieldList();

}
