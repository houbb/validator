package com.github.houbb.validator.core.api.condition;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.util.util.ArrayUtil;
import com.github.houbb.validator.api.api.condition.ICondition;
import com.github.houbb.validator.api.api.condition.IConditionContext;

/**
 * 分组条件验证
 *
 * 只关心当前实现，多个规则采用链式的形式。
 *
 * （1）比较当前 groupCondition 信息和 整体的分组信息
 *
 * @author binbin.hou
 * @since 0.2.0
 */
@ThreadSafe
public class GroupCondition implements ICondition {

    @Override
    public boolean condition(IConditionContext conditionContext) {
        final Class[] group = conditionContext.group();
        final Class[] validGroup = conditionContext.validGroup();

        if(ArrayUtil.isEmpty(validGroup)) {
            return true;
        }

        if(ArrayUtil.isEmpty(group)) {
            return false;
        }

        // 遍历比较，如果有一个匹配，则直接返回 true
        for(Class validClass : validGroup) {
            //设置匹配的 groupCondition 到 context 中
            for(Class constraintGroupClass : group) {
                if(validClass == constraintGroupClass) {
                    return true;
                }
            }
        }

        return false;
    }

}
