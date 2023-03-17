package com.github.houbb.validator.test.model;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * JSR 用户信息
 * @author binbin.hou
 * @since 0.1.1
 */
public class JsrUserSimple {

    @AssertTrue
    private boolean assertTrue;

    public boolean assertTrue() {
        return assertTrue;
    }

    public JsrUserSimple assertTrue(boolean assertTrue) {
        this.assertTrue = assertTrue;
        return this;
    }
}
