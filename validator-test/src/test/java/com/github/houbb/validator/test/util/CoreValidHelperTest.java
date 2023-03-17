package com.github.houbb.validator.test.util;

import com.github.houbb.validator.api.exception.ValidRuntimeException;
import com.github.houbb.validator.core.util.ValidHelper;
import com.github.houbb.validator.test.model.User;
import org.junit.Test;

/**
 * ValidHelper 测试工具类
 *
 * @author binbin.hou
 * @since 0.1.4
 */
public class CoreValidHelperTest {

    @Test
    public void failOverTest() {
        try {
            User user = new User();
            user.sex("what").password("old").password2("new");

            ValidHelper.failOverThrow(user);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Test(expected = ValidRuntimeException.class)
    public void failFastTest() {
        User user = new User();
        user.sex("what").password("old").password2("new");

        ValidHelper.failFastThrow(user);
    }

}
