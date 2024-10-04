package com.jerryhong.ithelpday19

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {

    val name: StateFlow<String>
        get() = mName
    val text: StateFlow<String>
        get() = mText

    private var mName = MutableStateFlow("")
    private var mText = MutableStateFlow("")

    fun login() {
        mName.value = mText.value
    }

    fun setText(text: String) {
        mText.value = text
    }
}