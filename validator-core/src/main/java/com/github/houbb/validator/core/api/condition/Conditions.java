package com.github.houbb.validator.core.api.condition;

import com.github.houbb.heaven.util.common.ArgUtil;
import com.github.houbb.validator.api.api.condition.ICondition;

/**
 * 条件工具类
 * @author binbin.hou
 * @since 0.3.0
 */
public final class Conditions {

    private Conditions(){}

    /**
     * 永远为真
     * @since 0.0.6
     * @return 条件实现
     */
    public static ICondition alwaysTrue() {
        return new AlwaysTrueCondition();
    }

    /**
     * 永远为假
     * @since 0.0.6
     * @return 条件实现
     */
    public static ICondition alwaysFalse() {
        return new AlwaysFalseCondition();
    }

    /**
     * 分组条件
     * @since 0.2.0
     * @return 条件实现
     */
    public static ICondition group() {
        return new GroupCondition();
    }

    /**
     * 预期相等
     * @param expect 预期值
     * @param fieldName 字段名称
     * @return 条件
     * @since 0.2.0
     */
    public static ICondition equals(final String expect, final String fieldName) {
        ArgUtil.notNull(expect, "expect");
        return new EqualsCondition(expect, fieldName);
    }

    /**
     * 预期相等
     * @param expect 预期值
     * @return 条件
     * @since 0.2.0
     */
    public static ICondition equals(final String expect) {
        return equals(expect, null);
    }

    /**
     * 预期不相等
     * @param expect 预期值
     * @param fieldName 字段名称
     * @return 条件
     * @since 0.2.0
     */
    public static ICondition notEquals(final Object expect, final String fieldName) {
        ArgUtil.notNull(expect, "expect");
        return new NotEqualsCondition(expect, fieldName);
    }

    /**
     * 预期不相等
     * @param expect 预期值
     * @return 条件
     * @since 0.2.0
     */
    public static ICondition notEquals(final Object expect) {
        return notEquals(expect, null);
    }

}
