package com.github.houbb.validator.test.util;

import com.github.houbb.validator.api.api.result.IResult;
import com.github.houbb.validator.api.exception.ValidRuntimeException;
import com.github.houbb.validator.core.api.constraint.Constraints;
import com.github.houbb.validator.core.util.ValidHelper;
import com.github.houbb.validator.test.model.User;
import org.junit.Assert;
import org.junit.Test;

/**
 * ValidHelper 测试工具类
 *
 * @author binbin.hou
 * @since 0.3.0
 */
public class ValidHelperTest {

    @Test
    public void failFastTest() {
        User user = new User();
        user.sex("what").password("old").password2("new");

        IResult result = ValidHelper.failFast(user);
        System.out.println(result);
    }

    @Test
    public void failOverTest() {
        User user = new User();
        user.sex("what").password("old").password2("new");

        IResult result = ValidHelper.failOver(user);
        System.out.println(result);
    }

    @Test(expected = ValidRuntimeException.class)
    public void failOverThrowTest() {
        User user = new User();
        user.sex("what").password("old").password2("new");

        ValidHelper.failOverThrow(user);
    }

    @Test(expected = ValidRuntimeException.class)
    public void failFastThrowTest() {
        User user = new User();
        user.sex("what").password("old").password2("new");

        ValidHelper.failFastThrow(user);
    }

    /**
     * @since 0.4.0
     */
    @Test
    public void failFastAttrTest() {
        IResult result = ValidHelper.failFast("", Constraints.notEmpty());
        Assert.assertFalse(result.pass());
        System.out.println(result);
    }


    @Test
    public void failOverAttrTest() {
        IResult result = ValidHelper.failOver("", Constraints.notEmpty());
        Assert.assertFalse(result.pass());
        System.out.println(result);
    }

    /**
     * @since 0.4.0
     */
    @Test(expected = ValidRuntimeException.class)
    public void failFastThrowAttrTest() {
        ValidHelper.failFastThrow("", Constraints.notEmpty());
    }

    /**
     * @since 0.4.0
     */
    @Test(expected = ValidRuntimeException.class)
    public void failOverThrowAttrTest() {
        ValidHelper.failOverThrow("", Constraints.notEmpty());
    }

}
