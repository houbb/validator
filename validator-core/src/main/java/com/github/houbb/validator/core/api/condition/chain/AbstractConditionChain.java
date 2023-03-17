package com.github.houbb.validator.core.api.condition.chain;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.support.pipeline.Pipeline;
import com.github.houbb.heaven.support.pipeline.impl.DefaultPipeline;
import com.github.houbb.validator.api.api.condition.ICondition;
import com.github.houbb.validator.api.api.condition.IConditionContext;

import java.util.List;

/**
 * 抽象条件调用链实现
 * @author binbin.hou
 * @since 0.2.0
 */
@ThreadSafe
abstract class AbstractConditionChain implements ICondition {

    /**
     * 初始化监听器列表
     * @param pipeline 泳道
     * @param context 重试信息
     * @since 0.2.0
     */
    abstract void init(final Pipeline<ICondition> pipeline,
                       final IConditionContext context);

    @Override
    public boolean condition(IConditionContext conditionContext) {
        Pipeline<ICondition> pipeline = new DefaultPipeline<>();
        this.init(pipeline, conditionContext);

        List<ICondition> conditionList = pipeline.list();

        for(ICondition condition : conditionList) {
            boolean result = condition.condition(conditionContext);
            if(!result) {
                return false;
            }
        }
        return true;
    }

}
