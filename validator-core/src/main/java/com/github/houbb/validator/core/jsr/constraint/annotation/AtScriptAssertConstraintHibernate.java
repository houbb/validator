package com.github.houbb.validator.core.jsr.constraint.annotation;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.validator.api.api.constraint.IConstraint;
import com.github.houbb.validator.core.api.constraint.annotation.AbstractAnnotationConstraint;
import org.hibernate.validator.constraints.ScriptAssert;

/**
 * ScriptAssert 信息
 * @author binbin.hou
 * @since 0.2.0
 */
@ThreadSafe
public class AtScriptAssertConstraintHibernate extends AbstractAnnotationConstraint<ScriptAssert> {

    @Override
    protected IConstraint buildConstraint(ScriptAssert annotation) {
        throw new UnsupportedOperationException();
    }

}
