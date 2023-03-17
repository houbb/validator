package com.github.houbb.validator.core.constant;

/**
 * 属性 key
 * @author binbin.hou
 * @since 0.2.0
 */
public final class ContextAttrKeyConst {

    private ContextAttrKeyConst(){}

    /**
     * 系统前缀
     * （1）可以设置角色，系统内置为 system。其他用户默认使用 default 角色。
     * （2）只有用户角色拥有设置 sys 内置的权利。
     * （3）权限的控制可以简单的抽离一个工具类即可。
     * @since 0.2.0
     */
    public static final String SYS_PREFIX = "@_SYS_";

    /**
     * 系统约束上下文预期值 key
     * （1）@_SYS 作为占用关键字。禁止用户使用。
     * @since 0.2.0
     */
    public static final String SYS_CONSTRAINT_CTX_EXPECT_VALUE = "@_SYS_CONSTRAINT_CTX_EXPECT_VALUE";

    /**
     * 系统内置整数位数
     * @since 0.2.0
     */
    public static final String SYS_CONSTRAINT_CTX_INTEGER_DIGITS = "@_SYS_CONSTRAINT_CTX_INTEGER_DIGITS";

    /**
     * 系统内置小数位数
     * @since 0.2.0
     */
    public static final String SYS_CONSTRAINT_CTX_FRACTION_DIGITS = "@_SYS_CONSTRAINT_CTX_FRACTION_DIGITS";

    /**
     * 系统内置 size 信息
     * @since 0.2.0
     */
    public static final String SYS_CONSTRAINT_CTX_SIZE = "@_SYS_CONSTRAINT_CTX_SIZE";

}
