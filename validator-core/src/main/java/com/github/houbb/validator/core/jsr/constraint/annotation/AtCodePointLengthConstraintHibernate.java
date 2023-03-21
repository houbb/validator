package com.github.houbb.validator.core.jsr.constraint.annotation;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.validator.api.api.constraint.IConstraint;
import com.github.houbb.validator.core.api.constraint.annotation.AbstractAnnotationConstraint;
import org.hibernate.validator.constraints.CodePointLength;

/**
 * CodePointLength 信息
 * @author binbin.hou
 * @since 0.2.0
 */
@ThreadSafe
public class AtCodePointLengthConstraintHibernate extends AbstractAnnotationConstraint<CodePointLength> {

    @Override
    protected IConstraint buildConstraint(CodePointLength annotation) {
        throw new UnsupportedOperationException();
    }

}
