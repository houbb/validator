package com.github.houbb.validator.test.atconstrains.bean;


import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 各种数字类别-Positive
 */
public class JsrAtPositiveBo {

    @Positive
    private int intVal;

    @Positive
    private short shortVal;

    @Positive
    private long longVal;

    @Positive
    private double doubleVal;

    @Positive
    private String stringVal;

    @Positive
    private BigDecimal bigDecimalVal;

    @Positive
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
