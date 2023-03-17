package com.github.houbb.validator.core.jsr.constraint.annotation;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.validator.api.api.constraint.IConstraint;
import com.github.houbb.validator.core.api.constraint.annotation.AbstractAnnotationConstraint;
import com.github.houbb.validator.core.api.constraint.Constraints;
import org.hibernate.validator.constraints.br.CNPJ;

/**
 * CNPJ 信息
 * @author binbin.hou
 * @since 0.2.0
 */
@ThreadSafe
public class AtCNPJConstraint extends AbstractAnnotationConstraint<CNPJ> {

    @Override
    protected IConstraint buildConstraint(CNPJ annotation) {
        return Constraints.cnpjConstraint();
    }

}
