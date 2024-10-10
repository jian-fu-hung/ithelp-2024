package com.jerryhong.ithelpsideproject.core

import com.jerryhong.ithelpsideproject.data.SubscriptionViewData

class AppDataManagerMock : AppDataManager {
    override suspend fun getData(): List<SubscriptionViewData> {
        return listOf(
            SubscriptionViewData(id = "0", name = "Apple TV", price = "10", cycle = "月訂閱"),
            SubscriptionViewData(id = "1",name = "Youtube Premium", price = "100", cycle = "月訂閱"),
            SubscriptionViewData(id = "2",name = "Apple Music", price = "20", cycle = "月訂閱"),
            SubscriptionViewData(id = "3",name = "Netflix", price = "10", cycle = "月訂閱"),
            SubscriptionViewData(id = "4",name = "Discord", price = "10", cycle = "月訂閱")
        )
    }
}