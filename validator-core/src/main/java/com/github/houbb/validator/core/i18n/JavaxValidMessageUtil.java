package com.github.houbb.validator.core.i18n;

import com.github.houbb.heaven.util.lang.StringUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * jsr 标准
 * @since 0.3.0
 */
public final class JavaxValidMessageUtil {

    private JavaxValidMessageUtil(){}

    /**
     * 模板-key 映射关系
     * @since 0.1.1
     */
    private static final Map<String, String> TEMPLATE_KEY_MAP;

    static {
        TEMPLATE_KEY_MAP = new HashMap<>(16);

        TEMPLATE_KEY_MAP.put("{javax.validation.constraints.AssertFalse.message}", "AssertFalse");
        TEMPLATE_KEY_MAP.put("{javax.validation.constraints.AssertTrue.message}", "AssertTrue");
        TEMPLATE_KEY_MAP.put("{javax.validation.constraints.DecimalMax.message}", "DecimalMax");
        TEMPLATE_KEY_MAP.put("{javax.validation.constraints.DecimalMin.message}", "DecimalMin");
        TEMPLATE_KEY_MAP.put("{javax.validation.constraints.Max.message}", "Max");
        TEMPLATE_KEY_MAP.put("{javax.validation.constraints.Min.message}", "Min");
        TEMPLATE_KEY_MAP.put("{javax.validation.constraints.Pattern.message}", "Pattern");
        TEMPLATE_KEY_MAP.put("{javax.validation.constraints.Digits.message}", "Digits");
        TEMPLATE_KEY_MAP.put("{javax.validation.constraints.Size.message}", "Size");
        TEMPLATE_KEY_MAP.put("{javax.validation.constraints.Null.message}", "Null");
        TEMPLATE_KEY_MAP.put("{javax.validation.constraints.NotNull.message}", "NotNull");
        TEMPLATE_KEY_MAP.put("{javax.validation.constraints.Future.message}", "Future");
        TEMPLATE_KEY_MAP.put("{javax.validation.constraints.Past.message}", "Past");
    }

    /**
     * 根据消息，获取对应的消息信息
     * @param message 消息本身
     * @return 尽可能 i18n 化后的内容
     * @since 0.3.0
     */
    public static String getMapKey(final String message) {
        String mapKey  = TEMPLATE_KEY_MAP.get(message);

        if(StringUtil.isNotEmpty(mapKey)) {
            return mapKey;
        }

        return message;
    }

}
