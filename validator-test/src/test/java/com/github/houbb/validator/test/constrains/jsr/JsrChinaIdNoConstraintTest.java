package com.github.houbb.validator.test.constrains.jsr;

import com.github.houbb.idcard.tool.basic.util.IdCardUtil;
import com.github.houbb.validator.api.api.result.IResult;
import com.github.houbb.validator.core.api.constraint.Constraints;
import com.github.houbb.validator.core.util.InnerIdCardValidHelper;
import com.github.houbb.validator.core.util.ValidHelper;
import org.junit.Assert;
import org.junit.Test;

/**
 * 身份证
 * @since 0.5.0
 */
public class JsrChinaIdNoConstraintTest {

    @Test
    public void assertFalseTest() {
        IResult result1 = ValidHelper.failOver("340225187001101234", Constraints.chinaIdNo());
        Assert.assertFalse(result1.pass());

        IResult result2 = ValidHelper.failOver("340225187001101237", Constraints.chinaIdNo());
        Assert.assertFalse(result2.pass());
    }


    @Test
    public void assertTrueTest() {
        String value = "500233199005052860";
        IResult result1 = ValidHelper.failOver(value, Constraints.chinaIdNo());
        Assert.assertTrue(result1.pass());
    }

    @Test
    public void checkDigitTest() {
        String text = "500233199005052860";
        System.out.println(InnerIdCardValidHelper.getCheckDigit(text));
    }

}
