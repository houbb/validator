/*
 * Copyright (c)  2019. houbinbin Inc.
 * valid All rights reserved.
 */

package com.github.houbb.validator.core.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * <p> i18n 编码支持 </p>
 *
 * <pre> Created: 2018/7/28 下午4:53  </pre>
 * <pre> Project: valid </pre>
 *
 * @author houbinbin
 * @since 0.0.8
 */
public final class I18N {

    private I18N(){}

    /**
     * 默认的配置文件
     */
    private static final String DEFAULT_PROPERTIES_FILE_NAME = "i18n.Valid";

    /**
     * 获取属性的值
     * @param key 键值
     * @return 属性 I18n
     */
    public static String get(final String key) {
        Locale currentLocale = Locale.getDefault();
        ResourceBundle myResources = ResourceBundle.getBundle(DEFAULT_PROPERTIES_FILE_NAME, currentLocale);

        // jsr 做一次映射
        String mapKey = JavaxValidMessageUtil.getMapKey(key);
        return myResources.getString(mapKey);
    }

    /**
     * 固定的键值标识
     */
    public static class Key {

        /**
         * @since 0.2.0
         */
        private Key(){}

        /**
         * 消息-值不是预期值
         * @since 0.0.8
         */
        public static final String MESSAGE_VALUE_NOT_EXPECTED = "MESSAGE_VALUE_NOT_EXPECTED";

        /**
         * 消息-预期值是，但是实际值是
         *
         * @since 0.0.8
         */
        public static final String MESSAGE_EXPECT_BUT_ACTUAL = "MESSAGE_EXPECT_BUT_ACTUAL";

        /**
         * 支持类型提示
         */
        public static final String SUPPORT_CLASS_TYPE_TIPS = "SUPPORT_CLASS_TYPE_TIPS";

        /**
         * 小于等于
         * @since 0.0.8
         */
        public static final String LESS_THAN_OR_EQUALS = "LESS_THAN_OR_EQUALS";

        /**
         * 小于
         * @since 0.0.8
         */
        public static final String LESS_THAN = "LESS_THAN";

        /**
         * 大于等于
         * @since 0.0.8
         */
        public static final String GREAT_THAN_OR_EQUALS = "GREAT_THAN_OR_EQUALS";

        /**
         * 大于
         * "great than or equals "
         */
        public static final String GREAT_THAN = "GREAT_THAN";

        /**
         * 大小必须在指定范围内
         * @since 0.3.0
         */
        public static final String SIZE_MUST_BE_IN = "sizeMustBeIn";

        /**
         * 必须匹配正则
         * @since 0.3.0
         */
        public static final String MATCH_REGEX_PATTERN = "matchRegexPattern";

        /**
         * 整数小数位数
         * @since 0.3.0
         */
        public static final String INTEGER_DIGITS_FRACTION_DIGITS = "integerDigitsFractionDigits";

    }

}
