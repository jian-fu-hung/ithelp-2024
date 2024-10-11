package com.jerryhong.ithelpsideproject.core

import com.jerryhong.ithelpsideproject.data.SubscriptionViewData

class AppDataManagerImpl : AppDataManager {

    var list = mutableListOf(
        SubscriptionViewData(id = "0", name = "Apple TV", price = "10", cycle = "月訂閱"),
        SubscriptionViewData(id = "1",name = "Youtube Premium", price = "10", cycle = "月訂閱"),
        SubscriptionViewData(id = "2",name = "Apple Music", price = "20", cycle = "月訂閱"),
        SubscriptionViewData(id = "3",name = "Netflix", price = "10", cycle = "月訂閱"),
        SubscriptionViewData(id = "4",name = "Discord", price = "10", cycle = "月訂閱")
    )

    override suspend fun getData(): List<SubscriptionViewData> {
        return list
    }

    override suspend fun setData(data: SubscriptionViewData) {
        list.add(data)
    }

    override suspend fun updateData(data: SubscriptionViewData) {
        list.find { it.id == data.id }?.let {
            list.remove(it)
            list.add(data)
        }
    }
}