package com.github.houbb.validator.test.model.condition;

import com.github.houbb.validator.core.annotation.condition.EqualsCondition;
import com.github.houbb.validator.core.annotation.condition.NotEqualsCondition;
import com.github.houbb.validator.core.annotation.constraint.Ranges;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 注解在当前字段上
 * @author binbin.hou
 * @since 0.1.3
 */
public class ConditionUser {

    /**
     * 操作类型
     */
    @Ranges({"create", "edit"})
    private String operType;

    /**
     * 新建时，name 必填
     */
    @EqualsCondition(value = "create", fieldName = "operType")
    @Size(min = 3)
    @NotNull
    private String name;

    /**
     * 不是新建时, id 字段必填
     */
    @NotEqualsCondition(value = "create", fieldName = "operType")
    @Size(min = 16)
    private String id;

    public String operType() {
        return operType;
    }

    public ConditionUser operType(String operType) {
        this.operType = operType;
        return this;
    }

    public String name() {
        return name;
    }

    public ConditionUser name(String name) {
        this.name = name;
        return this;
    }

    public String id() {
        return id;
    }

    public ConditionUser id(String id) {
        this.id = id;
        return this;
    }
}
