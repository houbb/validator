package com.github.houbb.validator.core.jsr.constraint;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.util.lang.ObjectUtil;
import com.github.houbb.validator.api.api.constraint.IConstraintContext;
import com.github.houbb.validator.core.api.constraint.AbstractConstraint;
import com.github.houbb.validator.core.i18n.I18N;

/**
 * 是否满足正则表达式
 * @author binbin.hou
 * @since 0.0.3
 * @see javax.validation.constraints.Pattern 正则表达式注解
 */
@ThreadSafe
public class CNPJConstraint extends AbstractConstraint<CharSequence> {

    /**
     * 正则表达式
     * @since 0.0.3
     */
    private final String regex;

    public CNPJConstraint() {
        this.regex = "([0-9]{2}[.]?[0-9]{3}[.]?[0-9]{3}[/]?[0-9]{4}[-]?[0-9]{2})";
    }

    @Override
    protected boolean pass(IConstraintContext context, CharSequence value) {
        if(ObjectUtil.isNull(value)) {
            return true;
        }

        String string = value.toString();
        return string.matches(regex);
    }

    @Override
    protected String expectValue(IConstraintContext context) {
        return String.format(I18N.get(I18N.Key.MATCH_REGEX_PATTERN), regex);
    }

}
