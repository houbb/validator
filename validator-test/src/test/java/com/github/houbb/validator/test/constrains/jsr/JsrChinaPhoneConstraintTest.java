package com.github.houbb.validator.test.constrains.jsr;

import com.github.houbb.phone.tool.util.PhoneUtil;
import com.github.houbb.validator.api.api.result.IResult;
import com.github.houbb.validator.core.api.constraint.Constraints;
import com.github.houbb.validator.core.util.ValidHelper;
import org.junit.Assert;
import org.junit.Test;

/**
 * 手机号
 * @since 0.5.0
 */
public class JsrChinaPhoneConstraintTest {

    @Test
    public void assertFalseTest() {
        IResult result1 = ValidHelper.failOver("01234567890", Constraints.chinaPhone());
        Assert.assertFalse(result1.pass());

        IResult result2 = ValidHelper.failOver("xxxxyyyyxxx", Constraints.chinaPhone());
        Assert.assertFalse(result2.pass());
    }


    @Test
    public void assertTrueTest() {
        String mobile = "13112345678";
        IResult result1 = ValidHelper.failOver(mobile, Constraints.chinaPhone());
        Assert.assertTrue(result1.pass());
    }

}
