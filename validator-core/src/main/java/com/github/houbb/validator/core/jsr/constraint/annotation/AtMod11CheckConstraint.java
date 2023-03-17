package com.github.houbb.validator.core.jsr.constraint.annotation;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.validator.api.api.constraint.IConstraint;
import com.github.houbb.validator.core.api.constraint.annotation.AbstractAnnotationConstraint;
import org.hibernate.validator.constraints.Mod11Check;

/**
 *
 * @author binbin.hou
 * @since 0.2.0
 */
@ThreadSafe
public class AtMod11CheckConstraint extends AbstractAnnotationConstraint<Mod11Check> {

    @Override
    protected IConstraint buildConstraint(Mod11Check annotation) {
        throw new UnsupportedOperationException();
    }

}
