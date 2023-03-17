package com.github.houbb.validator.core.jsr.constraint;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.util.lang.ObjectUtil;
import com.github.houbb.validator.api.api.constraint.IConstraintContext;
import com.github.houbb.validator.core.api.constraint.AbstractConstraint;
import com.github.houbb.validator.core.i18n.I18N;

import java.util.ArrayList;
import java.util.List;

/**
 * 是否满足 CPF 正则表达式
 * @author binbin.hou
 * @since 0.0.3
 * @see javax.validation.constraints.Pattern 正则表达式注解
 */
@ThreadSafe
public class CPFConstraint extends AbstractConstraint<CharSequence> {

    /**
     * 正则表达式
     * @since 0.0.3
     */
    private final List<String> regexList;

    public CPFConstraint() {
        regexList = new ArrayList<>();
        regexList.add("([0-9]{3}[.]?[0-9]{3}[.]?[0-9]{3}-[0-9]{2})|([0-9]{11})");
        // XXX.XXX.XXX-XX where X is always the same digit are not a valid CPFs,
        // but all of them passes the mod check.
        // Needs to be singled out each one via regexp
        regexList.add("^(?:(?!000\\.?000\\.?000-?00).)*$");
        regexList.add("^(?:(?!111\\.?111\\.?111-?11).)*$");
        regexList.add("^(?:(?!222\\.?222\\.?222-?22).)*$");
        regexList.add("^(?:(?!333\\.?333\\.?333-?33).)*$");
        regexList.add("^(?:(?!444\\.?444\\.?444-?44).)*$");
        regexList.add("^(?:(?!555\\.?555\\.?555-?55).)*$");
        regexList.add("^(?:(?!666\\.?666\\.?666-?66).)*$");
        regexList.add("^(?:(?!777\\.?777\\.?777-?77).)*$");
        regexList.add("^(?:(?!888\\.?888\\.?888-?88).)*$");
        regexList.add("^(?:(?!999\\.?999\\.?999-?99).)*$");
    }

    @Override
    protected boolean pass(IConstraintContext context, CharSequence value) {
        if(ObjectUtil.isNull(value)) {
            return true;
        }

        String string = value.toString();
        for(String regex : regexList) {
            if(!string.matches(regex)) {
                return false;
            }
        }
        return true;
    }

    @Override
    protected String expectValue(IConstraintContext context) {
        return String.format(I18N.get(I18N.Key.MATCH_REGEX_PATTERN), "CPF");
    }

}
