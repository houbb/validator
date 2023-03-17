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
import com.github.houbb.validator.api.api.validator.IValidator;
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
 * @since 0.2.0
 */
public final class Validators {

    /**
     * 默认的策略实现
     * @return 实现
     * @since 0.2.0
     */
    public static IValidator defaults() {
        return new DefaultValidator();
    }

}
