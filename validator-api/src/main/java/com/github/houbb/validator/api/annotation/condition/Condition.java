package com.github.houbb.validator.api.annotation.condition;



import com.github.houbb.validator.api.api.condition.annotation.IAnnotationCondition;

import java.lang.annotation.*;

/**
 * 指定注解生效的条件的元注解
 *
 * @author binbin.hou
 * @since 0.1.0
 */
@Inherited
@Documented
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Condition {

    /**
     * 生效条件实现类
     * @return 对应的 class 实现
     * @since 0.1.0
     */
    Class<? extends IAnnotationCondition> value();

}
