package com.github.houbb.validator.core.jsr.constraint.annotation;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.validator.api.api.constraint.IConstraint;
import com.github.houbb.validator.core.api.constraint.annotation.AbstractAnnotationConstraint;
import com.github.houbb.validator.core.api.constraint.Constraints;

import javax.validation.constraints.Digits;

/**
 * @author binbin.hou
 * @since 0.1.1
 */
@ThreadSafe
public class AtDigitsConstraint extends AbstractAnnotationConstraint<Digits> {

    @Override
    protected IConstraint buildConstraint(Digits annotation) {
        return Constraints.digits(annotation.integer(), annotation.fraction());
    }

}
