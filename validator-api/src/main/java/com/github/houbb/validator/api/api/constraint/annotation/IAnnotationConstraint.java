package com.github.houbb.validator.api.api.constraint.annotation;


import com.github.houbb.validator.api.api.constraint.IConstraint;

import java.lang.annotation.Annotation;

/**
 * 注解约束规则接口
 * 注意：所有的实现类都需要提供无参构造函数。
 * @author binbin.hou
 * @since 0.1.0
 */
public interface IAnnotationConstraint<A extends Annotation> extends IConstraint {

    /**
     * 初始化映射关系
     * @param annotation 注解信息
     * @since 0.1.0
     */
    void initialize(A annotation);

}
