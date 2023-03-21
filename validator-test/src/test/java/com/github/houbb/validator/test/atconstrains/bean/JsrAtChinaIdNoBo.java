package com.github.houbb.validator.test.atconstrains.bean;


import com.github.houbb.validator.core.annotation.constraint.ChinaIdNo;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

/**
 *
 * @since 0.6.0
 */
public class JsrAtChinaIdNoBo {

    @ChinaIdNo
    private String chinaIdNoVal;

    public String getChinaIdNoVal() {
        return chinaIdNoVal;
    }

    public void setChinaIdNoVal(String chinaIdNoVal) {
        this.chinaIdNoVal = chinaIdNoVal;
    }
}
