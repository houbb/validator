package com.github.houbb.validator.core.jsr.constraint.annotation;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.validator.api.api.constraint.IConstraint;
import com.github.houbb.validator.core.api.constraint.annotation.AbstractAnnotationConstraint;
import com.github.houbb.validator.core.api.constraint.Constraints;

import javax.validation.constraints.Max;

/**
 * @author binbin.hou
 * @since 0.1.1
 */
@ThreadSafe
public class AtMaxConstraint extends AbstractAnnotationConstraint<Max> {

    @Override
    protected IConstraint buildConstraint(Max annotation) {
        return Constraints.maxConstraint(annotation.value());
    }

}
