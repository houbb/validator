package com.github.houbb.validator.core.jsr.constraint;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.util.lang.ObjectUtil;
import com.github.houbb.validator.api.api.constraint.IConstraintContext;
import com.github.houbb.validator.core.api.constraint.AbstractConstraint;

import java.util.Collection;
import java.util.Map;

/**
 * 为 size 约束
 * 初期可以不做此类性能优化处理。
 * @see java.lang.reflect.Array#getLength(Object)  数组
 * @see CharSequence#length()
 * @see Collection#size()
 * @see Map#size()
 *
 * @author binbin.hou
 * @since 0.0.3
 * @see javax.validation.constraints.Size
 */
@ThreadSafe
public class RangeConstraint extends AbstractConstraint {

    /**
     * 最小值
     * size the element must be higher or equal to
     * @since 0.0.3
     */
    private final long min;

    /**
     * 最大值
     * size the element must be lower or equal to
     * @since 0.0.3
     */
    private final long max;

    public RangeConstraint(long min, long max) {
        this.min = min;
        this.max = max;
    }

    @Override
    protected boolean pass(final IConstraintContext context, final Object value) {
        if(ObjectUtil.isNull(value)) {
            return true;
        }

        //类型判断，根据概率 CharSequence > collection > map > array
        final Object object = context.value();
        final long intVal = actualValue(object);

        return rangeCheck(intVal);
    }

    private long actualValue(Object object) {
        if(object instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) object;
            return Integer.parseInt(charSequence.toString());
        }

        // 数字
        if(object instanceof Number) {
            Number number = (Number) object;
            return number.longValue();
        }

        //TODO: 这里应该优化一下提示
        throw new UnsupportedOperationException("@Range value must be string or number type.");
    }

    /**
     * 大小检查
     * @param size 大小
     * @return 是否满足大小
     * @since 0.0.3
     */
    private boolean rangeCheck(final long size) {
        return size >= min && size <= max;
    }

}
