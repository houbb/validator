package com.github.houbb.validator.core.api.fail;

import com.github.houbb.validator.api.constant.enums.FailTypeEnum;

/**
 * fail fast 实现
 * @author binbin.hou
 * @since 0.2.0
 */
public class FailFast extends AbstractFail {

    @Override
    protected FailTypeEnum failType() {
        return FailTypeEnum.FAIL_FAST;
    }

}
