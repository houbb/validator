package com.github.houbb.validator.core.api.constraint;

import com.github.houbb.heaven.util.common.ArgUtil;
import com.github.houbb.validator.api.api.constraint.IConstraint;
import com.github.houbb.validator.core.annotation.constraint.ChinaPhone;
import com.github.houbb.validator.core.jsr.constraint.*;

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
     */
    public static IConstraint allEquals(String ... otherFields) {
        ArgUtil.notEmpty(otherFields, "otherFields");

        return new AllEqualsConstraint(otherFields);
    }

    /**
     * 拥有不为空的值约束
     * （1）当前字段和其他指定字段，至少有一个为空的约束
     * @param otherFields 其他字段
     * @return 约束类
     * @since 0.1.1
     */
    public static IConstraint hasNotNull(String ... otherFields) {
        ArgUtil.notEmpty(otherFields, "otherFields");
        return new HasNotNullConstraint(otherFields);
    }

    /**
     * 枚举范围内约束
     * （1）当前值必须在枚举类对应枚举的 toString() 列表中。
     * @param enumClass 枚举类，不可为空
     * @return 约束类
     * @since 0.1.1
     */
    public static IConstraint enumRanges(final Class<? extends Enum> enumClass) {
        ArgUtil.notNull(enumClass, "enumClass");

        return new EnumRangesConstraint(enumClass);
    }

    /**
     * 值在指定范围内约束
     * （1）这里为了和注解保持一致性，暂时只支持 String
     * @param strings 对象范围
     * @return 约束类
     * @since 0.1.1
     */
    public static IConstraint ranges(String ... strings) {
        ArgUtil.notEmpty(strings, "strings");

        return new RangesConstraint(strings);
    }

    /**
     * @return 为 true 约束条件
     * @since 0.0.3
     */
    public static IConstraint assertTrue() {
        return new AssertTrueConstraint();
    }

    /**
     * @return 为 false 约束条件
     * @since 0.0.3
     */
    public static IConstraint assertFalse() {
        return new AssertFalseConstraint();
    }

    /**
     * @return 为 null 约束条件
     * @since 0.0.3
     */
    public static IConstraint nulls() {
        return new NullConstraint();
    }

    /**
     * @return 不为 null 约束条件
     * @since 0.0.3
     */
    public static IConstraint notNull() {
        return new NotNullConstraint();
    }

    /**
     * 是否在当前时间之前约束条件
     * @return 约束条件
     * @since 0.0.3
     */
    public static IConstraint past() {
        return past(new Date());
    }

    /**
     * 是否在指定时间之前约束条件
     * @param date 阈值
     * @return 约束条件
     * @since 0.0.3
     */
    public static IConstraint past(final Date date) {
        return new PastConstraint(date);
    }

    /**
     * 是否在当前时间之前约束条件，包含当前
     * @return 约束条件
     * @since 0.5.0
     */
    public static IConstraint pastOrPresent() {
        return pastOrPresent(new Date());
    }

    /**
     * 是否在当前时间之前约束条件，包含当前
     * @param date 日期
     * @return 约束条件
     * @since 0.5.0
     */
    public static IConstraint pastOrPresent(final Date date) {
        return new PastOrPresentConstraint(date);
    }

    /**
     * 是否在当前时间之后约束条件
     * @return 约束条件
     * @since 0.0.3
     */
    public static IConstraint future() {
        return future(new Date());
    }

    /**
     * 是否在指定时间之后约束条件
     * @param date 阈值
     * @return 约束条件
     * @since 0.0.3
     */
    public static IConstraint future(final Date date) {
        return new FutureConstraint(date);
    }

    /**
     * 是否在当前时间之后约束条件，包含当前
     * @return 约束条件
     * @since 0.5.0
     */
    public static IConstraint futureOrPresent() {
        return futureOrPresent(new Date());
    }

    /**
     * 是否在当前时间之后约束条件，包含当前
     * @param date 日期
     * @return 约束条件
     * @since 0.5.0
     */
    public static IConstraint futureOrPresent(Date date) {
        return new FutureOrPresentConstraint(date);
    }

    /**
     *
     * @param regex 正则表达式
     * @return 约束条件
     * @since 0.0.3
     */
    public static IConstraint pattern(final String regex) {
        return new PatternConstraint(regex);
    }

    /**
     *
     * @param min 最小值
     * @param max 最大值
     * @return 约束条件
     * @since 0.0.3
     */
    public static IConstraint size(final int min, final int max) {
        return new SizeConstraint(min, max);
    }

    /**
     * 最大值默认为 {@link Integer#MAX_VALUE}
     * @param min 最小值
     * @return 约束条件
     * @since 0.1.2
     */
    public static IConstraint sizeMin(final int min) {
        return new SizeConstraint(min, Integer.MAX_VALUE);
    }

    /**
     * 最小值默认为 0
     * @param max 最大值
     * @return 约束条件
     * @since 0.1.2
     */
    public static IConstraint sizeMax(final int max) {
        return new SizeConstraint(0, max);
    }

    /**
     * 位数约束
     * @param integer 整数
     * @param fraction 精度
     * @return 约束条件
     * @since 0.0.3
     */
    public static IConstraint digits(final int integer, final int fraction) {
        return new DigitsConstraint(integer, fraction);
    }

    /**
     * 位数约束
     * @param integer 整数
     * @return 约束条件
     * @since 0.0.3
     */
    public static IConstraint digits(final int integer) {
        return new DigitsConstraint(integer);
    }

    /**
     *
     * @param charSequence 阈值
     * @return 约束条件
     * @since 0.0.3
     */
    public static IConstraint decimalMax(final CharSequence charSequence) {
        return new DecimalMaxConstraint(charSequence);
    }

    /**
     *
     * @param inclusive 是否包含
     * @param charSequence 阈值
     * @return 约束条件
     * @since 0.0.3
     */
    public static IConstraint decimalMax(final boolean inclusive, final CharSequence charSequence) {
        return new DecimalMaxConstraint(inclusive, charSequence);
    }

    /**
     *
     * @param charSequence 阈值
     * @return 约束条件
     * @since 0.0.3
     */
    public static IConstraint decimalMin(final CharSequence charSequence) {
        return new DecimalMinConstraint(charSequence);
    }

    /**
     *
     * @param inclusive  是否包含
     * @param charSequence 阈值
     * @return 约束条件
     * @since 0.0.3
     */
    public static IConstraint decimalMin(final boolean inclusive, final CharSequence charSequence) {
        return new DecimalMinConstraint(inclusive, charSequence);
    }

    /**
     * 最小约束条件
     * @param inclusive 是否相等
     * @param expect 阈值
     * @return 约束条件
     * @since 0.0.3
     */
    public static IConstraint min(final boolean inclusive, final long expect) {
        return new MinConstraint(inclusive, expect);
    }

    /**
     * 最小约束条件
     * @param expect 阈值
     * @return 约束条件
     * @since 0.0.3
     */
    public static IConstraint min(final long expect) {
        return new MinConstraint(expect);
    }

    /**
     * 最大约束条件
     * @param inclusive 是否相等
     * @param expect 阈值
     * @return 约束条件
     * @since 0.0.3
     */
    public static IConstraint max(final boolean inclusive, final long expect) {
        return new MaxConstraint(inclusive, expect);
    }

    /**
     * 最大约束条件
     * @param expect 阈值
     * @return 约束条件
     * @since 0.0.3
     */
    public static IConstraint max(final long expect) {
        return new MaxConstraint(expect);
    }

    /**
     * 不能为空格
     * @return 空格
     * @since 0.2.0
     */
    public static IConstraint notBlank() {
        return new NotBlankConstraint();
    }

    /**
     * 不能为空
     * @return 为空
     * @since 0.2.0
     */
    public static IConstraint notEmpty() {
        return new NotEmptyConstraint();
    }

    /**
     * 长度约束
     * @param min 最小值
     * @param max 最大值
     * @return 长度约束
     * @since 0.2.0
     */
    public static IConstraint length(final int min, final int max) {
        return new LengthConstraint(min, max);
    }

    /**
     * cnpj约束
     * @return 长度约束
     * @since 0.2.0
     */
    public static IConstraint cnpj() {
        return new CNPJConstraint();
    }

    /**
     * CPF 约束
     * @return 长度约束
     * @since 0.2.0
     */
    public static IConstraint cpf() {
        return new CPFConstraint();
    }

    /**
     * URL 约束
     * @return 长度约束
     * @since 0.2.0
     * @see org.hibernate.validator.constraints.URL
     */
    public static IConstraint url() {
        return new URLConstraint();
    }

    /**
     * EMAIL 约束
     * @return 长度约束
     * @since 0.2.0
     */
    public static IConstraint email() {
        return new EmailConstraint();
    }

    /**
     * uniqueElements 约束
     * @return 长度约束
     * @since 0.2.0
     */
    public static IConstraint uniqueElements() {
        return new UniqueElementsConstraint();
    }

    /**
     * Range 约束
     * @param max 最大值
     * @param min 最小值
     * @return 长度约束
     * @since 0.2.0
     */
    public static IConstraint range(long min, long max) {
        return new RangeConstraint(min, max);
    }

    /**
     * negative 约束
     * @return 约束
     * @since 0.5.0
     */
    public static IConstraint negative() {
        return new NegativeConstraint();
    }

    /**
     * NegativeOrZero 约束
     * @return 约束
     * @since 0.5.0
     */
    public static IConstraint negativeOrZero() {
        return new NegativeOrZeroConstraint();
    }

    /**
     * Positive 约束
     * @return 约束
     * @since 0.5.0
     */
    public static IConstraint positive() {
        return new PositiveConstraint();
    }

    /**
     * PositiveOrZero 约束
     * @return 约束
     * @since 0.5.0
     */
    public static IConstraint positiveOrZero() {
        return new PositiveOrZeroConstraint();
    }

    /**
     * 中国身份证
     * @param checkDigit 是否校验最后一位合法性
     * @return 约束
     * @since 0.6.0
     */
    public static IConstraint chinaIdNo(boolean checkDigit) {
        return new ChinaIdNoConstraint();
    }

    /**
     * 中国身份证
     * @return 约束
     * @since 0.6.0
     */
    public static IConstraint chinaIdNo() {
        return chinaIdNo(true);
    }

    /**
     * 中国手机号
     * @return 约束
     * @since 0.6.0
     */
    public static IConstraint chinaPhone() {
        return new ChinaPhoneConstraint();
    }

}
