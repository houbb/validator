package com.github.houbb.validator.core.api.validator;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.support.handler.IHandler;
import com.github.houbb.heaven.support.tuple.impl.Pair;
import com.github.houbb.heaven.util.guava.Guavas;
import com.github.houbb.heaven.util.lang.ObjectUtil;
import com.github.houbb.heaven.util.lang.reflect.ClassTypeUtil;
import com.github.houbb.heaven.util.lang.reflect.ClassUtil;
import com.github.houbb.heaven.util.lang.reflect.ReflectAnnotationUtil;
import com.github.houbb.heaven.util.lang.reflect.ReflectFieldUtil;
import com.github.houbb.heaven.util.util.ArrayUtil;
import com.github.houbb.heaven.util.util.CollectionUtil;
import com.github.houbb.heaven.util.util.Optional;
import com.github.houbb.validator.api.annotation.condition.Condition;
import com.github.houbb.validator.api.annotation.constraint.Constraint;
import com.github.houbb.validator.api.api.condition.IConditionContext;
import com.github.houbb.validator.api.api.condition.annotation.IAnnotationCondition;
import com.github.houbb.validator.api.api.constraint.annotation.IAnnotationConstraint;
import com.github.houbb.validator.api.api.validator.IValidEntry;
import com.github.houbb.validator.api.api.validator.IValidEntryFieldContext;
import com.github.houbb.validator.api.api.validator.IValidEntryInstanceContext;
import com.github.houbb.validator.core.api.condition.context.DefaultConditionContext;
import com.github.houbb.validator.core.api.validator.entry.ValidEntry;
import com.github.houbb.validator.core.api.validator.entry.ValidEntryInstanceContext;
import com.github.houbb.validator.core.constant.AnnotationConst;

import javax.validation.Valid;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;

/**
 * 默认的验证器实现
 *
 * @author binbin.hou
 * @since 0.1.0
 */
@ThreadSafe
public class DefaultValidator extends AbstractValidator {

    /**
     * 获取单例实例
     *
     * @since 0.1.1
     */
    private static final DefaultValidator INSTANCE = new DefaultValidator();

    public static DefaultValidator getInstance() {
        return INSTANCE;
    }

    /**
     * 构建验证明细列表
     *
     * @param fieldContext 上下文
     * @param field        字段信息
     * @return 验证明细列表
     * @since 0.2.0
     */
    @Override
    @SuppressWarnings("unchecked")
    protected List<IValidEntry> buildValidatorEntryList(final IValidEntryFieldContext fieldContext,
                                                        final Field field) {
        final List<IValidEntry> validatorEntryList = Guavas.newArrayList();

        // 针对注解属性，进行 condition 相关处理。
        final Object instance = fieldContext.instance();
        final Object fieldValue = ReflectFieldUtil.getValue(field, instance);

        List<Pair<Annotation, IAnnotationConstraint>> pairList = filterConstraint(fieldContext, field);
        for (Pair<Annotation, IAnnotationConstraint> pair : pairList) {
            // 当前字段约束存在
            Annotation annotation = pair.getValueOne();
            IAnnotationConstraint annotationConstraint = pair.getValueTwo();
            annotationConstraint.initialize(annotation);

            IValidEntry validatorEntry = ValidEntry.of(annotationConstraint)
                    .message(getMessage(annotation))
                    .group(getGroup(annotation))
                    .fieldList(fieldContext.fieldList())
                    .instance(instance)
                    .value(fieldValue)
                    .currentField(field);
            validatorEntryList.add(validatorEntry);
        }

        // 进一步处理 valid 明细
        final IValidEntryInstanceContext instanceContext = ValidEntryInstanceContext.newInstance()
                .group(fieldContext.group());
        Valid valid = field.getAnnotation(Valid.class);

        if (ObjectUtil.isNotNull(valid)
                && ObjectUtil.isNotNull(fieldValue)) {
            final Class fieldClazz = field.getType();
            // 判断是否为集合
            if (ClassTypeUtil.isCollection(fieldClazz)) {
                Collection collection = (Collection) fieldValue;
                for (Object entry : collection) {
                    List<IValidEntry> entryList = this.buildValidatorEntryList(instanceContext, entry);
                    validatorEntryList.addAll(entryList);
                }
            } else if (ClassTypeUtil.isArray(fieldClazz)) {
                // 是否为数组
                ArrayUtil.toList(fieldValue, new IHandler() {
                    @Override
                    public Object handle(Object o) {
                        List<IValidEntry> entryList = buildValidatorEntryList(instanceContext, o);
                        validatorEntryList.addAll(entryList);
                        return o;
                    }
                });
            } else {
                // 其他场景
                List<IValidEntry> entryList = buildValidatorEntryList(instanceContext, fieldValue);
                validatorEntryList.addAll(entryList);
            }
        }

        return validatorEntryList;
    }

