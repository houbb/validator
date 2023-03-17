package com.github.houbb.validator.core.api.validator.context;

import com.github.houbb.validator.api.api.fail.IFail;
import com.github.houbb.validator.api.api.validator.IValidEntry;
import com.github.houbb.validator.api.api.validator.IValidatorContext;

import java.util.List;

/**
 * 默认验证器上下文
 * @author binbin.hou
 * @since 0.1.0
 */
public class DefaultValidatorContext implements IValidatorContext {

    private Object value;

    private IFail fail;

    private Class[] group;

    private List<IValidEntry> validatorEntries;

    public static DefaultValidatorContext newInstance() {
        return new DefaultValidatorContext();
    }

    @Override
    public Object value() {
        return value;
    }

    public DefaultValidatorContext value(Object value) {
        this.value = value;
        return this;
    }

    @Override
    public IFail fail() {
        return fail;
    }

    public DefaultValidatorContext fail(IFail fail) {
        this.fail = fail;
        return this;
    }

    @Override
    public Class[] group() {
        return group;
    }

    public DefaultValidatorContext group(Class[] group) {
        this.group = group;
        return this;
    }

    @Override
    public List<IValidEntry> validatorEntries() {
        return validatorEntries;
    }

    public DefaultValidatorContext validatorEntries(List<IValidEntry> validatorEntries) {
        this.validatorEntries = validatorEntries;
        return this;
    }
}
