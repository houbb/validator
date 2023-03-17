package com.github.houbb.validator.core.api.fail;

import com.github.houbb.validator.api.constant.enums.FailTypeEnum;

/**
 * fail over 实现
 * @author binbin.hou
 * @since 0.2.0
 */
public class FailOver extends AbstractFail {

    @Override
    protected FailTypeEnum failType() {
        return FailTypeEnum.FAIL_OVER;
    }

}
