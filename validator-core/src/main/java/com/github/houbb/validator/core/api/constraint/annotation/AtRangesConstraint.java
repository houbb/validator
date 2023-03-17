package com.github.houbb.validator.core.api.constraint.annotation;

import com.github.houbb.heaven.annotation.NotThreadSafe;
import com.github.houbb.validator.api.api.constraint.IConstraint;
import com.github.houbb.validator.core.annotation.constraint.Ranges;
import com.github.houbb.validator.core.api.constraint.Constraints;

/**
 * 范围注解约束实现
 * @author binbin.hou
 * @since 0.2.0
 */
@NotThreadSafe
public class AtRangesConstraint extends AbstractAnnotationConstraint<Ranges> {

    @Override
    protected IConstraint buildConstraint(Ranges annotation) {
        return Constraints.rangesConstraint(annotation.value());
    }

}
