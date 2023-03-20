package com.github.houbb.validator.test.util;

import com.github.houbb.validator.api.api.result.IResult;
import com.github.houbb.validator.api.exception.ValidRuntimeException;
import com.github.houbb.validator.core.util.ValidHelper;
import com.github.houbb.validator.test.model.User;
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

}
