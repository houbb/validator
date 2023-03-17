package com.github.houbb.validator.core.api.condition.chain;

import com.github.houbb.heaven.support.pipeline.Pipeline;
import com.github.houbb.heaven.util.lang.ObjectUtil;
import com.github.houbb.heaven.util.util.ArrayUtil;
import com.github.houbb.validator.api.api.condition.ICondition;
import com.github.houbb.validator.api.api.condition.IConditionContext;

/**
 * 条件链工具类
 * @author binbin.hou
 * @since 0.2.0
 */
public final class ConditionChains {

    private ConditionChains() {
    }

    /**
     * 生成对应的条件规则链
     * （1）会跳过为 null 的约束条件
     * @param conditions 条件实现
     * @return 条件实现
     * @since 0.2.0
     */
    public static ICondition chain(final ICondition ... conditions) {
        return new AbstractConditionChain() {
            @Override
            void init(Pipeline<ICondition> pipeline, IConditionContext context) {
                if(ArrayUtil.isNotEmpty(conditions)) {
                    for(ICondition condition : conditions) {
                        if(ObjectUtil.isNull(condition)) {
                            continue;
                        }
                        pipeline.addLast(condition);
                    }
                }
            }
        };
    }

}
