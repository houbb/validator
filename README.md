# 项目介绍

java 开发中，参数校验是非常常见的需求。

但是 hibernate-validator 在使用过程中，依然会存在一些问题。

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.houbb/validator/badge.svg)](http://mvnrepository.com/artifact/com.github.houbb/validator)
[![Build Status](https://www.travis-ci.org/houbb/validator.svg?branch=master)](https://www.travis-ci.org/houbb/validator?branch=master)
[![Coverage Status](https://coveralls.io/repos/github/houbb/validator/badge.svg?branch=master)](https://coveralls.io/github/houbb/validator?branch=master)

## 变更日志

> [变更日志](doc/CHANGELOG.md)

## 特性

- 支持 fluent-validation

- 支持 jsr-303 注解

- 支持 i18n

- 支持用户自定义策略

- 支持用户自定义注解

- 支持针对属性的校验

- 支持过程式编程与注解式编程

- 支持指定校验生效的条件

## 开源地址

> [validator](https://github.com/houbb/validator)

# 创作目的

## hibernate-validator 无法满足的场景

如今 java 最流行的 hibernate-validator 框架，但是有些场景是无法满足的。

比如：

1. 验证新密码和确认密码是否相同。(同一对象下的不同属性之间关系)

2. 当一个属性值满足某个条件时，才进行其他值的参数校验。

3. 多个属性值，至少有一个不能为 null

其实，在对于多个字段的关联关系处理时，hibernate-validator 就会比较弱。

本项目结合原有的优点，进行这一点的功能强化。

## validation-api 过于复杂

validation-api 提供了丰富的特性定义，也同时带来了一个问题。

实现起来，特别复杂。

然而我们实际使用中，常常不需要这么复杂的实现。

validator-api 提供了一套简化很多的 api，便于用户自行实现。

## 自定义缺乏灵活性

hibernate-validator 在使用中，自定义约束实现是基于注解的，针对单个属性校验不够灵活。

本项目中，将属性校验约束和注解约束区分开，便于复用和拓展。

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
    <artifactId>validator-api</artifactId>
    <version>0.1.0</version>
</dependency>
```


# ROAD-MAP

- [ ] springboot 整合

phone

idNo

银行卡

- [ ] i18N 對應的描述信息
