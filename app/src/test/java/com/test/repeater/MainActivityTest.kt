package com.test.repeater

import com.test.repeater.RepeatCountWatcher.countWatch
import com.test.repeater.RepeatCountWatcher.vm
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {
    //Add the rule
    @get:Rule
    val repeatRule = RepeatableRule()

    @Test
    @Repeatable(repeatCount = REPEAT_COUNT) //Add the annotation on the test method to repeat
    fun `test clickFabCount increments on click`() {
        vm.handleFabClick()
        countWatch += 1 // Increment the countWatch

        //Verify that the countWatch and vm.clickCount are in sync
        /**
         * When vm.handleFabClick is called, vm.clickCount increments to 1
         * We increment countWatch to 1 as well.
         * Verify that countWatch == vm.clickCount
         */
        assertEquals(countWatch, vm.clickCount)

    }

    companion object {
        const val REPEAT_COUNT = 10
    }
}
