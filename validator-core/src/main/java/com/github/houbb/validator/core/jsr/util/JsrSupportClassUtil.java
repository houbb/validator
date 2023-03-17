package com.github.houbb.validator.core.jsr.util;

import com.github.houbb.heaven.util.guava.Guavas;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

/**
 * 支持的数据类型
 * （1）为了不让这个类被外部使用，暂时放在这里。
 *
 * @author binbin.hou
 * @since 0.3.0
 */
public final class JsrSupportClassUtil {

    private JsrSupportClassUtil(){}

    /**
     * 支持的类型列表
     * @since 0.3.0
     */
    private static final List<Class> DECIMAL_MAX_MIN_SUPPORT_CLASS_LIST;

    /**
     * 时间过去未来支持的类型列表
     * @since 0.3.0
     */
    private static final List<Class> PAST_FUTURE_SUPPORT_CLASS_LIST;

    /**
     * 位数类型列表
     * @since 0.3.0
     */
    private static final List<Class> DIGITS_SUPPORT_CLASS_LIST;

    /**
     * SIZE 支持类型列表
     * @since 0.3.0
     */
    private static final List<Class> SIZE_SUPPORT_CLASS_LIST;

    /**
     * TRUE/FALSE 支持类型列表
     * @since 0.3.0
     */
    private static final List<Class> ASSERT_TRUE_FALSE_SUPPORT_CLASS_LIST;

    /**
     * UK_ELEMENTS 支持类型列表
     * @since 0.3.0
     */
    private static final List<Class> UK_ELEMENTS_SUPPORT_CLASS_LIST;

    static {
        DECIMAL_MAX_MIN_SUPPORT_CLASS_LIST = Guavas.newArrayList(11);
        DECIMAL_MAX_MIN_SUPPORT_CLASS_LIST.add(CharSequence.class);
        DECIMAL_MAX_MIN_SUPPORT_CLASS_LIST.add(BigDecimal.class);
        DECIMAL_MAX_MIN_SUPPORT_CLASS_LIST.add(BigInteger.class);
        DECIMAL_MAX_MIN_SUPPORT_CLASS_LIST.add(int.class);
        DECIMAL_MAX_MIN_SUPPORT_CLASS_LIST.add(Integer.class);
        DECIMAL_MAX_MIN_SUPPORT_CLASS_LIST.add(short.class);
        DECIMAL_MAX_MIN_SUPPORT_CLASS_LIST.add(Short.class);
        DECIMAL_MAX_MIN_SUPPORT_CLASS_LIST.add(long.class);
        DECIMAL_MAX_MIN_SUPPORT_CLASS_LIST.add(Long.class);
        DECIMAL_MAX_MIN_SUPPORT_CLASS_LIST.add(byte.class);
        DECIMAL_MAX_MIN_SUPPORT_CLASS_LIST.add(Byte.class);

        PAST_FUTURE_SUPPORT_CLASS_LIST = Guavas.newArrayList(2);
        PAST_FUTURE_SUPPORT_CLASS_LIST.add(Date.class);
        PAST_FUTURE_SUPPORT_CLASS_LIST.add(Calendar.class);

        DIGITS_SUPPORT_CLASS_LIST = Guavas.newArrayList(11);
        DIGITS_SUPPORT_CLASS_LIST.add(CharSequence.class);
        DIGITS_SUPPORT_CLASS_LIST.add(BigDecimal.class);
        DIGITS_SUPPORT_CLASS_LIST.add(BigInteger.class);
        DIGITS_SUPPORT_CLASS_LIST.add(int.class);
        DIGITS_SUPPORT_CLASS_LIST.add(Integer.class);
        DIGITS_SUPPORT_CLASS_LIST.add(short.class);
        DIGITS_SUPPORT_CLASS_LIST.add(Short.class);
        DIGITS_SUPPORT_CLASS_LIST.add(long.class);
        DIGITS_SUPPORT_CLASS_LIST.add(Long.class);
        DIGITS_SUPPORT_CLASS_LIST.add(byte.class);
        DIGITS_SUPPORT_CLASS_LIST.add(Byte.class);

        SIZE_SUPPORT_CLASS_LIST = Guavas.newArrayList(4);
        SIZE_SUPPORT_CLASS_LIST.add(CharSequence.class);
        SIZE_SUPPORT_CLASS_LIST.add(Collection.class);
        SIZE_SUPPORT_CLASS_LIST.add(Map.class);
        SIZE_SUPPORT_CLASS_LIST.add(Array.class);

        ASSERT_TRUE_FALSE_SUPPORT_CLASS_LIST = Guavas.newArrayList(2);
        ASSERT_TRUE_FALSE_SUPPORT_CLASS_LIST.add(boolean.class);
        ASSERT_TRUE_FALSE_SUPPORT_CLASS_LIST.add(Boolean.class);

        UK_ELEMENTS_SUPPORT_CLASS_LIST = Guavas.newArrayList(4);
        UK_ELEMENTS_SUPPORT_CLASS_LIST.add(CharSequence.class);
        UK_ELEMENTS_SUPPORT_CLASS_LIST.add(Collection.class);
        UK_ELEMENTS_SUPPORT_CLASS_LIST.add(Map.class);
        UK_ELEMENTS_SUPPORT_CLASS_LIST.add(Array.class);
    }

    /**
     * 获取 {@link javax.validation.constraints.DecimalMin} 和 {@link javax.validation.constraints.DecimalMax}
     * 支持的数据类型列表
     * @return 列表信息
     * @since 0.3.0
     */
    public static List<Class> getDecimalMaxMinSupportClassList() {
        return DECIMAL_MAX_MIN_SUPPORT_CLASS_LIST;
    }

    /**
     * 获取 {@link javax.validation.constraints.Future} 和 {@link javax.validation.constraints.Past}
     * 支持的数据类型列表
     * @return 列表信息
     * @since 0.3.0
     */
    public static List<Class> getPastFutureSupportClassList() {
        return PAST_FUTURE_SUPPORT_CLASS_LIST;
    }

    /**
     * 获取 {@link javax.validation.constraints.Digits} 支持的数据类型
     * @return 列表信息
     * @since 0.3.0
     */
    public static List<Class> getDigitsSupportClassList() {
        return DIGITS_SUPPORT_CLASS_LIST;
    }

    /**
     * 获取 {@link javax.validation.constraints.Size} 支持的数据类型
     * @return 列表信息
     * @since 0.3.0
     */
    public static List<Class> getSizeSupportClassList() {
        return SIZE_SUPPORT_CLASS_LIST;
    }

    /**
     * 获取 {@link javax.validation.constraints.AssertFalse} 支持的数据类型
     * 获取 {@link javax.validation.constraints.AssertTrue} 支持的数据类型
     * @return 列表信息
     * @since 0.3.0
     */
    public static List<Class> getAssertTrueFalseSupportClassList() {
        return ASSERT_TRUE_FALSE_SUPPORT_CLASS_LIST;
    }

    /**
     * 获取不重复的元素支持类型
     * @return 结果
     * @since 0.2.0
     */
    public static List<Class> getUkElementsSupportClassList() {
        return UK_ELEMENTS_SUPPORT_CLASS_LIST;
    }

}
