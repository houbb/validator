package com.github.houbb.validator.test.atconstrains.bean;


import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

/**
 * 时间
 * @since 0.5.0
 */
public class JsrAtFutureOrPastOrPresentBo {

    @Future
    private Date futureVal;

    @FutureOrPresent
    private Date futureOrPresentVal;

    @Past
    private Date pastVal;

    @PastOrPresent
    private Date pastOrPresentVal;

    public Date getFutureVal() {
        return futureVal;
    }

    public void setFutureVal(Date futureVal) {
        this.futureVal = futureVal;
    }

    public Date getFutureOrPresentVal() {
        return futureOrPresentVal;
    }

    public void setFutureOrPresentVal(Date futureOrPresentVal) {
        this.futureOrPresentVal = futureOrPresentVal;
    }

    public Date getPastVal() {
        return pastVal;
    }

    public void setPastVal(Date pastVal) {
        this.pastVal = pastVal;
    }

    public Date getPastOrPresentVal() {
        return pastOrPresentVal;
    }

    public void setPastOrPresentVal(Date pastOrPresentVal) {
        this.pastOrPresentVal = pastOrPresentVal;
    }

    @Override
    public String toString() {
        return "JsrAtFutureOrPastOrPresentBo{" +
                "futureVal=" + futureVal +
                ", futureOrPresentVal=" + futureOrPresentVal +
                ", pastVal=" + pastVal +
                ", pastOrPresentVal=" + pastOrPresentVal +
                '}';
    }

}
