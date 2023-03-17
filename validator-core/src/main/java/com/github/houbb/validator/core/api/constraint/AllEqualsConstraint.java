package com.github.houbb.validator.core.api.constraint;

import com.github.houbb.heaven.util.lang.ObjectUtil;
import com.github.houbb.validator.api.api.constraint.IConstraintContext;

/**
 * 全部相等的约束
 * @author binbin.hou
 * @since 0.1.1
 */
class AllEqualsConstraint extends AbstractConstraint {

    /**
     * 其他字段名称
     */
    private final String[] otherFieldNames;

    AllEqualsConstraint(String[] otherFieldNames) {
        this.otherFieldNames = otherFieldNames;
    }

    @Override
    protected boolean pass(IConstraintContext context, Object value) {
        for(String fieldName : otherFieldNames) {
            // 获取对应字段的值
            Object fieldValue = context.getFieldValue(fieldName);

            if(!ObjectUtil.isEqualsOrNull(fieldValue, value)) {
                // 这里可以重写 message 消息。
                // 设置 context#message 信息。
                return false;
            }
        }

        return true;
    }

}
