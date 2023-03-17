package com.github.houbb.validator.api.api.condition.annotation;

import com.github.houbb.validator.api.api.condition.ICondition;

import java.lang.annotation.Annotation;

/**
 * 注解类条件接口
 * 注意：所有实现类必须提供无参构造器
 * @author binbin.hou
 * @since 0.1.0
 */
public interface IAnnotationCondition<A extends Annotation> extends ICondition {

    /**
     * 初始化映射关系
     * @param annotation 注解信息
     * @since 0.1.0
     */
    void initialize(A annotation);

}
