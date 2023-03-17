package com.github.houbb.validator.core.api.result;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.support.instance.impl.Instances;
import com.github.houbb.validator.api.api.result.IResult;
import com.github.houbb.validator.api.api.result.IResultHandler;

/**
 * 结果处理工具类
 * @author binbin.hou
 * @since 0.3.0
 */
@ThreadSafe
public final class ResultHandlers {

    /**
     * @since 0.2.0
     */
    private ResultHandlers(){}

    /**
     * 返回简单结果
     * @return 简单结果处理类
     * @since 0.2.0
     */
    public static IResultHandler<IResult> simple() {
        return Instances.singleton(SimpleResultHandler.class);
    }

    /**
     * 返回详细结果
     * @return 简单结果处理类
     * @since 0.2.0
     */
    public static IResultHandler<IResult> detail() {
        return Instances.singleton(DetailResultHandler.class);
    }


}
