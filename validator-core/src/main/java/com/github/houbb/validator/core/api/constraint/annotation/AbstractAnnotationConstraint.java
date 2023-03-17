package com.github.houbb.validator.core.api.constraint.annotation;

import com.github.houbb.heaven.util.common.ArgUtil;
import com.github.houbb.validator.api.api.constraint.IConstraint;
import com.github.houbb.validator.api.api.constraint.IConstraintContext;
import com.github.houbb.validator.api.api.constraint.IConstraintResult;
import com.github.houbb.validator.api.api.constraint.annotation.IAnnotationConstraint;

import java.lang.annotation.Annotation;

/**
 * 抽象注解约束接口
 * @author binbin.hou
 * @since 0.1.1
 */
public abstract class AbstractAnnotationConstraint<A extends Annotation> implements IAnnotationConstraint<A> {

    /**
     * 注解信息
     */
    private A annotation;

    /**
     * 构建约束实现类
     * @param annotation 注解信息
     * @return 约束实现
     * @since 0.1.1
     */
    protected abstract IConstraint buildConstraint(final A annotation);

    /**
     * 构建注解提示名称
     * @return 提示名称
     * @since 0.1.1
     */
    protected String annotationName() {
        return "annotation";
    }

    @Override
    public void initialize(A annotation) {
        ArgUtil.notNull(annotation, annotationName());
        this.annotation = annotation;
    }

    @Override
    public IConstraintResult constraint(IConstraintContext context) {
        IConstraint constraint = buildConstraint(this.annotation);
        System.out.println(this.annotation + "---------------" + context);
        return constraint.constraint(context);
    }

}