    /**
     * 获取注解对应的 message 信息
     *
     * @param annotation 注解
     * @return message() 方法对应的值。
     * @since 0.2.0
     */
    protected String getMessage(final Annotation annotation) {
        return ReflectAnnotationUtil.getValueStr(annotation, AnnotationConst.MESSAGE);
    }

    /**
     * 获取注解对应的 message 信息
     *
     * @param annotation 注解
     * @return message() 方法对应的值。
     * @since 0.2.0
     */
    private Class[] getGroup(final Annotation annotation) {
        Object object = ReflectAnnotationUtil.getValue(annotation, AnnotationConst.GROUP);

        if (ObjectUtil.isNull(object)) {
            return new Class[0];
        }

        return (Class[]) object;
    }

    /**
     * 获取注解对应的 @Condition#include 信息
     *
     * @param annotation 注解
     * @return include() 方法对应的值。
     * @since 0.2.0
     */
    private Class[] getConditionInclude(final Annotation annotation) {
        Object object = ReflectAnnotationUtil.getValue(annotation, AnnotationConst.INCLUDE);

        if (ObjectUtil.isNull(object)) {
            return new Class[0];
        }

        return (Class[]) object;
    }

    /**
     * 获取注解对应的 @Condition#include 信息
     *
     * @param annotation 注解
     * @return include() 方法对应的值。
     * @since 0.2.0
     */
    private Class[] getConditionExclude(final Annotation annotation) {
        Object object = ReflectAnnotationUtil.getValue(annotation, AnnotationConst.EXCLUDE);

        if (ObjectUtil.isNull(object)) {
            return new Class[0];
        }

        return (Class[]) object;
    }


    /**
     * 获取对应的注解约束信息
     *
     * @param annotation 注解
     * @return 约束实现类
     * @since 0.2.0
     */
    protected Optional<IAnnotationConstraint> constraintOptional(final Annotation annotation) {
        Constraint constraint = annotation.annotationType().getAnnotation(Constraint.class);
        if (ObjectUtil.isNotNull(constraint)) {
            Class<? extends IAnnotationConstraint> clazz = constraint.value();
            return Optional.of(ClassUtil.newInstance(clazz));
        }

        return Optional.empty();
    }

    /**
     * 获取对应的注解条件信息
     *
     * @param annotation 注解
     * @return 条件实现类
     * @since 0.2.0
     */
    private Optional<IAnnotationCondition> conditionOptional(final Annotation annotation) {
        Condition condition = annotation.annotationType().getAnnotation(Condition.class);
        if (ObjectUtil.isNotNull(condition)) {
            Class<? extends IAnnotationCondition> clazz = condition.value();
            return Optional.of(ClassUtil.newInstance(clazz));
        }

        return Optional.empty();
    }

    /**
     * 获取当前字段关于约束的注解信息，按照 Condition 进行过滤。
     *
     * @param context 字段上下文
     * @param field   当前字段
     * @return 符合约束的注解信息
     * @since 0.2.0
     */
    @SuppressWarnings("unchecked")
    protected List<Pair<Annotation, IAnnotationConstraint>> filterConstraint(final IValidEntryFieldContext context, final Field field) {
        Pair<List<Pair<Annotation, IAnnotationCondition>>,
                List<Pair<Annotation, IAnnotationConstraint>>> pair = buildAnnotationPair(field);
        final List<Pair<Annotation, IAnnotationCondition>> conditionAtList = pair.getValueOne();
        final List<Pair<Annotation, IAnnotationConstraint>> constraintAtList = pair.getValueTwo();

        //1. 条件列表为空，则默认返回所有的约束列表
        if (CollectionUtil.isEmpty(conditionAtList)) {
            return constraintAtList;
        }

        //2. 条件列表不为空
        // 循环判断，返回符合 condition 的列表信息
        final Object instance = context.instance();
        final Object fieldValue = ReflectFieldUtil.getValue(field, instance);

        //3. 构建条件相关信息
        Optional<Annotation> conditionOptional = getFirstMatchConditionAt(conditionAtList,
                context, fieldValue);
        //3.1 没有符合的条件
        if (conditionOptional.isNotPresent()) {
            return Guavas.newArrayList();
        }
        //3.2 符合条件的注解存在。
        return filterConstraintAtList(constraintAtList, conditionOptional.get());
    }

