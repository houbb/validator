package com.github.houbb.validator.test.annotation;

import com.github.houbb.heaven.support.handler.IHandler;
import com.github.houbb.heaven.util.util.ArrayUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class MyEnumRangesValidator implements
        ConstraintValidator<MyEnumRanges, String> {

    private MyEnumRanges myEnumRanges;

    @Override
    public void initialize(MyEnumRanges constraintAnnotation) {
        this.myEnumRanges = constraintAnnotation;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return getEnumValues(myEnumRanges.value()).contains(value);
    }

    /**
     * 获取枚举值对应的信息
     *
     * @param enumClass 枚举类
     * @return 枚举说明
     * @since 0.0.9
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
