package com.github.houbb.validator.core.jsr.constraint.annotation;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.validator.api.api.constraint.IConstraint;
import com.github.houbb.validator.core.api.constraint.Constraints;
import com.github.houbb.validator.core.api.constraint.annotation.AbstractAnnotationConstraint;

import javax.validation.constraints.PositiveOrZero;

/**
 * @author binbin.hou
 * @since 0.5.0
 */
@ThreadSafe
public class AtPositiveOrZeroConstraint extends AbstractAnnotationConstraint<PositiveOrZero> {

    @Override
    protected IConstraint buildConstraint(PositiveOrZero annotation) {
        return Constraints.positiveOrZero();
    }

}