    /**
     * 获取第一个匹配的 condition 注解信息
     *
     * @param conditionAtList 条件列表
     * @param context         上下文
     * @param fieldValue      字段信息
     * @return 条件注解信息
     * @since 0.2.0
     */
    @SuppressWarnings("unchecked")
    private Optional<Annotation> getFirstMatchConditionAt(final List<Pair<Annotation, IAnnotationCondition>> conditionAtList, final IValidEntryFieldContext context, final Object fieldValue) {
        for (Pair<Annotation, IAnnotationCondition> entry : conditionAtList) {
            final Annotation conditionAnnotation = entry.getValueOne();
            //2.1 不符合条件，直接下一个
            IConditionContext conditionContext = DefaultConditionContext.newInstance()
                    .value(fieldValue)
                    .instance(context.instance())
                    .validGroup(context.group())
                    .fieldList(context.fieldList());

            IAnnotationCondition annotationCondition = entry.getValueTwo();
            annotationCondition.initialize(conditionAnnotation);
            boolean condition = annotationCondition.condition(conditionContext);

            //2.2 条件符合，进行处理。
            //2.2.1 include 存在，exclude 为空
            if (condition) {
                return Optional.of(conditionAnnotation);
            }
        }
        return Optional.empty();
    }

    /**
     * 根据条件执行过滤
     *
     * @param constrainsList 约束列表
     * @param conditionAt    注解信息
     * @return 包含信息
     * @since 0.2.0
     */
    private List<Pair<Annotation, IAnnotationConstraint>> filterConstraintAtList(final List<Pair<Annotation, IAnnotationConstraint>> constrainsList, final Annotation conditionAt) {
        final Class[] includes = getConditionInclude(conditionAt);
        final Class[] excludes = getConditionExclude(conditionAt);

        if (CollectionUtil.isEmpty(constrainsList)) {
            return constrainsList;
        }

        List<Pair<Annotation, IAnnotationConstraint>> resultList = Guavas.newArrayList();
        for (Pair<Annotation, IAnnotationConstraint> pair : constrainsList) {
            final Class annotationClass = pair.getValueOne().getClass();
            //includes 包含 或者为空 && excludes 不包含
            if ((ArrayUtil.isEmpty(includes)
                    || ArrayUtil.contains(includes, annotationClass))
                    && ArrayUtil.notContains(excludes, annotationClass)) {
                resultList.add(pair);
            }
        }

        return resultList;
    }


    /**
     * 构建注解信息
     * （1）获取条件注解实现类列表
     * （2）获取其他注解类。
     * <p>
     * 主要是为了避免过滤逻辑变得复杂。
     * <p>
     * （1）如何指定生效的约束类，根据 class 吗？
     * （2）可以默认根据 class，特殊的指定 alias 别名。
     * 后期支持。
     * <p>
     * （1）这里需要对应的 condition 注解信息。及对应的实现类
     * （2）需要对应的注解信息，及对应的实现类。
     *
     * @param field 字段信息
     * @return pair 结果
     * @since 0.2.0
     */
    private Pair<List<Pair<Annotation, IAnnotationCondition>>,
            List<Pair<Annotation, IAnnotationConstraint>>> buildAnnotationPair(final Field field) {
        List<Pair<Annotation, IAnnotationCondition>> conditionList = Guavas.newArrayList();
        List<Pair<Annotation, IAnnotationConstraint>> constraintList = Guavas.newArrayList();

        // 注解列表为空
        Annotation[] annotations = field.getAnnotations();

        // 遍历注解列表
        for (Annotation annotation : annotations) {
            // 判断是否为 condition
            Optional<IAnnotationCondition> conditionOptional = conditionOptional(annotation);
            if (conditionOptional.isNotPresent()) {
                // 直接添加，在过滤时才进行处理是否为约束类注解。
                Optional<IAnnotationConstraint> constraintOptional = constraintOptional(annotation);
                if (constraintOptional.isPresent()) {
                    Pair<Annotation, IAnnotationConstraint> constraintPair = Pair.of(annotation, constraintOptional.get());
                    constraintList.add(constraintPair);
                }
            } else {
                // 为条件注解。
                Pair<Annotation, IAnnotationCondition> conditionPair = Pair.of(annotation, conditionOptional.get());
                conditionList.add(conditionPair);
            }
        }

        return Pair.of(conditionList, constraintList);
    }

}
