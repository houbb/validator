package com.github.houbb.validator.core.jsr.constraint.annotation;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.validator.api.api.constraint.IConstraint;
import com.github.houbb.validator.core.api.constraint.annotation.AbstractAnnotationConstraint;
import com.github.houbb.validator.core.api.constraint.Constraints;

import javax.validation.constraints.AssertTrue;

/**
 * AssertTrue 信息
 * @author binbin.hou
 * @since 0.1.1
 */
@ThreadSafe
public class AtAssertTrueConstraint extends AbstractAnnotationConstraint<AssertTrue> {

    @Override
    protected IConstraint buildConstraint(AssertTrue annotation) {
        return Constraints.assertTrue();
    }

}
