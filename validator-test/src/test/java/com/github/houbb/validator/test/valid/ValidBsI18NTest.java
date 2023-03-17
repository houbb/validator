package com.github.houbb.validator.test.valid;

import com.github.houbb.validator.api.api.result.IResult;
import com.github.houbb.validator.core.bs.ValidBs;
import com.github.houbb.validator.core.api.constraint.Constraints;
import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;

/**
 * 国际化编码验证
 * @author binbin.hou
 * @since 0.1.2
 */
public class ValidBsI18NTest {

    /**
     * i18n 英文测试
     * @since 0.1.2
     */
    @Test
    public void i18nEnTest() {
        Locale.setDefault(Locale.ENGLISH);
        IResult result = ValidBs.on(null, Constraints.notNullConstraint())
                .valid()
                .print();

        Assert.assertEquals("Expect is <not null>, but actual is <null>.", result.notPassList().get(0).message());
    }

    /**
     * i18n 中文测试
     * @since 0.1.2
     */
    @Test
    public void i18nZhTest() {
        Locale.setDefault(Locale.CHINESE);
        IResult result = ValidBs.on(null, Constraints.notNullConstraint())
                .valid()
                .print();

        Assert.assertEquals("预期值为 <not null>，实际值为 <null>", result.notPassList().get(0).message());
    }

}
