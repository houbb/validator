package com.github.houbb.validator.core.jsr.constraint.annotation;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.validator.api.api.constraint.IConstraint;
import com.github.houbb.validator.core.api.constraint.annotation.AbstractAnnotationConstraint;
import org.hibernate.validator.constraints.pl.NIP;

/**
 * NIP 信息
 * @author binbin.hou
 * @since 0.2.0
 */
@ThreadSafe
public class AtNIPConstraint extends AbstractAnnotationConstraint<NIP> {

    @Override
    protected IConstraint buildConstraint(NIP annotation) {
        throw new UnsupportedOperationException();
    }

}
