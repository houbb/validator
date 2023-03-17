package com.github.houbb.validator.core.jsr.constraint;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.util.lang.ObjectUtil;
import com.github.houbb.heaven.util.util.regex.RegexUtil;
import com.github.houbb.validator.api.api.constraint.IConstraintContext;
import com.github.houbb.validator.core.api.constraint.AbstractConstraint;
import com.github.houbb.validator.core.i18n.I18N;

/**
 * 是否满足 URL 正则表达式
 * @author binbin.hou
 * @since 0.0.3
 * @see javax.validation.constraints.Pattern 正则表达式注解
 */
@ThreadSafe
public class EmailConstraint extends AbstractConstraint<CharSequence> {

    @Override
    protected boolean pass(IConstraintContext context, CharSequence value) {
        if(ObjectUtil.isNull(value)) {
            return true;
        }

        return RegexUtil.isEmail(value.toString());
    }

    @Override
    protected String expectValue(IConstraintContext context) {
        return String.format(I18N.get(I18N.Key.MATCH_REGEX_PATTERN), "EMAIL");
    }

}
