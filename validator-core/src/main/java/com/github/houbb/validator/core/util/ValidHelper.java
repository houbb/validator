package com.github.houbb.validator.core.util;

import com.github.houbb.heaven.util.common.ArgUtil;
import com.github.houbb.validator.api.api.constraint.IConstraint;
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
public final class ValidHelper {

    private ValidHelper(){}

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

    /**
     * 全部验证后返回
     * @param object 对象
     * @param constraint 约束条件
     * @return 结果
     * @since 0.4.0
     */
    public static IResult failOver(final Object object, final IConstraint constraint) {
        return valid(object, constraint, Fails.failOver());
    }

    /**
     * 快速验证后返回
     * @param object 对象
     * @param constraint 约束
     * @return 结果
     * @since 0.4.0
     */
    public static IResult failFast(final Object object,
                                   final IConstraint constraint) {
        return valid(object, constraint, Fails.failFast());
    }

    /**
     * 全部验证后返回-抛出异常
     * @param object 对象
     * @param constraint 约束
     * @since 0.4.0
     */
    public static void failOverThrow(final Object object,
                                     final IConstraint constraint) {
        failOver(object, constraint).throwsEx();
    }

    /**
     * 快速验证后返回-抛出异常
     * @param object 对象
     * @param constraint 约束
     * @since 0.4.0
     */
    public static void failFastThrow(final Object object,
                                     final IConstraint constraint) {
        failFast(object, constraint).throwsEx();
    }

    private static IResult valid(final Object object,
                                 final IConstraint constraint,
                                 final IFail fail) {
        ArgUtil.notNull(constraint, "constraint");
        ArgUtil.notNull(fail, "fail");

        return ValidBs.on(object, constraint)
                .fail(fail)
                .valid();
    }

}
