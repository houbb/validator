package com.github.houbb.validator.core.api.fail;

import com.github.houbb.heaven.support.instance.impl.Instances;
import com.github.houbb.validator.api.api.fail.IFail;

/**
 * 失败处理相关工具类
 * @author binbin.hou
 * @since 0.2.0
 */
public final class Fails {

    private Fails(){}

    /**
     * 返回失败之后继续验证示例
     * @return 失败实现
     * @since 0.2.0
     */
    public static IFail failOver() {
        return new FailOver();
    }

    /**
     * 返回快速失败示例
     * @return 快速失败
     * @since 0.2.0
     */
    public static IFail failFast() {
        return new FailFast();
    }

}
