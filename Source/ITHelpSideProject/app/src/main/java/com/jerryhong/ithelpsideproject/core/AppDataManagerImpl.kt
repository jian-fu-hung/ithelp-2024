package com.jerryhong.ithelpsideproject.core

import android.app.Application
import androidx.room.Room
import com.jerryhong.ithelpsideproject.core.db.AppDatabase
import com.jerryhong.ithelpsideproject.data.SubscriptionViewData
import com.jerryhong.ithelpsideproject.data.db.SubscriptionEntity

class AppDataManagerImpl(context: Application) : AppDataManager {

    var list = mutableListOf<SubscriptionViewData>()

    private var dbManager: AppDatabase = Room.databaseBuilder(context, AppDatabase::class.java, "database.db").build()

    override suspend fun getData(): List<SubscriptionViewData> {
        val dataList = dbManager.subscriptionDao().getAll()
        list = dataList.map {
            SubscriptionViewData(
                id = it.id.toString(),
                name = it.productName,
                price = it.price,
                cycle = it.cycle
            )
        }.toMutableList()
        return list
    }

    override suspend fun setData(data: SubscriptionViewData) {
        val item = SubscriptionEntity(
            id = list.size,
            productName = data.name,
            price = data.price,
            cycle = data.cycle
        )

        dbManager.subscriptionDao().setData(item)
    }

    override suspend fun updateData(data: SubscriptionViewData) {
        list.find { it.id == data.id }?.let {
            val item = SubscriptionEntity(
                id = it.id.toInt(),
                productName = data.name,
                price = data.price,
                cycle = data.cycle
            )
            dbManager.subscriptionDao().updateData(item)
        }
    }
}