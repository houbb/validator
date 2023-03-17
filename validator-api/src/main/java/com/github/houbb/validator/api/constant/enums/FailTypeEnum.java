package com.github.houbb.validator.api.constant.enums;

/**
 * 失败类型枚举
 * @author binbin.hou
 * @since 0.1.0
 */
public enum FailTypeEnum {

    /**
     * 快速失败
     * 遇到失败之后，直接返回。
     */
    FAIL_FAST,

    /**
     * 失败之后继续进行验证
     */
    FAIL_OVER,
    ;
}
