/*
 * Copyright (c)  2019. houbinbin Inc.
 * valid All rights reserved.
 */

package com.github.houbb.validator.core.api.constraint;

import com.github.houbb.heaven.annotation.ThreadSafe;

/**
 * 严格抽象约束实现
 * （1）默认的 jsr 标准，对于 null 值其实是相对宽松的。
 * @see AbstractConstraint 对比这个，这里对于 null值更加严格。
 * @author binbin.hou
 * @param <T> 泛型
 * @since 0.0.8
 */
@ThreadSafe
public abstract class AbstractStrictConstraint<T> extends AbstractConstraint<T> {

    @Override
    protected boolean isNullPass(T value) {
        return false;
    }

}
