package com.github.houbb.validator.core.jsr.constraint;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.validator.api.api.constraint.IConstraint;
import com.github.houbb.validator.api.api.constraint.IConstraintContext;
import com.github.houbb.validator.core.api.constraint.AbstractConstraint;
import com.github.houbb.validator.core.jsr.util.JsrSupportClassUtil;

import java.util.List;

/**
 * 为 false 约束
 * @author binbin.hou
 * @since 0.0.3
 */
@ThreadSafe
class AssertFalseConstraint extends AbstractConstraint {

    /**
     * 唯一实例
     * @since 0.0.3
     */
    private static final IConstraint INSTANCE = new AssertFalseConstraint();

    /**
     * 获取单例示例
     * @return 示例
     * @since 0.0.3
     */
    static IConstraint getInstance() {
        return INSTANCE;
    }

    @Override
    protected boolean pass(final IConstraintContext context, final Object value) {
        return Boolean.FALSE.equals(value);
    }

    @Override
    protected String expectValue(final IConstraintContext context) {
        return "false";
    }

    @Override
    protected List<Class> getSupportClassList() {
        return JsrSupportClassUtil.getAssertTrueFalseSupportClassList();
    }
}
