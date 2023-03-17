package com.github.houbb.validator.core.api.constraint.chain;

import com.github.houbb.heaven.support.pipeline.Pipeline;
import com.github.houbb.heaven.util.common.ArgUtil;
import com.github.houbb.validator.api.api.constraint.IConstraint;
import com.github.houbb.validator.api.api.constraint.IConstraintContext;

/**
 * 约束链工具类
 * @author binbin.hou
 * @since 0.2.0
 */
public final class ConstraintChains {

    private ConstraintChains() {
    }

    /**
     * 生成对应的约束规则链
     * @param constraints 约束实现
     * @return 约束实现
     * @since 0.2.0
     */
    public static IConstraint chain(final IConstraint ... constraints) {
        ArgUtil.notEmpty(constraints, "constraints");

        return new AbstractConstraintChain() {
            @Override
            void init(Pipeline<IConstraint> pipeline, IConstraintContext context) {
                for(IConstraint constraint : constraints) {
                    pipeline.addLast(constraint);
                }
            }
        };
    }

}
