package com.test.repeater

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    @VisibleForTesting
    var clickCount = 0

    fun handleFabClick() {
        clickCount += 1
    }
}