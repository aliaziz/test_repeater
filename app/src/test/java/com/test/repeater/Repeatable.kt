package com.test.repeater

/**
 * Annotation to add to a test that you'd want to repeat
 * @param repeatCount Count of how many times you'd want this test to be repeat before moving onto the next test
 */

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class Repeatable(val repeatCount: Int = 1)