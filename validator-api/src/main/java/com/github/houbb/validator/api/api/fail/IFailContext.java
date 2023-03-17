package com.github.houbb.validator.api.api.fail;

import com.github.houbb.validator.api.api.constraint.IConstraintResult;

import java.util.List;

/**
 * 失败上下文接口
 * @author binbin.hou
 * @since 0.1.0
 */
public interface IFailContext {

    /**
     * 当前约束结果
     * @return 约束结果
     * @since 0.1.0
     */
    IConstraintResult constraintResult();

    /**
     * 约束结果列表
     * @return 列表
     * @since 0.1.0
     */
    List<IConstraintResult> constraintResultList();

}
