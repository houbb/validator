package com.github.houbb.validator.core.jsr.constraint;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.validator.core.api.constraint.AbstractLessThanConstraint;

import java.util.Date;

/**
 * 判断当前时间，是否在过去
 *
 * 可以进一步抽象为：
 * （1）大于等于
 * （2）小于等于
 * @author binbin.hou
 * @since 0.0.3
 */
@ThreadSafe
public class DatePastConstraint extends AbstractLessThanConstraint<Date> {

    public DatePastConstraint(boolean inclusive, Date expect) {
        super(inclusive, expect);
    }

    public DatePastConstraint(Date expect) {
        super(expect);
    }

}
