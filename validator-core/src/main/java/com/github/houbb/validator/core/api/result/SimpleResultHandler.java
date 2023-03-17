package com.github.houbb.validator.core.api.result;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.validator.api.api.constraint.IConstraintResult;

import java.util.List;

/**
 * 简单结果处理
 * （1）判断是否通过
 * （2）只处理失败的列表信息
 * @author binbin.hou
 * @since 0.2.0
 */
@ThreadSafe
public class SimpleResultHandler extends BaseResultHandler {

    @Override
    protected List<IConstraintResult> allList(List<IConstraintResult> constraintResultList) {
        return null;
    }

}
