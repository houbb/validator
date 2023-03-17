package com.github.houbb.validator.api.api.condition;

/**
 * 生效的条件
 * @author binbin.hou
 * @since 0.1.0
 */
public interface ICondition {

    /**
     * 条件生效的结果
     * @param conditionContext 条件上下文
     * @return 结果
     */
    boolean condition(final IConditionContext conditionContext);

}
