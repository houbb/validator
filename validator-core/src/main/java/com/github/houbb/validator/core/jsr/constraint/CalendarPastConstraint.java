package com.github.houbb.validator.core.jsr.constraint;

import com.github.houbb.validator.core.api.constraint.AbstractLessThanConstraint;

import java.util.Calendar;

/**
 * 日历是否在过去
 * @author binbin.hou
 * @since 0.0.3
 */
public class CalendarPastConstraint extends AbstractLessThanConstraint<Calendar> {

    public CalendarPastConstraint(boolean inclusive, Calendar expect) {
        super(inclusive, expect);
    }

    public CalendarPastConstraint(Calendar expect) {
        super(expect);
    }
}
