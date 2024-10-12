package com.jerryhong.ithelpsideproject.core.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jerryhong.ithelpsideproject.data.db.SubscriptionDao
import com.jerryhong.ithelpsideproject.data.db.SubscriptionEntity

@Database(entities = [SubscriptionEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun subscriptionDao(): SubscriptionDao
}