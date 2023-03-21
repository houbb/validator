package com.github.houbb.validator.core.jsr.util;

import com.github.houbb.heaven.util.lang.reflect.ClassUtil;
import com.github.houbb.validator.api.api.constraint.annotation.IAnnotationConstraint;
import com.github.houbb.validator.core.jsr.constraint.annotation.*;
import org.hibernate.validator.constraints.*;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.constraints.br.TituloEleitoral;
import org.hibernate.validator.constraints.pl.NIP;
import org.hibernate.validator.constraints.pl.PESEL;
import org.hibernate.validator.constraints.pl.REGON;
import org.hibernate.validator.constraints.time.DurationMax;
import org.hibernate.validator.constraints.time.DurationMin;

import javax.validation.Constraint;
import javax.validation.constraints.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

/**
 *  注解与约束关系
 *
 *  https://jakarta.ee/specifications/bean-validation/3.0/jakarta-bean-validation-spec-3.0.html
 * @see Constraint#validatedBy() 属性。
 * @author binbin.hou
 * @since 0.1.1
 */
public final class JsrAtConstraintMapUtil {

    private JsrAtConstraintMapUtil() {
    }

    //FIXED 1.6.0 避免相同的注解，属性被覆盖。
    private static final Map<Class<? extends Annotation>, Class<? extends IAnnotationConstraint>> MAP;

    static {
        MAP = new HashMap<>(32);

        //JSR 标准 ----------------------------------------------------------------------------
        MAP.put(Null.class, AtNullConstraint.class);
        MAP.put(NotNull.class, AtNotNullConstraint.class);
        MAP.put(AssertTrue.class, AtAssertTrueConstraint.class);
        MAP.put(AssertFalse.class, AtAssertFalseConstraint.class);
        MAP.put(Past.class, AtPastConstraint.class);
        MAP.put(PastOrPresent.class, AtPastOrPresentConstraint.class);
        MAP.put(Future.class, AtFutureConstraint.class);
        MAP.put(FutureOrPresent.class, AtFutureOrPresentConstraint.class);
        MAP.put(Pattern.class, AtPatternConstraint.class);
        MAP.put(Size.class, AtSizeConstraint.class);
        MAP.put(Min.class, AtMinConstraint.class);
        MAP.put(Max.class, AtMaxConstraint.class);
        MAP.put(DecimalMax.class, AtDecimalMaxConstraint.class);
        MAP.put(DecimalMin.class, AtDecimalMinConstraint.class);
        MAP.put(Digits.class, AtDigitsConstraint.class);

        //JSR 2.0
        MAP.put(Email.class, AtEmailConstraint.class);
        MAP.put(NotBlank.class, AtNotBlankConstraint.class);
        MAP.put(NotEmpty.class, AtNotEmptyConstraint.class);
        MAP.put(Positive.class, AtPositiveConstraint.class);
        MAP.put(PositiveOrZero.class, AtPositiveOrZeroConstraint.class);
        MAP.put(Negative.class, AtNegativeConstraint.class);
        MAP.put(NegativeOrZero.class, AtNegativeOrZeroConstraint.class);


        //hibernate-validator ----------------------------------------------------------------------------
        MAP.put(org.hibernate.validator.constraints.Email.class, AtEmailConstraintHibernate.class);
        MAP.put(org.hibernate.validator.constraints.NotBlank.class, AtNotBlankConstraintHibernate.class);
        MAP.put(org.hibernate.validator.constraints.NotEmpty.class, AtNotEmptyConstraintHibernate.class);
        MAP.put(Length.class, AtLengthConstraintHibernate.class);
        MAP.put(UniqueElements.class, AtUniqueElementsConstraintHibernate.class);
        MAP.put(URL.class, AtURLConstraintHibernate.class);

        // not support
        MAP.put(DurationMax.class, AtDurationMaxConstraintHibernate.class);
        MAP.put(DurationMin.class, AtDurationMinConstraintHibernate.class);
        MAP.put(CNPJ.class, AtCNPJConstraintHibernate.class);
        MAP.put(CPF.class, AtCPFConstraintHibernate.class);
        MAP.put(CodePointLength.class, AtCodePointLengthConstraintHibernate.class);
        MAP.put(CreditCardNumber.class, AtCreditCardNumberConstraintHibernate.class);
        MAP.put(EAN.class, AtEANConstraintHibernate.class);
        MAP.put(ISBN.class, AtISBNConstraintHibernate.class);
        MAP.put(LuhnCheck.class, AtLuhnCheckConstraintHibernate.class);
        MAP.put(Mod10Check.class, AtMod10CheckConstraintHibernate.class);
        MAP.put(Mod11Check.class, AtMod11CheckConstraintHibernate.class);
        MAP.put(NIP.class, AtNIPConstraintHibernate.class);
        MAP.put(Normalized.class, AtNormalizedConstraintHibernate.class);
        MAP.put(ParameterScriptAssert.class, AtParameterScriptAssertConstraintHibernate.class);
        MAP.put(PESEL.class, AtPESELConstraintHibernate.class);
        MAP.put(REGON.class, AtREGONConstraintHibernate.class);
        MAP.put(ScriptAssert.class, AtScriptAssertConstraintHibernate.class);
        MAP.put(TituloEleitoral.class, AtTituloEleitoralConstraintHibernate.class);
    }

    /**
     * 获取对应的内置注解实现类
     * @param clazz 注解类信息
     * @return 注解实现
     * @since 0.1.1
     */
    public static IAnnotationConstraint get(final Class<? extends Annotation> clazz) {
        Class<? extends IAnnotationConstraint> annotationClazz = MAP.get(clazz);
        // 判空
        if(annotationClazz != null) {
            return ClassUtil.newInstance(annotationClazz);
        }
        return null;
    }

}
