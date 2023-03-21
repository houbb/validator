# 项目介绍

java 开发中，参数校验是非常常见的需求。但是 hibernate-validator 在使用过程中，依然会存在一些问题。

[validator](https://github.com/houbb/validator) 在 hibernate-validator 等校验工具之上，做了一些改进，使其使用更加便捷优雅，进一步提升工作效率。

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.houbb/validator/badge.svg)](http://mvnrepository.com/artifact/com.github.houbb/validator)
[![Build Status](https://www.travis-ci.org/houbb/validator.svg?branch=master)](https://www.travis-ci.org/houbb/validator?branch=master)
[![Coverage Status](https://coveralls.io/repos/github/houbb/validator/badge.svg?branch=master)](https://coveralls.io/github/houbb/validator?branch=master)

## 变更日志

> [变更日志](https://github.com/houbb/validator/blob/master/CHANGELOG.md)

## 特性

- 兼容实现 jakarta bean validation（jsr-303）内置注解 

- 兼容实现 hibernate-validation

- 支持 i18n

- 支持用户自定义策略

- 支持用户自定义注解

- 支持针对属性的校验

- 支持过程式编程与注解式编程

- 支持指定校验生效的条件

# 创作目的

## hibernate-validator 无法满足的场景

如今 java 最流行的 hibernate-validator 框架，但是有些场景是无法满足的。

比如：

1. 验证新密码和确认密码是否相同。(同一对象下的不同属性之间关系)

2. 当一个属性值满足某个条件时，才进行其他值的参数校验。

3. 多个属性值，至少有一个不能为 null

其实，在**对于多个字段的关联关系处理时，hibernate-validator 就会比较弱**。

本项目结合原有的优点，进行这一点的功能强化。

## validation-api 过于复杂

validation-api 提供了丰富的特性定义，也同时带来了一个问题。

实现起来，特别复杂。

然而我们实际使用中，常常不需要这么复杂的实现。

validator-api 提供了一套简化很多的 api，便于用户自行实现。

## 自定义缺乏灵活性

hibernate-validator 在使用中，自定义约束实现是基于注解的，针对单个属性校验不够灵活。

本项目中，**将属性校验约束和注解约束区分开，便于复用和拓展**。

## 过程式编程 vs 注解式编程

hibernate-validator 核心支持的是注解式编程，基于 bean 的校验。

一个问题是针对属性校验不灵活，有时候针对 bean 的校验，还是要自己写判断。

本项目支持 fluent-api 进行过程式编程，同时支持注解式编程。

尽可能兼顾灵活性与便利性。

# 快速开始

## 准备工作

JDK1.7+

Maven 3.X+

## maven 引入

```xml
<dependency>
    <groupId>com.github.houbb</groupId>
    <artifactId>validator-core</artifactId>
    <version>0.5.0</version>
</dependency>
```

## 快速入门

### 定义对象

第一步，我们定义一个常见的 java bean 对象，可以指定内置的注解。

支持 jsr-303 注解和 hibernate-validator 的注解。

```java
public class User {

    /**
     * 名称
     */
    @HasNotNull({"nickName"})
    private String name;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 原始密码
     */
    @AllEquals("password2")
    private String password;

    /**
     * 新密码
     */
    private String password2;

    /**
     * 性别
     */
    @Ranges({"boy", "girl"})
    private String sex;

    /**
     * 失败类型枚举
     */
    @EnumRanges(FailTypeEnum.class)
    private String failType;
    
    //getter & setter

}
```

### ValidHelper 工具方法

ValidHelper 作为统一封装的工具类，提供了 java bean 校验常见的方法。

方法列表：

| 序号  | 方法                            | 返回值     | 说明                                     |
|:----|:------------------------------|:--------|:---------------------------------------|
| 1   | failOver(Object object) | IResult | 全部验证后返回                                |
| 2   | failFast(Object object) | IResult | 快速验证后返回                                |
| 3   | failOverThrow(Object object) | void    | 全部验证后返回-未通过抛出 ValidRuntimeException 异常 |
| 4   | failFastThrow(Object object) | void    | 快速验证后返回-未通过抛出 ValidRuntimeException 异常 |

使用起来很简单，我们以 failFast 为例：

```java
// 对象定义
User user = new User();
user.sex("what").password("old").password2("new");

// 调用方法
IResult result = ValidHelper.failFast(user);
```

结果：

```
DefaultResult{pass=false, notPassList=[DefaultConstraintResult{pass=false, message='name: 值 <null> 不是预期值', value=null, constraint='HasNotNullConstraint', expectValue='', fieldName='name'}], allList=null}
```

- IResult 方法说明

返回值实现默认为 DefaultResult，接口 IResult 属性如下：

```java
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
```

# 注解说明

java bean 的校验，基于注解是比较方便的。和 hibernate-validator 使用类似，这里介绍下常见的注解。

## 内置约束注解

内置注解如下：

| 序号  | 注解                                | value()                 | 说明                |
|:----|:-----------------------------------|:------------------------|:------------------|
| 1   | `@AllEquals`                       | `String[]`              | 当前字段及其指定的字段 全部相等  |
| 2   | `@EnumRanges`                       | `Class<? extends Enum>` | 当前字段必须在枚举值指定的范围内 |
| 3   | `@HasNotNull`                       | `String[]`              | 当前字段及其指定的字段 至少有一个不为 null |
| 4   | `@Ranges`                       | `String[]`              | 当前字段必须在指定的范围内 |

## JSR-303 / jakarta bean validation 约束注解支持

> [jakarta-bean-validation-spec-3.0](https://jakarta.ee/specifications/bean-validation/3.0/jakarta-bean-validation-spec-3.0.html#builtinconstraints-futureorpresent)

| 序号  | 注解                 | 说明                 |
|:----|:-------------------|:-------------------|
| 1   | `@AssertTrue`      | 为 true 约束条件        |
| 2   | `@AssertFalse`     | 为 false 约束条件       |
| 3   | `@Null`            | 为 null 约束条件        |
| 4   | `@NotNull`         | 不为 null 约束条件       |
| 5   | `@Past`            | 是否在当前时间之前约束条件      |
| 6   | `@PastOrPresent`   | 是否在当前时间之前约束条件，包含当前 |
| 7   | `@Future`          | 是否在当前时间之后约束条件      |
| 8   | `@FutureOrPresent` | 是否在当前时间之后约束条件，包含当前 |
| 9   | `@Pattern`         | 正则表达式约束条件          |
| 10  | `@Size`            | 在指定范围内的约束条件        |
| 11  | `@Digits`          | 数字位数的约束条件          |
| 12  | `@DecimalMax`      | 最大数字的约束条件          |
| 13  | `@DecimalMin`      | 最小数字的约束条件          |
| 14  | `@Min`             | 最小的约束条件            |
| 15  | `@Max`             | 最大的约束条件            |
| 16  | `@NotBlank`        | 不能为空格的约束条件         |
| 17  | `@NotEmpty`        | 不能为空的约束条件          |
| 18  | `@Email`           | Email 约束条件         |
| 19  | `@Negative`        | 指定值必须为负数约束条件       |
| 20  | `@NegativeOrZero`  | 指定值必须为负数约束条件，包含0       |
| 21  | `@Positive`        | 指定值必须为正数约束条件       |
| 22  | `@PositiveOrZero`  | 指定值必须为正数约束条件，包含0   |

## hibernate-validator 约束注解支持

> [hibernate-validator 内置注解](https://docs.jboss.org/hibernate/validator/8.0/reference/en-US/html_single/#section-builtin-constraints)

实现了常见的几个，后续将陆续完善：

| 序号  | 注解                  | 说明                 |
|:----|:--------------------|:-------------------|
| 1   | `@NotBlank`         | 不能为空格的约束条件         |
| 2   | `@NotEmpty`         | 不能为空的约束条件          |
| 3   | `@Length`           | 长度的约束条件            |
| 4   | `@URL`              | URL 约束条件           |
| 5   | `@Email`            | Email 约束条件         |
| 6   | `@UniqueElements`   | 元素唯一约束条件           |
| 7   | `@Range`            | 指定范围元素约束条件         |

# 条件注解

## 说明

有时候我们需要根据不同的参数，进行不同的限制条件。

比如新建时用户 id 不需要传入，但是修改时 id 必填。

如果是传统的 hibernate-validator 处理就会比较麻烦，此处引入条件注解。

## 内置注解 

| 序号  | 注解                      | 说明        |
|:----|:------------------------|:----------|
| 1   | `@EqualsCondition`      | 等于指定值的条件  |
| 2   | `@NotEqualsCondition`   | 不等于指定值的条件 |
| 3   | `@AlwaysTrueCondition`  | 永远生效的条件   |
| 4   | `@AlwaysFalseCondition` | 永远不生效的条件  |

## 使用

使用起来也不难，下面的效果如下：

1. operType == 'create' 时，name 的校验才会生效。
2. operType != 'create' 时，id 的校验才会生效。

其他使用方式保持不变。

```java
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
    
    //getter & setter
}
```

# 过程式接口

## 说明

日常开发中，我们都很喜欢使用注解对 java bean 进行校验。

但是这回导致我们定义的单个属性校验无法复用。

所以项目中的单个属性校验和注解是一一对应的，为了便于复用。

## ValidHelper 方法

ValidHelper 作为统一封装的工具类，提供单个方法校验常见的方法。

和 java bean 类似，方法列表：

| 序号  | 方法                                 | 返回值     | 说明                                     |
|:----|:-----------------------------------|:--------|:---------------------------------------|
| 1   | failOver(Object object, IConstraint constraint)    | IResult | 全部验证后返回                                |
| 2   | failFast(Object object, IConstraint constraint)      | IResult | 快速验证后返回                                |
| 3   | failOverThrow(Object object, IConstraint constraint) | void    | 全部验证后返回-未通过抛出 ValidRuntimeException 异常 |
| 4   | failFastThrow(Object object, IConstraint constraint) | void    | 快速验证后返回-未通过抛出 ValidRuntimeException 异常 |

## 使用例子

用法和 bean 的类似，只是入参多了第二个约束条件。

```java
IResult result = ValidHelper.failFast("", Constraints.notEmpty());
```

## IConstraint 对应关系

注解和常见的接口方法一一对应，所有的约束方法在 `Constraints` 工具类中。 

### JSR-303 / jakarta bean validation 约束注解支持

| 序号  | 注解                 | 说明                 | 对应方法              |
|:----|:-------------------|:-------------------|:------------------|
| 1   | `@AssertTrue`      | 为 true 约束条件        | assertTrue()      |
| 2   | `@AssertFalse`     | 为 false 约束条件       | assertFalse()     |
| 3   | `@Null`            | 为 null 约束条件        | nulls()           |
| 4   | `@NotNull`         | 不为 null 约束条件       | notNulls()        |
| 5   | `@Past`            | 是否在当前时间之前约束条件      | past()            |
| 6   | `@PastOrPresent`   | 是否在当前时间之前约束条件，包含当前 | pastOrPresent()   |
| 7   | `@Future`          | 是否在当前时间之后约束条件      | future()          |
| 8   | `@FutureOrPresent` | 是否在当前时间之后约束条件，包含当前 | futureOrPresent() |
| 9   | `@Pattern`         | 正则表达式约束条件          | pattern()         |
| 10  | `@Size`            | 在指定范围内的约束条件        | size()            |
| 11  | `@Digits`          | 数字位数的约束条件          | digits()          |
| 12  | `@DecimalMax`      | 最大数字的约束条件          | decimalMax()      |
| 13  | `@DecimalMin`      | 最小数字的约束条件          | decimalMin()      |
| 14  | `@Min`             | 最小的约束条件            | min()             |
| 15  | `@Max`             | 最大的约束条件            | max()             |
| 16  | `@NotBlank`        | 不能为空格的约束条件         | notBlank()        |
| 17  | `@NotEmpty`        | 不能为空的约束条件          | notEmpty()        |
| 18  | `@Email`           | Email 约束条件         | email()           |
| 19  | `@Negative`        | 指定值必须为负数约束条件       | negative()        |
| 20  | `@NegativeOrZero`  | 指定值必须为负数约束条件，包含0       | negativeOrZero()  |
| 21  | `@Positive`        | 指定值必须为正数约束条件       | positive()        | 
| 22  | `@PositiveOrZero`  | 指定值必须为正数约束条件，包含0   | positiveOrZero()  |

### ## hibernate-validator 约束注解支持

实现了常见的几个，后续将陆续完善：

| 序号  | 注解                  | 说明                 | 对应方法             |
|:----|:--------------------|:-------------------|:-----------------|
| 1   | `@NotBlank`         | 不能为空格的约束条件         | notBlank()       |
| 2   | `@NotEmpty`         | 不能为空的约束条件          | notEmpty()       |
| 5   | `@Email`            | Email 约束条件         | email()          |
| 3   | `@Length`           | 长度的约束条件            | length()         |
| 4   | `@URL`              | URL 约束条件           | url()            |
| 6   | `@UniqueElements`   | 元素唯一约束条件           | uniqueElements() |
| 7   | `@Range`            | 指定范围元素约束条件         | range()          |

## 条件注解

注解和常见的接口方法一一对应，所有的约束方法在 `Conditions` 工具类中。

| 序号  | 注解                      | 说明        | 对应方法          |
|:----|:------------------------|:----------|:--------------|
| 1   | `@EqualsCondition`      | 等于指定值的条件  | equals()      |
| 2   | `@NotEqualsCondition`   | 不等于指定值的条件 | notEquals()   |
| 3   | `@AlwaysTrueCondition`  | 永远生效的条件   | alwaysTrue()  |
| 4   | `@AlwaysFalseCondition` | 永远不生效的条件  | alwaysFalse() |

# 注解自定义

## 说明

内置的注解，自然无法满足所有的场景。

本项目中，约束和条件注解都是支持自定义的。

## 约束注解 @Constraint

所有系统的内置注解都可以作为学习的例子。

### 定义注解

以 `@AllEquals` 为例，核心的部分在 `@Constraint(AtAllEqualsConstraint.class)`。

我们在 AtAllEqualsConstraint 中实现具体的约束逻辑。

```java
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(AtAllEqualsConstraint.class)
public @interface AllEquals {

    /**
     * 当前字段及其指定的字段 全部相等
     * 1. 字段类型及其他字段相同
     * @return 指定的字段列表
     */
    String[] value();

    /**
     * 提示消息
     * @return 错误提示
     */
    String message() default "";

    /**
     * 分组信息
     * @return 分组类
     * @since 0.1.2
     */
    Class[] group() default {};

}
```

### 实现逻辑

推荐直接继承 `AbstractAnnotationConstraint<A>`，实现对应的逻辑即可。

```java
public class AtAllEqualsConstraint extends AbstractAnnotationConstraint<AllEquals> {

    @Override
    protected IConstraint buildConstraint(AllEquals annotation) {
        return Constraints.allEquals(annotation.value());
    }

}
```

## 条件注解 @Condition

所有系统的内置注解都可以作为学习的例子。

### 定义注解

以 `@AlwaysTrueCondition` 为例，核心的部分在 `@Condition(AtAlwaysTrueCondition.class)`。

我们在 AtAlwaysTrueCondition 中实现具体的约束逻辑。

```java
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Condition(AtAlwaysTrueCondition.class)
public @interface AlwaysTrueCondition {
}
```

### 实现逻辑

推荐直接继承 `AbstractAnnotationCondition<A>`，实现对应的逻辑即可。

```java
public class AtAlwaysTrueCondition extends AbstractAnnotationCondition<AlwaysTrueCondition> {

    @Override
    protected ICondition buildCondition(AlwaysTrueCondition annotation) {
        return Conditions.alwaysTrue();
    }

}
```

# 开源地址

为了便于大家学习使用，目前校验框架已开源。

欢迎大家 fork+star，鼓励一下老马~

> [validator](https://github.com/houbb/validator)

# ROAD-MAP

- [ ] 优化提示信息

- [ ] springboot 整合

- [ ] i18N 對應的描述信息

- [ ] 更多约束条件

phone

idNo

银行卡