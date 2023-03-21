package com.github.houbb.validator.core.jsr.constraint;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.util.util.DateUtil;
import com.github.houbb.validator.core.api.constraint.AbstractGreatThanConstraint;

import java.util.Date;

/**
 * 判断当前时间，是否在未来。包含当前
 *
 * @author binbin.hou
 * @since 0.5.0
 */
@ThreadSafe
public class FutureOrPresentConstraint extends AbstractGreatThanConstraint<Date> {

    public FutureOrPresentConstraint(Date expect) {
        super(true, expect);
    }

    @Override
    protected Date formatValue(Object contextValue) {
        return DateUtil.toDate(contextValue);
    }

}
