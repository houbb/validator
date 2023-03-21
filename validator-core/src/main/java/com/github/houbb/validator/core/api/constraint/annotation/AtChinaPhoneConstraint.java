package com.github.houbb.validator.core.api.constraint.annotation;

import com.github.houbb.heaven.annotation.NotThreadSafe;
import com.github.houbb.validator.api.api.constraint.IConstraint;
import com.github.houbb.validator.core.annotation.constraint.ChinaPhone;
import com.github.houbb.validator.core.api.constraint.Constraints;

/**
 * 中国手机号
 * @author binbin.hou
 * @since 0.6.0
 */
@NotThreadSafe
public class AtChinaPhoneConstraint extends AbstractAnnotationConstraint<ChinaPhone> {

    @Override
    protected IConstraint buildConstraint(ChinaPhone annotation) {
        return Constraints.chinaPhone();
    }

}
