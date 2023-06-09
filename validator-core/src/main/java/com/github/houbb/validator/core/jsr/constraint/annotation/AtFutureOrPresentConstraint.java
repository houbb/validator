package com.github.houbb.validator.core.jsr.constraint.annotation;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.validator.api.api.constraint.IConstraint;
import com.github.houbb.validator.core.api.constraint.Constraints;
import com.github.houbb.validator.core.api.constraint.annotation.AbstractAnnotationConstraint;

import javax.validation.constraints.FutureOrPresent;

/**
 * @author binbin.hou
 * @since 0.5.0
 */
@ThreadSafe
public class AtFutureOrPresentConstraint extends AbstractAnnotationConstraint<FutureOrPresent> {

    @Override
    protected IConstraint buildConstraint(FutureOrPresent annotation) {
        return Constraints.futureOrPresent();
    }

}
