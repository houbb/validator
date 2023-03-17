package com.github.houbb.validator.core.jsr.constraint;

import com.github.houbb.validator.core.api.constraint.AbstractGreatThanConstraint;

import java.util.Calendar;

/**
 * 日历是否在未来
 * @author binbin.hou
 * @since 0.0.3
 */
public class CalendarFutureConstraint extends AbstractGreatThanConstraint<Calendar> {

    public CalendarFutureConstraint(boolean inclusive, Calendar expect) {
        super(inclusive, expect);
    }

    public CalendarFutureConstraint(Calendar expect) {
        super(expect);
    }
}
