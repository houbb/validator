package com.github.houbb.validator.core.jsr.constraint.annotation;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.validator.api.api.constraint.IConstraint;
import com.github.houbb.validator.core.api.constraint.Constraints;
import com.github.houbb.validator.core.api.constraint.annotation.AbstractAnnotationConstraint;

import javax.validation.constraints.NotBlank;

/**
 * NotBlank 信息
 * @author binbin.hou
 * @since 0.5.0
 */
@ThreadSafe
public class AtJsrNotBlankConstraint extends AbstractAnnotationConstraint<NotBlank> {

    @Override
    protected IConstraint buildConstraint(NotBlank annotation) {
        return Constraints.notBlankConstraint();
    }

}
