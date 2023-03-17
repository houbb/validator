package com.github.houbb.validator.test.util;

import com.github.houbb.validator.api.exception.ValidRuntimeException;
import com.github.houbb.validator.core.util.ValidatorHelper;
import com.github.houbb.validator.test.model.User;
import org.junit.Test;

/**
 * ValidHelper 测试工具类
 *
 * @author binbin.hou
 * @since 0.1.4
 */
public class CoreValidHelperTest {

    @Test(expected = ValidRuntimeException.class)
    public void failFastTest() {
        User user = new User();
        user.sex("what").password("old").password2("new");

        ValidatorHelper.failFastThrow(user);
    }

}
