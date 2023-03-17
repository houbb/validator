package com.github.houbb.validator.core.jsr.constraint;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.util.lang.ObjectUtil;
import com.github.houbb.heaven.util.lang.reflect.ClassTypeUtil;
import com.github.houbb.validator.api.api.constraint.IConstraintContext;
import com.github.houbb.validator.core.api.constraint.AbstractConstraint;
import com.github.houbb.validator.core.constant.ContextAttrKeyConst;
import com.github.houbb.validator.core.i18n.I18N;
import com.github.houbb.validator.core.jsr.util.JsrSupportClassUtil;

import java.util.Collection;
import java.util.List;
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
public class SizeConstraint extends AbstractConstraint {

    /**
     * 最小值
     * size the element must be higher or equal to
     * @since 0.0.3
     */
    private final int min;

    /**
     * 最大值
     * size the element must be lower or equal to
     * @since 0.0.3
     */
    private final int max;

    public SizeConstraint(int min, int max) {
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
        final int size = actualSize(object);
        boolean pass = sizeCheck(size);

        // 设置具体的属性信息
        context.putAttr(ContextAttrKeyConst.SYS_CONSTRAINT_CTX_SIZE, size);

        return pass;
    }

    @Override
    protected List<Class> getSupportClassList() {
        return JsrSupportClassUtil.getSizeSupportClassList();
    }

    /**
     * 大小检查
     * @param size 大小
     * @return 是否满足大小
     * @since 0.0.3
     */
    private boolean sizeCheck(final int size) {
        return size >= min && size <= max;
    }

    @Override
    protected String expectValue(final IConstraintContext context) {
        return String.format(I18N.get(I18N.Key.SIZE_MUST_BE_IN), min, max);
    }

    @Override
    protected String actualValue(IConstraintContext context) {
        int actualSize = (int) context.getAttr(ContextAttrKeyConst.SYS_CONSTRAINT_CTX_SIZE);
        return actualSize+"";
    }

    /**
     * 计算对应的大小
     * （1）此处不用判空，因为 null 不会走到这里
     * @param value 实际值
     * @return 对应的 size
     * @since 0.0.3
     */
    private int actualSize(final Object value) {
        //类型判断，根据概率 CharSequence > collection > map > array
        if(value instanceof CharSequence) {
            CharSequence string = (CharSequence)value;
            return string.length();
        }
        if(value instanceof Collection) {
            Collection collection = (Collection)value;
            return collection.size();
        }
        if(value instanceof Map) {
            Map map = (Map)value;
            return map.size();
        }
        if(ClassTypeUtil.isArray(value.getClass())) {
            Object[] array = (Object[])value;
            return array.length;
        }
        // 这里按理说也不应该走到
        return 0;
    }

}
