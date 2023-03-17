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
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

/**
 *  注解与约束关系
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
        MAP.put(Null.class, AtNullConstraint.class);
        MAP.put(NotNull.class, AtNotNullConstraint.class);
        MAP.put(AssertTrue.class, AtAssertTrueConstraint.class);
        MAP.put(AssertFalse.class, AtAssertFalseConstraint.class);
        MAP.put(Past.class, AtPastConstraint.class);
        MAP.put(Future.class, AtFutureConstraint.class);
        MAP.put(Pattern.class, AtPatternConstraint.class);
        MAP.put(Size.class, AtSizeConstraint.class);
        MAP.put(Min.class, AtMinConstraint.class);
        MAP.put(Max.class, AtMaxConstraint.class);
        MAP.put(DecimalMax.class, AtDecimalMaxConstraint.class);
        MAP.put(DecimalMin.class, AtDecimalMinConstraint.class);
        MAP.put(Digits.class, AtDigitsConstraint.class);

        //hibernate-validator
        MAP.put(CNPJ.class, AtCNPJConstraint.class);
        MAP.put(CodePointLength.class, AtCodePointLengthConstraint.class);
        MAP.put(CPF.class, AtCPFConstraint.class);
        MAP.put(CreditCardNumber.class, AtCreditCardNumberConstraint.class);
        MAP.put(EAN.class, AtEANConstraint.class);
        MAP.put(Email.class, AtEmailConstraint.class);
        MAP.put(ISBN.class, AtISBNConstraint.class);
        MAP.put(Length.class, AtLengthConstraint.class);
        MAP.put(LuhnCheck.class, AtLuhnCheckConstraint.class);
        MAP.put(Mod10Check.class, AtMod10CheckConstraint.class);
        MAP.put(Mod11Check.class, AtMod11CheckConstraint.class);
        MAP.put(NIP.class, AtNIPConstraint.class);
        MAP.put(Normalized.class, AtNormalizedConstraint.class);
        MAP.put(NotBlank.class, AtNotBlankConstraint.class);
        MAP.put(NotEmpty.class, AtNotEmptyConstraint.class);
        MAP.put(ParameterScriptAssert.class, AtParameterScriptAssertConstraint.class);
        MAP.put(PESEL.class, AtPESELConstraint.class);
        MAP.put(REGON.class, AtREGONConstraint.class);
        MAP.put(ScriptAssert.class, AtScriptAssertConstraint.class);
        MAP.put(TituloEleitoral.class, AtTituloEleitoralConstraint.class);
        MAP.put(UniqueElements.class, AtUniqueElementsConstraint.class);
        MAP.put(URL.class, AtURLConstraint.class);

        MAP.put(DurationMax.class, AtURLConstraint.class);
        MAP.put(DurationMin.class, AtURLConstraint.class);
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
