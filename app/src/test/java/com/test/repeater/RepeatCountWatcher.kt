package com.test.repeater

/**
 * For testing purposes,
 * This tracks the countWatch increment.
 * It also holds the [MainViewModel] object to avoid it from being recreated by the test class
 */
object RepeatCountWatcher {
    var countWatch = 0
    val vm = MainViewModel()
}