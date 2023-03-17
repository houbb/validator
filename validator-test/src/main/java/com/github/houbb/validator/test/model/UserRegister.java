package com.github.houbb.validator.test.model;

import com.github.houbb.validator.test.annotation.MyEnumRanges;
import com.github.houbb.validator.test.enums.SexEnum;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * 用户注册信息
 * @author binbin.hou
 * @since 0.2.2
 */
public class UserRegister {

    /**
     * 名称
     */
    @NotNull(message = "名称不可为空")
    @Length(min = 1, max = 32, message = "名称长度必须介于 1-32 之间")
    private String name;

    /**
     * 原始密码
     */
    @NotNull(message = "密码不可为空不可为空")
    @Length(min = 1, max = 32, message = "密码长度必须介于 6-32 之间")
    private String password;

    /**
     * 确认密码
     */
    @NotNull(message = "确认密码不可为空不可为空")
    @Length(min = 1, max = 32, message = "确认密码必须介于 6-32 之间")
    private String password2;

    /**
     * 性别
     */
    @NotNull(message = "性别不可为空")
    @MyEnumRanges(message = "性别必须在 BOY/GIRL 范围内", value = SexEnum.class)
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "SimpleUser{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", password2='" + password2 + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

}
