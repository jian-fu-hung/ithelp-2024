package com.jerryhong.ithelpsideproject.ui.home

import com.jerryhong.ithelpsideproject.data.SubscriptionViewData

sealed class HomeState {
    data object Empty: HomeState()
    data object Loading: HomeState()
    data class Finish(val list: List<SubscriptionViewData>): HomeState()
    data class Error(val message: String): HomeState()
}