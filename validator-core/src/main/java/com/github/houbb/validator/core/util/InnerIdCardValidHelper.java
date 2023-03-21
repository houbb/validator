package com.github.houbb.validator.core.util;

/**
 * 内部的身份证工具类
 * @since 0.6.0
 */
public final class InnerIdCardValidHelper {

    /**
     * 校验码权重
     */
    public static final int[] CHECK_WEIGHT = new int[]{
            7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2
    };

    /**
     * 权重码映射
     */
    public static final char[] CHECK_MAPPING = new char[]{
            '1','0','X','9','8','7','6','5','4','3','2'
    };

    /**
     * 获取校验码
     * 1. 将前面的身份证号码17位数分别乘以不同的系数。
     * 2. 将这17位数字和系数相乘的结果相加；用加出来和除以11，看余数是多少
     * 3. 返回映射数字
     *
     * @param idCard 身份证（前17位即可）
     * @return 结果
     */
    public static char getCheckDigit(String idCard) {
        int sum = 0;
        char[] chars = idCard.toCharArray();
        for(int i = 0; i < 17; i++) {
            int weight = CHECK_WEIGHT[i] * Integer.parseInt(String.valueOf(chars[i]));
            sum += weight;
        }

        int value = sum % 11;
        return CHECK_MAPPING[value];
    }

}
