package com.github.houbb.validator.api.api.validator;

import com.github.houbb.validator.api.api.constraint.IConstraintResult;

import java.util.List;

/**
 * 校验器接口
 * @author binbin.hou
 * @since 0.1.0
 */
public interface IValidator {

    /**
     * 执行校验
     * @param context 上下文
     * @return 单个约束条件结果列表
     * @since 0.1.0
     */
    List<IConstraintResult> valid(final IValidatorContext context);

}
