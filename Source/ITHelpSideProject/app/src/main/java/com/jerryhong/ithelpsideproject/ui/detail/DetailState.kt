package com.jerryhong.ithelpsideproject.ui.detail

import com.jerryhong.ithelpsideproject.data.SubscriptionViewData

sealed class DetailState {
    data object Empty: DetailState()
    data object Create: DetailState()
    data object Error: DetailState()
    data class Edit(val data: SubscriptionViewData): DetailState()
}