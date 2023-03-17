package com.github.houbb.validator.test.model;

import com.github.houbb.validator.api.constant.enums.FailTypeEnum;
import com.github.houbb.validator.core.annotation.constraint.AllEquals;
import com.github.houbb.validator.core.annotation.constraint.EnumRanges;
import com.github.houbb.validator.core.annotation.constraint.HasNotNull;
import com.github.houbb.validator.core.annotation.constraint.Ranges;

/**
 * 用户信息
 * @author binbin.hou
 * @since 0.0.9
 */
public class User {

    /**
     * 名称
     */
    @HasNotNull({"nickName"})
    private String name;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 原始密码
     */
    @AllEquals("password2")
    private String password;

    /**
     * 新密码
     */
    private String password2;

    /**
     * 性别
     */
    @Ranges({"boy", "girl"})
    private String sex;

    /**
     * 失败类型枚举
     */
    @EnumRanges(FailTypeEnum.class)
    private String failType;

    public String name() {
        return name;
    }

    public User name(String name) {
        this.name = name;
        return this;
    }

    public String password() {
        return password;
    }

    public User password(String password) {
        this.password = password;
        return this;
    }

    public String password2() {
        return password2;
    }

    public User password2(String password2) {
        this.password2 = password2;
        return this;
    }

    public String sex() {
        return sex;
    }

    public User sex(String sex) {
        this.sex = sex;
        return this;
    }

    public String nickName() {
        return nickName;
    }

    public User nickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public String failType() {
        return failType;
    }

    public User failType(String failType) {
        this.failType = failType;
        return this;
    }
}
