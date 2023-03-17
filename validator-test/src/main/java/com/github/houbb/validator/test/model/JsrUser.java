package com.github.houbb.validator.test.model;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * JSR 用户信息
 * @author binbin.hou
 * @since 0.1.1
 */
public class JsrUser {

    @Null
    private Object nullVal;

    @NotNull
    private String notNullVal;

    @AssertFalse
    private boolean assertFalse;

    @AssertTrue
    private boolean assertTrue;

    @Pattern(regexp = "[123456]{2}")
    private String pattern;

    @Size(min = 2, max = 5)
    private String size;

    @DecimalMax("12.22")
    private BigDecimal decimalMax;

    @DecimalMin("1.22")
    private BigDecimal decimalMin;

    @Min(10)
    private long min;

    @Max(10)
    private long max;

    @Past
    private Date past;

    @Future
    private Date future;

    @Digits(integer = 2, fraction = 4)
    private Long digits;

    public Object nullVal() {
        return nullVal;
    }

    public JsrUser nullVal(Object nullVal) {
        this.nullVal = nullVal;
        return this;
    }

    public String notNullVal() {
        return notNullVal;
    }

    public JsrUser notNullVal(String notNullVal) {
        this.notNullVal = notNullVal;
        return this;
    }

    public boolean assertFalse() {
        return assertFalse;
    }

    public JsrUser assertFalse(boolean assertFalse) {
        this.assertFalse = assertFalse;
        return this;
    }

    public boolean assertTrue() {
        return assertTrue;
    }

    public JsrUser assertTrue(boolean assertTrue) {
        this.assertTrue = assertTrue;
        return this;
    }

    public String pattern() {
        return pattern;
    }

    public JsrUser pattern(String pattern) {
        this.pattern = pattern;
        return this;
    }

    public String size() {
        return size;
    }

    public JsrUser size(String size) {
        this.size = size;
        return this;
    }

    public BigDecimal decimalMax() {
        return decimalMax;
    }

    public JsrUser decimalMax(BigDecimal decimalMax) {
        this.decimalMax = decimalMax;
        return this;
    }

    public BigDecimal decimalMin() {
        return decimalMin;
    }

    public JsrUser decimalMin(BigDecimal decimalMin) {
        this.decimalMin = decimalMin;
        return this;
    }

    public long min() {
        return min;
    }

    public JsrUser min(long min) {
        this.min = min;
        return this;
    }

    public long max() {
        return max;
    }

    public JsrUser max(long max) {
        this.max = max;
        return this;
    }

    public Date past() {
        return past;
    }

    public JsrUser past(Date past) {
        this.past = past;
        return this;
    }

    public Date future() {
        return future;
    }

    public JsrUser future(Date future) {
        this.future = future;
        return this;
    }

    public Long digits() {
        return digits;
    }

    public JsrUser digits(Long digits) {
        this.digits = digits;
        return this;
    }

    @Override
    public String toString() {
        return "JsrUser{" +
                "nullVal=" + nullVal +
                ", notNullVal='" + notNullVal + '\'' +
                ", assertFalse=" + assertFalse +
                ", assertTrue=" + assertTrue +
                ", pattern='" + pattern + '\'' +
                ", size='" + size + '\'' +
                ", decimalMax=" + decimalMax +
                ", decimalMin=" + decimalMin +
                ", min=" + min +
                ", max=" + max +
                ", past=" + past +
                ", future=" + future +
                ", digits=" + digits +
                '}';
    }
}
