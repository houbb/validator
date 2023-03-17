package com.github.houbb.validator.core.api.result.result;

import com.github.houbb.heaven.support.handler.IHandler;
import com.github.houbb.heaven.util.lang.StringUtil;
import com.github.houbb.heaven.util.util.CollectionUtil;
import com.github.houbb.validator.api.api.constraint.IConstraintResult;
import com.github.houbb.validator.api.api.result.IResult;
import com.github.houbb.validator.api.exception.ValidRuntimeException;

import java.util.List;

/**
 * 默认结果
 * @author binbin.hou
 * @since 0.2.0
 */
public class DefaultResult implements IResult {

    /**
     * 是否全部通过验证
     * @since 0.2.0
     */
    private boolean pass;

    /**
     * 未通过的列表信息
     * @since 0.2.0
     */
    private List<IConstraintResult> notPassList;

    /**
     * 所有的验证结果列表
     * @since 0.2.0
     */
    private List<IConstraintResult> allList;

    public static DefaultResult newInstance() {
        return new DefaultResult();
    }

    @Override
    public boolean pass() {
        return pass;
    }

    public DefaultResult pass(boolean pass) {
        this.pass = pass;
        return this;
    }

    @Override
    public List<IConstraintResult> notPassList() {
        return notPassList;
    }

    public DefaultResult notPassList(List<IConstraintResult> notPassList) {
        this.notPassList = notPassList;
        return this;
    }

    @Override
    public List<IConstraintResult> allList() {
        return allList;
    }

    @Override
    public IResult print() {
        System.out.println(this);
        return this;
    }

    @Override
    public IResult throwsEx() {
        if(!pass) {
            //fixed: 0.1.4 提示所有的消息
            List<String> failMessages = CollectionUtil.toList(this.notPassList, new IHandler<IConstraintResult, String>() {
                @Override
                public String handle(IConstraintResult iConstraintResult) {
                    return iConstraintResult.message();
                }
            });

            final String message = StringUtil.join(failMessages);
            throw new ValidRuntimeException(message);
        }
        return this;
    }

    public DefaultResult allList(List<IConstraintResult> allList) {
        this.allList = allList;
        return this;
    }

    @Override
    public String toString() {
        return "DefaultResult{" +
                "pass=" + pass +
                ", notPassList=" + notPassList +
                ", allList=" + allList +
                '}';
    }
}
