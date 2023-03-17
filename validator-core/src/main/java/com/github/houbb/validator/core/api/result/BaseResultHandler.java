package com.github.houbb.validator.core.api.result;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.util.guava.Guavas;
import com.github.houbb.heaven.util.util.CollectionUtil;
import com.github.houbb.validator.api.api.constraint.IConstraintResult;
import com.github.houbb.validator.api.api.result.IResult;
import com.github.houbb.validator.api.api.result.IResultHandler;
import com.github.houbb.validator.core.api.result.result.DefaultResult;

import java.util.List;

/**
 * 抽象处理结果
 * @author binbin.hou
 * @since 0.2.0
 */
@ThreadSafe
public class BaseResultHandler implements IResultHandler<IResult> {

    @Override
    public IResult handle(final List<IConstraintResult> constraintResultList) {
        DefaultResult defaultResult = DefaultResult.newInstance();
        defaultResult.allList(allList(constraintResultList));
        defaultResult.notPassList(notPassList(constraintResultList));
        boolean pass = pass(defaultResult);
        defaultResult.pass(pass);
        return defaultResult;
    }

    /**
     * 返回所有信息列表
     * @param constraintResultList 验证结果列表
     * @return 全部结果列表
     */
    protected List<IConstraintResult> allList(final List<IConstraintResult> constraintResultList) {
        return constraintResultList;
    }

    /**
     * 返回所有信息列表
     * @param constraintResultList 验证结果列表
     * @return 全部结果列表
     */
    protected List<IConstraintResult> notPassList(final List<IConstraintResult> constraintResultList) {
        List<IConstraintResult> notPassList = Guavas.newArrayList();

        if(CollectionUtil.isEmpty(constraintResultList)) {
            return notPassList;
        }
        for(IConstraintResult result : constraintResultList) {
            if(!result.pass()) {
                notPassList.add(result);
            }
        }
        return notPassList;
    }

    /**
     * 验证是否通过
     * @param result 验证结果列表
     * @return 是否全部通过
     * @since 0.2.0
     */
    protected boolean pass(final IResult result) {
        return result.notPassList().isEmpty();
    }

}
