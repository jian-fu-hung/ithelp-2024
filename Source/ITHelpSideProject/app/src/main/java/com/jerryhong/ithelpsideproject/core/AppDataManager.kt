package com.jerryhong.ithelpsideproject.core

import com.jerryhong.ithelpsideproject.data.SubscriptionViewData

interface AppDataManager {

    suspend fun getData(): List<SubscriptionViewData>
}