package com.github.houbb.validator.test.enums;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public enum SexEnum {
    BOY("BOY", "男"),
    GIRL("GIRL", "女"),
    ;

    private final String code;
    private final String desc;

    SexEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
