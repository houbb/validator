package com.github.houbb.validator.test.atconstrains.jsr;

import com.github.houbb.validator.api.api.result.IResult;
import com.github.houbb.validator.core.api.constraint.Constraints;
import com.github.houbb.validator.core.util.InnerIdCardValidHelper;
import com.github.houbb.validator.core.util.ValidHelper;
import com.github.houbb.validator.test.atconstrains.bean.JsrAtChinaIdNoBo;
import org.junit.Assert;
import org.junit.Test;

/**
 * 身份证
 * @since 0.5.0
 */
public class JsrChinaIdNoTest {

    @Test
    public void assertFalseTest() {
        JsrAtChinaIdNoBo bo = new JsrAtChinaIdNoBo();
        bo.setChinaIdNoVal("340225187001101234");

        IResult result1 = ValidHelper.failOver(bo);
        Assert.assertFalse(result1.pass());
    }


    @Test
    public void assertTrueTest() {
        JsrAtChinaIdNoBo bo = new JsrAtChinaIdNoBo();
        bo.setChinaIdNoVal("500233199005052860");
        IResult result1 = ValidHelper.failOver(bo);
        Assert.assertTrue(result1.pass());
    }

}
