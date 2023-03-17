package com.github.houbb.validator.core.api.constraint.annotation;

import com.github.houbb.heaven.annotation.NotThreadSafe;
import com.github.houbb.validator.api.api.constraint.IConstraint;
import com.github.houbb.validator.core.annotation.constraint.HasNotNull;
import com.github.houbb.validator.core.api.constraint.Constraints;

/**
 * 范围注解约束实现
 *
 * （1）对于接口的调整思考：
 * 关于验证类，是属于一大类。
 *
 * 但是对于注解类，属于另外一大类。
 * 其中，context 继承自约束类 context。
 *
 * 尽量保证二者接口的一致性。
 *
 * @author binbin.hou
 * @since 0.2.0
 */
@NotThreadSafe
public class AtHasNotNullConstraint extends AbstractAnnotationConstraint<HasNotNull> {

    @Override
    protected IConstraint buildConstraint(HasNotNull annotation) {
        return Constraints.hasNotNullConstraint(annotation.value());
    }

}
