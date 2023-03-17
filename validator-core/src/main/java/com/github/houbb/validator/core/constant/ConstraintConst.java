package com.github.houbb.validator.core.constant;

import com.github.houbb.heaven.util.lang.StringUtil;
import com.github.houbb.heaven.util.util.Optional;
import com.github.houbb.validator.api.api.constraint.IConstraint;
import com.github.houbb.validator.core.api.constraint.annotation.AtAllEqualsConstraint;
import com.github.houbb.validator.core.api.constraint.annotation.AtEnumRangesConstraint;
import com.github.houbb.validator.core.api.constraint.annotation.AtHasNotNullConstraint;
import com.github.houbb.validator.core.api.constraint.annotation.AtRangesConstraint;
import com.github.houbb.validator.core.i18n.I18N;

import java.util.HashMap;
import java.util.Map;

/**
 * 约束常量
 * @author binbin.hou
 * @since 0.2.0
 */
public final class ConstraintConst {

    /**
     * 约束消息集合
     * @since 0.2.0
     */
    private static final Map<Class, String> CONSTRAINT_MESSAGE_MAP = new HashMap<>();

    static {
        CONSTRAINT_MESSAGE_MAP.put(AtAllEqualsConstraint.class, "AllEqualsConstraintMessage");
        CONSTRAINT_MESSAGE_MAP.put(AtEnumRangesConstraint.class, "EnumRangesConstraintMessage");
        CONSTRAINT_MESSAGE_MAP.put(AtHasNotNullConstraint.class, "HasNotNullConstraintMessage");
        CONSTRAINT_MESSAGE_MAP.put(AtRangesConstraint.class, "RangesConstraintMessage");
    }

    private ConstraintConst(){}

    /**
     * 获取消息对应的 i18N
     * @param clazz 类别
     * @return 默认 i18n 消息
     * @since 0.2.0
     */
    public static Optional<String> getMessageI18n(final Class<? extends IConstraint> clazz) {
        String template = CONSTRAINT_MESSAGE_MAP.get(clazz);
        if(StringUtil.isEmpty(template)) {
            return Optional.empty();
        }

        String i18n = I18N.get(template);
        return Optional.of(i18n);
    }


}
