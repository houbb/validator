package com.github.houbb.validator.core.api.constraint.chain;

import com.github.houbb.heaven.annotation.NotThreadSafe;
import com.github.houbb.heaven.constant.PunctuationConst;
import com.github.houbb.heaven.support.handler.IHandler;
import com.github.houbb.heaven.support.pipeline.Pipeline;
import com.github.houbb.heaven.support.pipeline.impl.DefaultPipeline;
import com.github.houbb.heaven.util.guava.Guavas;
import com.github.houbb.heaven.util.lang.StringUtil;
import com.github.houbb.heaven.util.util.CollectionUtil;
import com.github.houbb.validator.api.api.constraint.IConstraint;
import com.github.houbb.validator.api.api.constraint.IConstraintContext;
import com.github.houbb.validator.api.api.constraint.IConstraintResult;
import com.github.houbb.validator.api.constant.enums.FailTypeEnum;
import com.github.houbb.validator.core.api.constraint.AbstractConstraint;
import com.github.houbb.validator.core.api.fail.context.DefaultFailContext;
import com.github.houbb.validator.core.constant.ContextAttrKeyConst;

import java.util.List;

/**
 * 抽象约束链实现
 * @author binbin.hou
 * @since 0.2.0
 */
@NotThreadSafe
abstract class AbstractConstraintChain extends AbstractConstraint {

    /**
     * 约束链
     * TODO: 不太建议使用这种方式。
     * @since 0.2.0
     */
    private List<IConstraint> constraintList;

    /**
     * 初始化监听器列表
     * @param pipeline 泳道
     * @param context 重试信息
     * @since 0.2.0
     */
    abstract void init(final Pipeline<IConstraint> pipeline,
                       final IConstraintContext context);

    @Override
    protected boolean pass(IConstraintContext context, Object value) {
        boolean passFlag = true;

        Pipeline<IConstraint> pipeline = new DefaultPipeline<>();
        this.init(pipeline, context);

        this.constraintList = pipeline.list();

        // 预期结果列表
        List<String> expectValueList = Guavas.newArrayList();

        // 执行校验
        List<IConstraintResult> constraintResultList = Guavas.newArrayList();
        // 失败处理上下文
        DefaultFailContext failContext = DefaultFailContext.newInstance();

        //TODO: 这里的代码，和 validBs 中有些重复，后期优化掉。
        for(IConstraint constraint : constraintList) {
            // 失败模式
            IConstraintResult constraintResult = constraint.constraint(context);

            if(!constraintResult.pass()) {
                expectValueList.add(constraintResult.expectValue());
                passFlag = false;

                // 构建上下文
                constraintResultList.add(constraintResult);
                failContext.constraintResultList(constraintResultList).constraintResult(constraintResult);

                // 执行判断
                FailTypeEnum failTypeEnum = context.fail().fail(failContext);
                if(FailTypeEnum.FAIL_FAST.equals(failTypeEnum)) {
                    break;
                }
            }
        }

        // 如果不通过，将构建好的信息放在 context
        if(!passFlag) {
            context.putAttr(ContextAttrKeyConst.SYS_CONSTRAINT_CTX_EXPECT_VALUE,
                    StringUtil.join(expectValueList, PunctuationConst.OR));
        }

        // 返回结果
        return passFlag;
    }

    @Override
    protected String expectValue(IConstraintContext context) {
        // 将不符合的验证结果，联合之后放在这里
        return (String) context.getAttr(ContextAttrKeyConst.SYS_CONSTRAINT_CTX_EXPECT_VALUE);
    }

    @Override
    protected String constraintName() {
        if(CollectionUtil.isEmpty(constraintList)) {
            return AbstractConstraintChain.class.getSimpleName();
        }

        // 获取类表名称
        List<String> nameList = CollectionUtil.toList(constraintList, new IHandler<IConstraint, String>() {
            @Override
            public String handle(IConstraint constraint) {
                return constraint.getClass().getSimpleName();
            }
        });
        return StringUtil.join(nameList, PunctuationConst.COMMA);
    }

}
