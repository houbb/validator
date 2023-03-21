package com.github.houbb.validator.test.atconstrains.jsr;

import com.github.houbb.heaven.util.util.DateUtil;
import com.github.houbb.validator.api.api.result.IResult;
import com.github.houbb.validator.core.util.ValidHelper;
import com.github.houbb.validator.test.atconstrains.bean.JsrAtFutureOrPastOrPresentBo;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class JsrAtFutureOrPastOrPresentTest {

    @Test
    public void assertTrueTest() {
        Date pastTime = DateUtil.parseDate("2023-01-01", "yyyy-MM-dd");
        Date futureTime = DateUtil.parseDate("2099-03-21", "yyyy-MM-dd");

        // 设置
        JsrAtFutureOrPastOrPresentBo bo = new JsrAtFutureOrPastOrPresentBo();
        bo.setPastVal(pastTime);
        bo.setPastOrPresentVal(pastTime);
        bo.setFutureVal(futureTime);
        bo.setFutureOrPresentVal(futureTime);

        IResult result = ValidHelper.failOver(bo);
        Assert.assertTrue(result.pass());
    }

    @Test
    public void assertFalseTest() {
        Date pastTime = DateUtil.parseDate("2023-01-01", "yyyy-MM-dd");
        Date futureTime = DateUtil.parseDate("2099-03-21", "yyyy-MM-dd");

        // 设置
        JsrAtFutureOrPastOrPresentBo bo = new JsrAtFutureOrPastOrPresentBo();
        bo.setPastVal(futureTime);
        bo.setPastOrPresentVal(futureTime);
        bo.setFutureVal(pastTime);
        bo.setFutureOrPresentVal(pastTime);

        IResult result = ValidHelper.failOver(bo);
        Assert.assertFalse(result.pass());
        Assert.assertEquals(4, result.notPassList().size());
    }

}
