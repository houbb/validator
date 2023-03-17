package com.github.houbb.validator.core.util;

import com.github.houbb.validator.api.api.fail.IFail;
import com.github.houbb.validator.api.api.result.IResult;
import com.github.houbb.validator.core.api.fail.Fails;
import com.github.houbb.validator.core.bs.ValidBs;

/**
 * 校验工具类
 *
 * @author binbin.hou
 * @since 0.2.0
 */
public final class ValidatorHelper {

    private ValidatorHelper(){}

    /**
     * 全部验证后返回
     * @param object 对象
     * @return 结果
     * @since 0.2.0
     */
    public static IResult failOver(final Object object) {
        return valid(object, Fails.failOver());
    }

    /**
     * 快速验证后返回
     * @param object 对象
     * @return 结果
     * @since 0.2.0
     */
    public static IResult failFast(final Object object) {
        return valid(object, Fails.failFast());
    }

    /**
     * 全部验证后返回-抛出异常
     * @param object 对象
     * @since 0.2.0
     */
    public static void failOverThrow(final Object object) {
        failOver(object).throwsEx();
    }

    /**
     * 快速验证后返回-抛出异常
     * @param object 对象
     * @since 0.2.0
     */
    public static void failFastThrow(final Object object) {
        failFast(object).throwsEx();
    }

    private static IResult valid(final Object object,
                                 final IFail fail) {
        return ValidBs.on(object)
                .fail(fail)
                .valid();
    }

}
