package com.github.houbb.validator.test.atconstrains.jsr;

import com.github.houbb.heaven.util.util.DateUtil;
import com.github.houbb.validator.api.api.result.IResult;
import com.github.houbb.validator.core.api.constraint.Constraints;
import com.github.houbb.validator.core.util.ValidHelper;
import com.github.houbb.validator.test.atconstrains.bean.JsrAtChinaPhoneBo;
import com.github.houbb.validator.test.atconstrains.bean.JsrAtFutureOrPastOrPresentBo;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class JsrAtChinaPhoneTest {

    @Test
    public void assertFalseTest() {
        JsrAtChinaPhoneBo bo = new JsrAtChinaPhoneBo();
        bo.setChinaPhoneVal("01234567890");

        IResult result1 = ValidHelper.failOver(bo);
        Assert.assertFalse(result1.pass());
    }


    @Test
    public void assertTrueTest() {
        String mobile = "13112345678";
        IResult result1 = ValidHelper.failOver(mobile, Constraints.chinaPhone());
        Assert.assertTrue(result1.pass());
    }

}
