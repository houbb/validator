package com.github.houbb.validator.test.atconstrains.bean;


import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 各种数字类别-PositiveOrZero
 */
public class JsrAtPositiveOrZeroBo {

    @PositiveOrZero
    private int intVal;

    @PositiveOrZero
    private short shortVal;

    @PositiveOrZero
    private long longVal;

    @PositiveOrZero
    private double doubleVal;

    @PositiveOrZero
    private String stringVal;

    @PositiveOrZero
    private BigDecimal bigDecimalVal;

    @PositiveOrZero
    private BigInteger bigIntegerVal;

    public int getIntVal() {
        return intVal;
    }

    public void setIntVal(int intVal) {
        this.intVal = intVal;
    }

    public short getShortVal() {
        return shortVal;
    }

    public void setShortVal(short shortVal) {
        this.shortVal = shortVal;
    }

    public long getLongVal() {
        return longVal;
    }

    public void setLongVal(long longVal) {
        this.longVal = longVal;
    }

    public double getDoubleVal() {
        return doubleVal;
    }

    public void setDoubleVal(double doubleVal) {
        this.doubleVal = doubleVal;
    }

    public String getStringVal() {
        return stringVal;
    }

    public void setStringVal(String stringVal) {
        this.stringVal = stringVal;
    }

    public BigDecimal getBigDecimalVal() {
        return bigDecimalVal;
    }

    public void setBigDecimalVal(BigDecimal bigDecimalVal) {
        this.bigDecimalVal = bigDecimalVal;
    }

    public BigInteger getBigIntegerVal() {
        return bigIntegerVal;
    }

    public void setBigIntegerVal(BigInteger bigIntegerVal) {
        this.bigIntegerVal = bigIntegerVal;
    }
}
