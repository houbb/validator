package com.github.houbb.validator.core.api.constraint;

import com.github.houbb.heaven.annotation.NotThreadSafe;
import com.github.houbb.heaven.util.lang.ObjectUtil;
import com.github.houbb.validator.api.api.constraint.IConstraintContext;

/**
 * 范围约束实现
 *
 * （1）对于接口的调整思考：
 * 关于验证类，是属于一大类。
 *
 * 但是对于注解类，属于另外一大类。
 * 其中，context 继承自约束类 context。
 *
 * 尽量保证二者接口的一致性。
 *
 * @author binbin.hou
 * @since 0.2.0
 */
@NotThreadSafe
class HasNotNullConstraint extends AbstractStrictConstraint {

    /**
     * 其他字段信息
     * @since 0.1.1
     */
    private final String[] otherFieldNames;

    HasNotNullConstraint(String[] otherFieldNames) {
        this.otherFieldNames = otherFieldNames;
    }

    @Override
    protected boolean pass(IConstraintContext context, Object value) {
        // 当前 field 信息
        // 其他 field 信息
        if(ObjectUtil.isNotNull(value)) {
            return true;
        }

        for(String fieldName : otherFieldNames) {
            // 获取对应字段的值
            Object fieldValue = context.getFieldValue(fieldName);

            if(ObjectUtil.isNotNull(fieldValue)) {
                return true;
            }
        }

        return false;
    }

}
