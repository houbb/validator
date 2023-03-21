package com.github.houbb.validator.test.atconstrains.bean;


import javax.validation.constraints.NegativeOrZero;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 各种数字类别-NegativeOrZero
 */
public class JsrAtNegativeOrZeroBo {

    @NegativeOrZero
    private int intVal;

    @NegativeOrZero
    private short shortVal;

    @NegativeOrZero
    private long longVal;

    @NegativeOrZero
    private double doubleVal;

    @NegativeOrZero
    private String stringVal;

    @NegativeOrZero
    private BigDecimal bigDecimalVal;

    @NegativeOrZero
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
