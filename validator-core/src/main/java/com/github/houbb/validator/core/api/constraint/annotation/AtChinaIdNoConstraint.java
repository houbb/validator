package com.github.houbb.validator.core.api.constraint.annotation;

import com.github.houbb.heaven.annotation.NotThreadSafe;
import com.github.houbb.validator.api.api.constraint.IConstraint;
import com.github.houbb.validator.core.annotation.constraint.ChinaIdNo;
import com.github.houbb.validator.core.annotation.constraint.ChinaPhone;
import com.github.houbb.validator.core.api.constraint.Constraints;

/**
 * 中国身份证
 * @author binbin.hou
 * @since 0.6.0
 */
@NotThreadSafe
public class AtChinaIdNoConstraint extends AbstractAnnotationConstraint<ChinaIdNo> {

    @Override
    protected IConstraint buildConstraint(ChinaIdNo annotation) {
        return Constraints.chinaIdNo(annotation.checkDigit());
    }

}
