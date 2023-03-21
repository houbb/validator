package com.github.houbb.validator.core.api.constraint;

import com.github.houbb.heaven.annotation.NotThreadSafe;
import com.github.houbb.validator.api.api.constraint.IConstraintContext;
import com.github.houbb.validator.core.util.InnerIdCardValidHelper;

/**
 * 中国身份证
 *
 * https://blog.csdn.net/sinat_37239798/article/details/126506510
 *
 * https://blog.csdn.net/qq_36201543/article/details/110648530
 *
 * PS: 中国的行政划分地区也是固定的，这里暂时不做限制。
 *
 * @author binbin.hou
 * @since 0.6.0
 */
@NotThreadSafe
class ChinaIdNoConstraint extends AbstractConstraint<String> {

    /**
     * 身份证正则
     *
     * 定义判别用户身份证号的正则表达式（15位或者18位，最后一位可以为字母）
     *
     * 假设18位身份证号码:41000119910101123X  410001 19910101 123X
     * ^开头
     * [1-9] 第一位1-9中的一个      4
     * \\d{5} 五位数字           10001（前六位省市县地区）
     * (18|19|20)                19（现阶段可能取值范围18xx-20xx年）
     * \\d{2}                    91（年份）
     * ((0[1-9])|(10|11|12))     01（月份）
     * (([0-2][1-9])|10|20|30|31)01（日期）
     * \\d{3} 三位数字            123（第十七位奇数代表男，偶数代表女）
     * [0-9Xx] 0123456789Xx其中的一个 X（第十八位为校验值）
     * $结尾
     *
     * 假设15位身份证号码:410001910101123  410001 910101 123
     * ^开头
     * [1-9] 第一位1-9中的一个      4
     * \\d{5} 五位数字           10001（前六位省市县地区）
     * \\d{2}                    91（年份）
     * ((0[1-9])|(10|11|12))     01（月份）
     * (([0-2][1-9])|10|20|30|31)01（日期）
     * \\d{3} 三位数字            123（第十五位奇数代表男，偶数代表女），15位身份证不含X
     * $结尾
     */
    private static final String REGEX = "(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|" +
            "(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)";

    /**
     * 校验位
     */
    private final boolean checkDigit;

    public ChinaIdNoConstraint(boolean checkBit) {
        this.checkDigit = checkBit;
    }

    public ChinaIdNoConstraint() {
        this(true);
    }

    @Override
    protected boolean pass(IConstraintContext context, String idCard) {
        boolean regexMatch  = idCard.matches(REGEX);
        if(!regexMatch) {
            return regexMatch;
        }

        // 如果是 18 位 && 需要校验最后一位，才进行计算
        if(idCard.length() == 18 && checkDigit) {
            char expectCheckDigit = InnerIdCardValidHelper.getCheckDigit(idCard);
            char actualCheckDigit = idCard.charAt(17);

            return expectCheckDigit == actualCheckDigit;
        }

        return regexMatch;
    }



}

