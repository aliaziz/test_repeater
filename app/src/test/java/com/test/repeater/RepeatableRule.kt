package com.test.repeater

import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

/**
 * Rule to add to the test class.
 * It will intercept each test method and check for the [Repeatable] annotation.
 * It will repeat that test method the [repeatCount] times otherwise let it run normally.
 *
 */
class RepeatableRule : TestRule {
    override fun apply(base: Statement, description: Description): Statement {
        val repeatAnnotation = description.getAnnotation(Repeatable::class.java)

        if(repeatAnnotation != null) {
            return RepeatableStatement(base, repeatAnnotation.repeatCount)
        }
        return base
    }

    private class RepeatableStatement(val statement: Statement, val repeatCount: Int) : Statement() {
        override fun evaluate() {
            for (i in 0 until repeatCount) {
                statement.evaluate()
            }
        }
    }
}