package com.github.houbb.validator.core.jsr.constraint;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.util.lang.StringUtil;
import com.github.houbb.validator.api.api.constraint.IConstraint;
import com.github.houbb.validator.api.api.constraint.IConstraintContext;
import com.github.houbb.validator.core.api.constraint.AbstractConstraint;

/**
 * 为字符串不能为空格
 *
 * @author binbin.hou
 * @since 0.2.0
 */
@ThreadSafe
public class NotEmptyConstraint extends AbstractConstraint<String> {

    /**
     * 唯一实例
     * @since 0.2.0
     */
    private static final IConstraint INSTANCE = new NotEmptyConstraint();

    /**
     * 获取单例示例
     * @return 示例
     * @since 0.2.0
     */
    static IConstraint getInstance() {
        return INSTANCE;
    }

    @Override
    protected boolean pass(IConstraintContext context, String value) {
        return StringUtil.isNotEmpty(value);
    }

    @Override
    protected String expectValue(final IConstraintContext context) {
        return (String) context.value();
    }

}
