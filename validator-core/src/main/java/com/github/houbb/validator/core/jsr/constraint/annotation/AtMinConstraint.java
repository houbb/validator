package com.github.houbb.validator.core.jsr.constraint.annotation;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.validator.api.api.constraint.IConstraint;
import com.github.houbb.validator.core.api.constraint.annotation.AbstractAnnotationConstraint;
import com.github.houbb.validator.core.api.constraint.Constraints;

import javax.validation.constraints.Min;

/**
 * @author binbin.hou
 * @since 0.1.1
 */
@ThreadSafe
public class AtMinConstraint extends AbstractAnnotationConstraint<Min> {

    @Override
    protected IConstraint buildConstraint(Min annotation) {
        return Constraints.minConstraint(annotation.value());
    }

}
