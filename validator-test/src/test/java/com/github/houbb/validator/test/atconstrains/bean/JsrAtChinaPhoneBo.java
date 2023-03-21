package com.github.houbb.validator.test.atconstrains.bean;


import com.github.houbb.validator.core.annotation.constraint.ChinaIdNo;
import com.github.houbb.validator.core.annotation.constraint.ChinaPhone;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

/**
 * 手机
 * @since 0.5.0
 */
public class JsrAtChinaPhoneBo {

    @ChinaPhone
    private String chinaPhoneVal;

    public String getChinaPhoneVal() {
        return chinaPhoneVal;
    }

    public void setChinaPhoneVal(String chinaPhoneVal) {
        this.chinaPhoneVal = chinaPhoneVal;
    }

}
