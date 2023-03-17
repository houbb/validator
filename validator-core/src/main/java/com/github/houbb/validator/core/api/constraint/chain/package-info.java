/**
 * 约束链
 * （1）一个是每一个都是独立的约束
 * （2）第二个是所有属性共享，但是约束实现不同。
 *
 * 为了统一，将二者可以标准为一种行为。
 *
 * 实际使用中其实是第一种居多。
 *
 * CASE 1：
 * 比如不同的注解，对应的 message() 也是不同的。
 * 可以理解为分别验证，二者完全独立。
 * 这种只简化了一个 value 的书写，可以考虑不进行支持。避免造成混乱。
 * <pre>
 *     ValidBs.on("value", notNullConstraint, sizeConstraint)
 * </pre>
 *
 * CASE 2：
 * 对同一个字段进行多次校验，但是对应的信息，除了 constraint 都是相同的。
 *
 * <pre>
 *     ValidBs.on("value", new AbstractConstraintChain(pipeline, context) {
 *         //...
 *     })
 * </pre>
 *
 * 这里的所有的约束条件，除却 constraint 其他都是认为可以共用的。
 * 这里要考虑和 when() message() groupCondition() 等各种信息的兼容。
 * @since 0.2.0
 */
package com.github.houbb.validator.core.api.constraint.chain;