package com.github.houbb.validator.core.jsr.constraint.annotation;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.validator.api.api.constraint.IConstraint;
import com.github.houbb.validator.core.api.constraint.annotation.AbstractAnnotationConstraint;
import org.hibernate.validator.constraints.EAN;

/**
 *
 * @author binbin.hou
 * @since 0.2.0
 */
@ThreadSafe
public class AtEANConstraint extends AbstractAnnotationConstraint<EAN> {

    @Override
    protected IConstraint buildConstraint(EAN annotation) {
        throw new UnsupportedOperationException();
    }

}
