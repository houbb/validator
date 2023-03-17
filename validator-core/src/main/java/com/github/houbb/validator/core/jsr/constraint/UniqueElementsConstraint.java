package com.github.houbb.validator.core.jsr.constraint;

import com.github.houbb.heaven.annotation.CommonEager;
import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.util.lang.ObjectUtil;
import com.github.houbb.heaven.util.lang.reflect.ClassTypeUtil;
import com.github.houbb.validator.api.api.constraint.IConstraintContext;
import com.github.houbb.validator.core.api.constraint.AbstractConstraint;
import com.github.houbb.validator.core.jsr.util.JsrSupportClassUtil;

import java.util.*;

/**
 * 保证元素唯一
 *
 * @see java.lang.reflect.Array#getLength(Object)  数组
 * @see CharSequence#length()
 * @see Collection#size()
 * @see Map#size()
 *
 * @author binbin.hou
 * @since 0.2.0
 * @see org.hibernate.validator.constraints.UniqueElements
 */
@ThreadSafe
public class UniqueElementsConstraint extends AbstractConstraint {

    @Override
    protected boolean pass(final IConstraintContext context, final Object value) {
        if(ObjectUtil.isNull(value)) {
            return true;
        }

        return isValid(value);
    }

    @Override
    protected List<Class> getSupportClassList() {
        return JsrSupportClassUtil.getUkElementsSupportClassList();
    }

    /**
     * 计算对应的大小
     * （1）此处不用判空，因为 null 不会走到这里
     * @param value 实际值
     * @return 对应的 size
     * @since 0.0.3
     */
    @CommonEager
    @SuppressWarnings("all")
    private boolean isValid(final Object value) {
        //类型判断，根据概率 CharSequence > collection > map > array
        if(value instanceof CharSequence) {
            CharSequence string = (CharSequence)value;
            Set<Character> characterSet = new HashSet<>();
            for(int i = 0; i < string.length(); i++) {
                char c = string.charAt(i);
                if(characterSet.contains(c)) {
                    return false;
                }
                characterSet.add(c);
            }
            return true;
        }

        if(value instanceof Collection) {
            Collection collection = (Collection)value;
            Set set = new HashSet(collection);
            return collection.size() == set.size();
        }

        if(value instanceof Map) {
            Map map = (Map)value;
            Set set = new HashSet();
            for(Object entry : map.entrySet()) {
                if(set.contains(entry)) {
                    return false;
                }
            }
            return true;
        }

        if(ClassTypeUtil.isArray(value.getClass())) {
            Object[] array = (Object[])value;
            Set set = new HashSet();
            for(Object entry : array) {
                if(set.contains(entry)) {
                    return false;
                }
            }
            return true;
        }

        // 这里按理说也不应该走到
        return false;
    }

}
