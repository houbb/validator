package com.github.houbb.validator.core.api.validator;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.util.guava.Guavas;
import com.github.houbb.heaven.util.lang.ObjectUtil;
import com.github.houbb.heaven.util.lang.reflect.ClassTypeUtil;
import com.github.houbb.heaven.util.lang.reflect.ClassUtil;
import com.github.houbb.heaven.util.util.CollectionUtil;
import com.github.houbb.validator.api.api.condition.ICondition;
import com.github.houbb.validator.api.api.constraint.IConstraintContext;
import com.github.houbb.validator.api.api.constraint.IConstraintResult;
import com.github.houbb.validator.api.api.fail.IFail;
import com.github.houbb.validator.api.api.fail.IFailContext;
import com.github.houbb.validator.api.api.validator.*;
import com.github.houbb.validator.api.constant.enums.FailTypeEnum;
import com.github.houbb.validator.core.api.condition.Conditions;
import com.github.houbb.validator.core.api.condition.chain.ConditionChains;
import com.github.houbb.validator.core.api.condition.context.DefaultConditionContext;
import com.github.houbb.validator.core.api.constraint.context.DefaultConstraintContext;
import com.github.houbb.validator.core.api.fail.context.DefaultFailContext;
import com.github.houbb.validator.core.api.validator.entry.ValidEntryFieldContext;
import com.github.houbb.validator.core.api.validator.entry.ValidEntryInstanceContext;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

/**
 * 抽象的验证器实现
 *
 * @author binbin.hou
 * @since 0.1.0
 */
@ThreadSafe
public abstract class AbstractValidator implements IValidator {

    /**
     * 构建验证明细列表
     *
     * @param context 上下文信息
     * @param field   字段信息
     * @return 验证明细列表
     * @since 0.1.1
     */
    protected abstract List<IValidEntry> buildValidatorEntryList(final IValidEntryFieldContext context,
                                                                 final Field field);

    /**
     * 构建验证明细列表
     * （1）null 对象直接返回
     * （2）map/抽象类接口/jdk自带类/基础变量 直接返回
     * （3）字段列表为空的，直接返回。
     *
     * @param context  上下文信息
     * @param instance 验证对象属性值
     * @return 验证明细列表
     * @since 0.1.0
     */
    protected List<IValidEntry> buildValidatorEntryList(final IValidEntryInstanceContext context,
                                                        final Object instance) {
        if (ObjectUtil.isNull(instance)) {
            return Collections.emptyList();
        }

        final Class clazz = instance.getClass();
        // 不处理的类型
        if (ClassTypeUtil.isMap(clazz)
                || ClassTypeUtil.isAbstractOrInterface(clazz)
                || ClassTypeUtil.isPrimitive(clazz)
                || ClassTypeUtil.isJdk(clazz)) {
            return Collections.emptyList();
        }
        // 字段为空
        List<Field> fieldList = ClassUtil.getAllFieldList(clazz);
        if (CollectionUtil.isEmpty(fieldList)) {
            return Collections.emptyList();
        }

        List<IValidEntry> validatorEntryList = Guavas.newArrayList();

        // 单个字段上下文
        ValidEntryFieldContext fieldContext = ValidEntryFieldContext.newInstance()
                .group(context.group())
                .fieldList(fieldList)
                .instance(instance);
        for (Field field : fieldList) {
            List<IValidEntry> fieldValidatorEntry = this.buildValidatorEntryList(fieldContext, field);
            validatorEntryList.addAll(fieldValidatorEntry);
        }

        return validatorEntryList;
    }

    @Override
    public List<IConstraintResult> valid(IValidatorContext context) {
        List<IConstraintResult> resultList = Guavas.newArrayList();

        // 构建符合条件的自定义验证列表
        List<IValidEntry> allValidatorEntries = buildConditionValidEntries(context);

        // 获取 bean 对应的校验信息
        ValidEntryInstanceContext instanceContext = ValidEntryInstanceContext.newInstance()
                .group(context.group());
        List<IValidEntry> beanValidatorEntries = buildValidatorEntryList(instanceContext, context.value());
        allValidatorEntries.addAll(beanValidatorEntries);

        final IFail fail = context.fail();

        // 循环执行。
        for (IValidEntry validatorEntry : allValidatorEntries) {
            // 构建约束上下文
            // fail 对于 chain 也要保证语义的一致性。
            IConstraintContext constraintContext = DefaultConstraintContext.newInstance()
                    .fail(fail)
                    .value(validatorEntry.value())
                    .message(validatorEntry.message())
                    .instance(validatorEntry.instance())
                    .fieldList(validatorEntry.fieldList())
                    .currentField(validatorEntry.currentField());

            IConstraintResult constraintResult = validatorEntry
                    .constraint()
                    .constraint(constraintContext);

            resultList.add(constraintResult);

            // 根据失败实现进行处理 @since0.0.7
            if (!constraintResult.pass()) {
                IFailContext failContext = DefaultFailContext.newInstance()
                        .constraintResult(constraintResult)
                        .constraintResultList(resultList);

                FailTypeEnum failTypeEnum = fail.fail(failContext);
                if (FailTypeEnum.FAIL_FAST.equals(failTypeEnum)) {
                    break;
                }
                // 后期可以添加更加丰富的失败处理策略
            }
        }

        // 返回结果
        return resultList;
    }

    /**
     * 构建符合条件的列表
     *
     * @param context 上下文
     * @return 新的列表
     * @since 0.2.0
     */
    private List<IValidEntry> buildConditionValidEntries(final IValidatorContext context) {
        List<IValidEntry> resultList = Guavas.newArrayList();

        List<IValidEntry> validEntries = context.validatorEntries();

        if (CollectionUtil.isEmpty(validEntries)) {
            return resultList;
        }

        final Class[] validGroup = context.group();
        for(IValidEntry iValidEntry : validEntries) {
            if(conditionConstraint(iValidEntry, validGroup)) {
                resultList.add(iValidEntry);
            }
        }
        return resultList;
    }


    /**
     * 符合指定条件的约束信息
     * （1）判断 condition
     * （2）判断 groupCondition 信息
     *
     * @param validatorEntry 验证器明细
     * @param validGroup     待验证分组信息
     * @return 是否需要执行
     * @since 0.0.5
     */
    private boolean conditionConstraint(final IValidEntry validatorEntry,
                                        final Class[] validGroup) {
        // 是否满足执行条件
        DefaultConditionContext conditionContext = DefaultConditionContext
                .newInstance()
                .value(validatorEntry.value())
                .group(validatorEntry.group())
                .validGroup(validGroup);

        // 构建调用链
        ICondition condition = ConditionChains.chain(Conditions.group(),
                validatorEntry.condition());

        // 返回结果
        return condition.condition(conditionContext);
    }

}
