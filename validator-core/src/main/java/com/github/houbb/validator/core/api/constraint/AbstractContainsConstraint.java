package com.github.houbb.validator.core.api.constraint;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.util.common.ArgUtil;
import com.github.houbb.heaven.util.lang.reflect.ClassTypeUtil;
import com.github.houbb.validator.api.api.constraint.IConstraintContext;

import java.util.List;

/**
 * 抽象约包含束实现
 * （1）如果为基本类型，使用 == 进行比较
 * （2）如果为对象，使用 equals 进行比较。
 *
 * @author binbin.hou
 * @since 0.2.0
 * @param <T> 泛型
 */
@ThreadSafe
public abstract class AbstractContainsConstraint<T> extends AbstractConstraint<T> {

    /**
     * 构建全部范围信息
     * （1）这个列表应该非空，否则没有任何意义。
     * @return 结果列表
     * @since 0.2.0
     */
    protected abstract List<T> ranges();

    @Override
    protected boolean pass(IConstraintContext context, T value) {
        List<T> ranges = ranges();
        ArgUtil.notEmpty(ranges, "ranges");

        boolean isPrimitive = ClassTypeUtil.isPrimitive(value);

        for(T t : ranges) {
            // 基本变量，使用 == 比较
            if(isPrimitive) {
                if(t == value) {
                    return true;
                }
            } else {
                // 因为 null 不会走到这里
                if(value.equals(t)) {
                    return true;
                }
            }
        }

        return false;
    }

}
