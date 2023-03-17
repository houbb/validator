package com.github.houbb.validator.test.model;

import javax.validation.Valid;

/**
 * 用户信息
 * @author binbin.hou
 * @since 0.1.2
 */
public class ValidUser {

    /**
     * 子节点
     */
    @Valid
    private User user;

    public User user() {
        return user;
    }

    public ValidUser user(User user) {
        this.user = user;
        return this;
    }

}
