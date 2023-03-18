package com.github.houbb.validator.core.api.constraint;

import com.github.houbb.heaven.util.common.ArgUtil;
import com.github.houbb.validator.api.api.constraint.IConstraint;
import com.github.houbb.validator.core.jsr.constraint.*;
import com.github.houbb.validator.core.jsr.constraint.annotation.AtAssertFalseConstraint;
import com.github.houbb.validator.core.jsr.constraint.annotation.AtAssertTrueConstraint;

import java.util.Calendar;
import java.util.Date;

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

    /**
     * @return 为 true 约束条件
     * @since 0.0.3
     */
    public static IConstraint assertTrueConstraint() {
        return new AssertTrueConstraint();
    }

    /**
     * @return 为 false 约束条件
     * @since 0.0.3
     */
    public static IConstraint assertFalseConstraint() {
        return new AssertFalseConstraint();
    }

    /**
     * @return 为 null 约束条件
     * @since 0.0.3
     */
    public static IConstraint nullConstraint() {
        return new NullConstraint();
    }

    /**
     * @return 不为 null 约束条件
     * @since 0.0.3
     */
    public static IConstraint notNullConstraint() {
        return new NotNullConstraint();
    }

    /**
     * 是否在当前时间之前约束条件
     * @return 约束条件
     * @since 0.0.3
     */
    public static IConstraint pastConstraint() {
        return new PastConstraint(new Date());
    }

    /**
     * 是否在指定时间之前约束条件
     * @param date 阈值
     * @return 约束条件
     * @since 0.0.3
     */
    public static IConstraint pastConstraint(final Date date) {
        return new PastConstraint(date);
    }

    /**
     * 是否在指定时间之前约束条件
     * @param date 阈值
     * @return 约束条件
     * @since 0.0.3
     */
    public static IConstraint pastConstraint(final Calendar date) {
        return new PastConstraint(date);
    }

    /**
     * 是否在当前时间之后约束条件
     * @return 约束条件
     * @since 0.0.3
     */
    public static IConstraint futureConstraint() {
        return new FutureConstraint(new Date());
    }

    /**
     * 是否在指定时间之后约束条件
     * @param date 阈值
     * @return 约束条件
     * @since 0.0.3
     */
    public static IConstraint futureConstraint(final Date date) {
        return new FutureConstraint(date);
    }

    /**
     * 是否在指定时间之后约束条件
     * @param date 阈值
     * @return 约束条件
     * @since 0.0.3
     */
    public static IConstraint futureConstraint(final Calendar date) {
        return new FutureConstraint(date);
    }

    /**
     *
     * @param regex 正则表达式
     * @return 约束条件
     * @since 0.0.3
     */
    public static IConstraint patternConstraint(final String regex) {
        return new PatternConstraint(regex);
    }

    /**
     *
     * @param min 最小值
     * @param max 最大值
     * @return 约束条件
     * @since 0.0.3
     */
    public static IConstraint sizeConstraint(final int min, final int max) {
        return new SizeConstraint(min, max);
    }

    /**
     * 最大值默认为 {@link Integer#MAX_VALUE}
     * @param min 最小值
     * @return 约束条件
     * @since 0.1.2
     */
    public static IConstraint sizeConstraintMin(final int min) {
        return new SizeConstraint(min, Integer.MAX_VALUE);
    }

    /**
     * 最小值默认为 0
     * @param max 最大值
     * @return 约束条件
     * @since 0.1.2
     */
    public static IConstraint sizeConstraintMax(final int max) {
        return new SizeConstraint(0, max);
    }

    /**
     * 位数约束
     * @param integer 整数
     * @param fraction 精度
     * @return 约束条件
     * @since 0.0.3
     */
    public static IConstraint digitsConstraint(final int integer, final int fraction) {
        return new DigitsConstraint(integer, fraction);
    }

    /**
     * 位数约束
     * @param integer 整数
     * @return 约束条件
     * @since 0.0.3
     */
    public static IConstraint digitsConstraint(final int integer) {
        return new DigitsConstraint(integer);
    }

    /**
     *
     * @param charSequence 阈值
     * @return 约束条件
     * @since 0.0.3
     */
    public static IConstraint decimalMaxConstraint(final CharSequence charSequence) {
        return new DecimalMaxConstraint(charSequence);
    }

    /**
     *
     * @param inclusive 是否包含
     * @param charSequence 阈值
     * @return 约束条件
     * @since 0.0.3
     */
    public static IConstraint decimalMaxConstraint(final boolean inclusive, final CharSequence charSequence) {
        return new DecimalMaxConstraint(inclusive, charSequence);
    }

    /**
     *
     * @param charSequence 阈值
     * @return 约束条件
     * @since 0.0.3
     */
    public static IConstraint decimalMinConstraint(final CharSequence charSequence) {
        return new DecimalMinConstraint(charSequence);
    }

    /**
     *
     * @param inclusive  是否包含
     * @param charSequence 阈值
     * @return 约束条件
     * @since 0.0.3
     */
    public static IConstraint decimalMinConstraint(final boolean inclusive, final CharSequence charSequence) {
        return new DecimalMinConstraint(inclusive, charSequence);
    }

    /**
     * 最小约束条件
     * @param inclusive 是否相等
     * @param expect 阈值
     * @return 约束条件
     * @since 0.0.3
     */
    public static IConstraint minConstraint(final boolean inclusive, final long expect) {
        return new MinConstraint(inclusive, expect);
    }

    /**
     * 最小约束条件
     * @param expect 阈值
     * @return 约束条件
     * @since 0.0.3
     */
    public static IConstraint minConstraint(final long expect) {
        return new MinConstraint(expect);
    }

    /**
     * 最大约束条件
     * @param inclusive 是否相等
     * @param expect 阈值
     * @return 约束条件
     * @since 0.0.3
     */
    public static IConstraint maxConstraint(final boolean inclusive, final long expect) {
        return new MaxConstraint(inclusive, expect);
    }

    /**
     * 最大约束条件
     * @param expect 阈值
     * @return 约束条件
     * @since 0.0.3
     */
    public static IConstraint maxConstraint(final long expect) {
        return new MaxConstraint(expect);
    }

    /**
     * 不能为空格
     * @return 空格
     * @since 0.2.0
     */
    public static IConstraint notBlankConstraint() {
        return new NotBlankConstraint();
    }

    /**
     * 不能为空
     * @return 为空
     * @since 0.2.0
     */
    public static IConstraint notEmptyConstraint() {
        return new NotEmptyConstraint();
    }

    /**
     * 长度约束
     * @param min 最小值
     * @param max 最大值
     * @return 长度约束
     * @since 0.2.0
     */
    public static IConstraint lengthConstraint(final int min, final int max) {
        return new LengthConstraint(min, max);
    }

    /**
     * cnpj约束
     * @return 长度约束
     * @since 0.2.0
     */
    public static IConstraint cnpjConstraint() {
        return new CNPJConstraint();
    }

    /**
     * CPF 约束
     * @return 长度约束
     * @since 0.2.0
     */
    public static IConstraint cpfConstraint() {
        return new CPFConstraint();
    }

    /**
     * URL 约束
     * @return 长度约束
     * @since 0.2.0
     */
    public static IConstraint urlConstraint() {
        return new URLConstraint();
    }

    /**
     * EMAIL 约束
     * @return 长度约束
     * @since 0.2.0
     */
    public static IConstraint emailConstraint() {
        return new EmailConstraint();
    }

    /**
     * uniqueElements 约束
     * @return 长度约束
     * @since 0.2.0
     */
    public static IConstraint uniqueElementsConstraint() {
        return new UniqueElementsConstraint();
    }

    /**
     * Range 约束
     * @return 长度约束
     * @since 0.2.0
     */
    public static IConstraint rangeConstraint(long min, long max) {
        return new RangeConstraint(min, max);
    }

}
