package com.github.houbb.validator.core.jsr.constraint.annotation;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.validator.api.api.constraint.IConstraint;
import com.github.houbb.validator.core.api.constraint.annotation.AbstractAnnotationConstraint;
import com.github.houbb.validator.core.api.constraint.Constraints;
import org.hibernate.validator.constraints.Range;

/**
 * Range 信息
 * @author binbin.hou
 * @since 0.2.0
 */
@ThreadSafe
public class AtRangeConstraint extends AbstractAnnotationConstraint<Range> {

    @Override
    protected IConstraint buildConstraint(Range annotation) {
        return Constraints.rangeConstraint(annotation.min(), annotation.max());
    }

}
