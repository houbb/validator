package com.github.houbb.validator.test.model;

import com.github.houbb.validator.core.annotation.constraint.AllEquals;

import javax.validation.Valid;

/**
 * 自己引用自己的验证
 * （1）验证是否会进入死循环。
 * @author binbin.hou
 * @since 0.1.2
 */
public class SelfValidUser {

    @AllEquals("password2")
    private String password;

    private String password2;

    /**
     * 子节点
     */
    @Valid
    private SelfValidUser child;

    public String password() {
        return password;
    }

    public SelfValidUser password(String password) {
        this.password = password;
        return this;
    }

    public String password2() {
        return password2;
    }

    public SelfValidUser password2(String password2) {
        this.password2 = password2;
        return this;
    }

    public SelfValidUser child() {
        return child;
    }

    public SelfValidUser child(SelfValidUser child) {
        this.child = child;
        return this;
    }
}
