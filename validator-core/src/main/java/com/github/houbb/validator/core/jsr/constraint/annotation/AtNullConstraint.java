package com.github.houbb.validator.core.jsr.constraint.annotation;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.validator.api.api.constraint.IConstraint;
import com.github.houbb.validator.core.api.constraint.annotation.AbstractAnnotationConstraint;
import com.github.houbb.validator.core.api.constraint.Constraints;

import javax.validation.constraints.Null;

/**
 * @author binbin.hou
 * @since 0.1.1
 */
@ThreadSafe
public class AtNullConstraint extends AbstractAnnotationConstraint<Null> {

    @Override
    protected IConstraint buildConstraint(Null annotation) {
        return Constraints.nulls();
    }

}
