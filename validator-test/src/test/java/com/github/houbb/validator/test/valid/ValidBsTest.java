package com.github.houbb.validator.test.valid;

import com.github.houbb.validator.api.api.constraint.IConstraint;
import com.github.houbb.validator.api.api.result.IResult;
import com.github.houbb.validator.core.api.constraint.chain.ConstraintChains;
import com.github.houbb.validator.core.api.fail.Fails;
import com.github.houbb.validator.core.api.validator.DefaultValidator;
import com.github.houbb.validator.core.bs.ValidBs;
import com.github.houbb.validator.core.api.constraint.Constraints;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author binbin.hou
 * @since 0.0.2
 */
public class ValidBsTest {

    /**
     * @since 0.1.2
     */
    @Test
    public void helloValidTest() {
        IResult result = ValidBs.on(null, Constraints.notNull())
                .valid()
                .print();
        Assert.assertFalse(result.pass());
    }

    /**
     * @since 0.1.2
     */
    @Test
    public void helloValidAllConfigTest() {
        IResult result = ValidBs.on(null, Constraints.notNull())
                .fail(Fails.failFast())
                .group()
                .validator(DefaultValidator.getInstance())
                .valid()
                .print();
        Assert.assertFalse(result.pass());
    }

    /**
     * 约束链测试
     * @since 0.0.4
     */
    @Test
    public void constraintChainTest() {
        final IConstraint constraintChain = ConstraintChains.chain(Constraints.size(5, 10),
                Constraints.size(10, 20));

        ValidBs.on("12", constraintChain)
                .fail(Fails.failOver())
                .valid()
                .print();
    }

    /**
     * 多个约束条件测试
     * @since 0.0.5
     */
    @Test
    public void multiConstraintTest() {
        IResult result = ValidBs
                .on("12", Constraints.size(5, 10),
                        Constraints.size(10, 20))
                .fail(Fails.failOver())
                .valid();

        Assert.assertEquals(2, result.notPassList().size());
        result.print();
    }

}
