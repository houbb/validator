package com.github.houbb.validator.core.jsr.constraint.annotation;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.validator.api.api.constraint.IConstraint;
import com.github.houbb.validator.core.api.constraint.annotation.AbstractAnnotationConstraint;
import org.hibernate.validator.constraints.Normalized;

/**
 *
 * @author binbin.hou
 * @since 0.1.1
 */
@ThreadSafe
public class AtNormalizedConstraint extends AbstractAnnotationConstraint<Normalized> {

    @Override
    protected IConstraint buildConstraint(Normalized annotation) {
        throw new UnsupportedOperationException();
    }

}
