package com.github.houbb.validator.test.constrains.jsr;

import com.github.houbb.validator.api.api.result.IResult;
import com.github.houbb.validator.core.api.constraint.Constraints;
import com.github.houbb.validator.core.util.InnerIdCardValidHelper;
import com.github.houbb.validator.core.util.ValidHelper;
import org.junit.Assert;
import org.junit.Test;

/**
 * 身份证信息提示
 * @since 0.7.0
 */
public class JsrChinaIdNoConstraintMessageTest {

    @Test
    public void defaultMessageTest() {
        IResult result1 = ValidHelper.failOver("340225187001101234", Constraints.chinaIdNo());
        Assert.assertEquals("值 <340225187001101234> 不是预期值", result1.notPassList().get(0).message());
    }

    @Test
    public void defineMessageTest() {
        final String defineMessage = "身份证格式错误";
        IResult result1 = ValidHelper.failOver("340225187001101234", Constraints.chinaIdNo(), defineMessage);

        Assert.assertEquals(defineMessage, result1.notPassList().get(0).message());
    }

}
