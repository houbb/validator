package com.github.houbb.validator.api.api.fail;

import com.github.houbb.validator.api.constant.enums.FailTypeEnum;

/**
 * 失败处理接口
 * @author binbin.hou
 * @since 0.1.0
 */
public interface IFail {

    /**
     * 失败类型
     * @param context 上下文
     * @return 失败类型枚举
     * @since 0.1.0
     */
    FailTypeEnum fail(final IFailContext context);

}
