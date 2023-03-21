package com.github.houbb.validator.test.atconstrains.bean;


import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Negative;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 各种数字类别-negative
 */
public class JsrAtNegativeBo {

    @Negative
    private int intVal;

    @Negative
    private short shortVal;

    @Negative
    private long longVal;

    @Negative
    private double doubleVal;

    @Negative
    private String stringVal;

    @Negative
    private BigDecimal bigDecimalVal;

    @Negative
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
