package com.github.houbb.validator.core.api.constraint;

import com.github.houbb.heaven.annotation.NotThreadSafe;
import com.github.houbb.heaven.support.handler.IHandler;
import com.github.houbb.heaven.util.util.ArrayUtil;

import java.util.List;

/**
 * 范围注解约束实现
 * @author binbin.hou
 * @since 0.2.0
 */
@NotThreadSafe
class EnumRangesConstraint extends AbstractContainsConstraint {

    /**
     * 枚举类
     */
    private Class<? extends Enum> enumClass;

    public EnumRangesConstraint(Class<? extends Enum> enumClass) {
        this.enumClass = enumClass;
    }

    @Override
    protected List ranges() {
        return getEnumValues(enumClass);
    }

    /**
     * 获取枚举值对应的信息
     * @param enumClass 枚举类
     * @return 枚举说明
     * @since 0.2.0
     */
    private List<String> getEnumValues(Class<? extends Enum> enumClass) {
        Enum[] enums = enumClass.getEnumConstants();

        return ArrayUtil.toList(enums, new IHandler<Enum, String>() {
            @Override
            public String handle(Enum anEnum) {
                return anEnum.toString();
            }
        });
    }

}
