# 项目介绍

java 开发中，参数校验是非常常见的需求。

但是 hibernate-validator 在使用过程中，依然会存在一些问题。

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.houbb/validator/badge.svg)](http://mvnrepository.com/artifact/com.github.houbb/validator)
[![Build Status](https://www.travis-ci.org/houbb/validator.svg?branch=master)](https://www.travis-ci.org/houbb/validator?branch=master)
[![Coverage Status](https://coveralls.io/repos/github/houbb/validator/badge.svg?branch=master)](https://coveralls.io/github/houbb/validator?branch=master)

## 变更日志

> [变更日志](https://github.com/houbb/validator/blob/master/CHANGELOG.md)

## 特性

- 支持 fluent-validation

- 支持 jsr-303 注解

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
    <version>0.3.0</version>
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

ValidHelper 作为统一封装的工具类，提供了常见的方法。

方法列表：

| 序号  | 方法                            | 返回值     | 说明                                     |
|:----|:------------------------------|:--------|:---------------------------------------|
| 1   | failOver(final Object object) | IResult | 全部验证后返回                                |
| 2   | failFast(final Object object) | IResult | 快速验证后返回                                |
| 3   | failOverThrow(final Object object) | void    | 全部验证后返回-未通过抛出 ValidRuntimeException 异常 |
| 4   | failFastThrow(final Object object) | void    | 快速验证后返回-未通过抛出 ValidRuntimeException 异常 |

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

## 内置注解

内置注解如下：

| 序号  | 注解                                | value()                 | 说明                |
|:----|:-----------------------------------|:------------------------|:------------------|
| 1   | `@AllEquals`                       | `String[]`              | 当前字段及其指定的字段 全部相等  |
| 2   | `@EnumRanges`                       | `Class<? extends Enum>` | 当前字段必须在枚举值指定的范围内 |
| 3   | `@HasNotNull`                       | `String[]`              | 当前字段及其指定的字段 至少有一个不为 null |
| 4   | `@Ranges`                       | `String[]`              | 当前字段必须在指定的范围内 |

## JSR-303 + hibernate-validator 注解支持

| 序号  | 注解             | 说明            |
|:----|:---------------|:--------------|
| 1   | `@AssertTrue`  | 为 true 约束条件   |
| 2   | `@AssertFalse` | 为 false 约束条件  |
| 3   | `@Null`        | 为 null 约束条件   |
| 4   | `@NotNull`     | 不为 null 约束条件  |
| 5   | `@Past`        | 是否在当前时间之前约束条件 |
| 6   | `@Future`      | 是否在当前时间之后约束条件 |
| 7   | `@Pattern`     | 正则表达式约束条件     |
| 8   | `@Size`        | 在指定范围内的约束条件   |
| 9   | `@Digits`      | 数字位数的约束条件     |
| 10  | `@DecimalMax`  | 最大数字的约束条件     |
| 11  | `@DecimalMin`  | 最小数字的约束条件     |
| 12  | `@Min`         | 最小的约束条件       |
| 13  | `@Max`         | 最大的约束条件       |
| 13  | `@NotBlank`    | 不能为空格的约束条件    |
| 14  | `@NotEmpty`    | 不能为空的约束条件     |
| 15  | `@Length`    | 长度的约束条件       |
| 16  | `@CNPJ`    | CNPJ 约束条件     |
| 17  | `@CPF`    | CPF 约束条件      |
| 18  | `@URL`    | URL 约束条件      |
| 18  | `@Email`    | Email 约束条件    |
| 19  | `@UniqueElements`    | 元素唯一约束条件      |
| 20  | `@Range`    | 指定范围元素约束条件    |

# 开源地址

> [validator](https://github.com/houbb/validator)

# ROAD-MAP

- [ ] springboot 整合

phone

idNo

银行卡

- [ ] i18N 對應的描述信息
