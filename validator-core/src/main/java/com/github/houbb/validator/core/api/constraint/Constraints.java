package com.github.houbb.validator.core.api.constraint;

import com.github.houbb.heaven.util.common.ArgUtil;
import com.github.houbb.validator.api.api.constraint.IConstraint;

/**
 * 默认约束实现类
 * @author binbin.hou
 * @since 0.1.1
 */
public final class Constraints {

    private Constraints(){}

    /**
     * 全部相等约束
     * （1）当前验证字段值和其他字段值全部相等
     * @param otherFields 其他字段名称
     * @return 约束实现
     * @since 0.1.1
     * @see com.github.houbb.validator.core.annotation.constraint.AllEquals 全部相等注解
     */
    public static IConstraint allEqualsConstraint(String ... otherFields) {
        ArgUtil.notEmpty(otherFields, "otherFields");

        return new AllEqualsConstraint(otherFields);
    }

    /**
     * 拥有不为空的值约束
     * （1）当前字段和其他指定字段，至少有一个为空的约束
     * @param otherFields 其他字段
     * @return 约束类
     * @since 0.1.1
     * @see com.github.houbb.validator.core.annotation.constraint.HasNotNull 至少一个不为空
     */
    public static IConstraint hasNotNullConstraint(String ... otherFields) {
        ArgUtil.notEmpty(otherFields, "otherFields");
        return new HasNotNullConstraint(otherFields);
    }

    /**
     * 枚举范围内约束
     * （1）当前值必须在枚举类对应枚举的 toString() 列表中。
     * @param enumClass 枚举类，不可为空
     * @return 约束类
     * @since 0.1.1
     * @see com.github.houbb.validator.core.annotation.constraint.EnumRanges 枚举类指定范围注解
     */
    public static IConstraint enumRangesConstraint(final Class<? extends Enum> enumClass) {
        ArgUtil.notNull(enumClass, "enumClass");

        return new EnumRangesConstraint(enumClass);
    }

    /**
     * 值在指定范围内约束
     * （1）这里为了和注解保持一致性，暂时只支持 String
     * @param strings 对象范围
     * @return 约束类
     * @since 0.1.1
     * @see com.github.houbb.validator.core.annotation.constraint.Ranges String 指定范围内注解
     */
    public static IConstraint rangesConstraint(String ... strings) {
        ArgUtil.notEmpty(strings, "strings");

        return new RangesConstraint(strings);
    }

}
