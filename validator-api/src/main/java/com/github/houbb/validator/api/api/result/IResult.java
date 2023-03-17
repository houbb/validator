package com.github.houbb.validator.api.api.result;

import com.github.houbb.validator.api.api.constraint.IConstraintResult;

import java.util.List;

/**
 * 结果接口
 * @author binbin.hou
 * @since 0.1.0
 */
public interface IResult {

    /**
     * 是否全部通过验证
     * @return 是否
     * @since 0.1.0
     */
    boolean pass();

    /**
     * 未通过的列表信息
     * @return 验证结果
     * @since 0.1.0
     */
    List<IConstraintResult> notPassList();

    /**
     * 所有的验证结果列表
     * @return 所有的验证结果
     * @since 0.1.0
     */
    List<IConstraintResult> allList();

    /**
     * 输出信息到控台
     * （1）主要是为了方便调整
     * （2）该功能其实可以做增强，比如输出到文件/数据库等等。
     * @return this
     * @since 0.0.6
     */
    IResult print();

    /**
     * 对于未通过的信息，
     * （1）未通过的界定。
     *  {@link IConstraintResult#pass()} 为 false
     *
     * （2）内容信息
     * 抛出运行时异常 {@link com.github.houbb.validator.api.exception.ValidRuntimeException}，异常信息为 {@link IConstraintResult#message()} 消息
     * （3）内容限定
     *  为了避免异常内容过多，只抛出第一条即可。
     *  （4）改方法的增强空间
     *  4.1 可以指定什么情况下抛出异常
     *  4.2 抛出异常的信息和类别
     *
     * @return this
     * @since 0.0.6
     */
    IResult throwsEx();

}
