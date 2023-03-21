package com.github.houbb.validator.core.jsr.constraint;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.util.util.DateUtil;
import com.github.houbb.validator.core.api.constraint.AbstractGreatThanConstraint;
import com.github.houbb.validator.core.api.constraint.AbstractLessThanConstraint;

import java.util.Date;

/**
 * 判断当前时间，是否在未来
 *
 * @author binbin.hou
 * @since 0.5.0
 */
@ThreadSafe
public class FutureConstraint extends AbstractGreatThanConstraint<Date> {

    public FutureConstraint(Date expect) {
        super(false, expect);
    }

    @Override
    protected Date formatValue(Object contextValue) {
        return DateUtil.toDate(contextValue);
    }

}
