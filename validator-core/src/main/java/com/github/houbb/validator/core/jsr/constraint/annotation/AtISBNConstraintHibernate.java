package com.github.houbb.validator.core.jsr.constraint.annotation;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.validator.api.api.constraint.IConstraint;
import com.github.houbb.validator.core.api.constraint.annotation.AbstractAnnotationConstraint;
import org.hibernate.validator.constraints.ISBN;

/**
 *
 * @author binbin.hou
 * @since 0.2.0
 */
@ThreadSafe
public class AtISBNConstraintHibernate extends AbstractAnnotationConstraint<ISBN> {

    @Override
    protected IConstraint buildConstraint(ISBN annotation) {
        throw new UnsupportedOperationException();
    }

}
