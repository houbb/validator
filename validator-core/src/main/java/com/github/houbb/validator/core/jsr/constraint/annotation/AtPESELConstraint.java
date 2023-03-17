package com.github.houbb.validator.core.jsr.constraint.annotation;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.validator.api.api.constraint.IConstraint;
import com.github.houbb.validator.core.api.constraint.annotation.AbstractAnnotationConstraint;
import org.hibernate.validator.constraints.pl.PESEL;

/**
 * PESEL 信息
 * @author binbin.hou
 * @since 0.2.0
 */
@ThreadSafe
public class AtPESELConstraint extends AbstractAnnotationConstraint<PESEL> {

    @Override
    protected IConstraint buildConstraint(PESEL annotation) {
        throw new UnsupportedOperationException();
    }

}
