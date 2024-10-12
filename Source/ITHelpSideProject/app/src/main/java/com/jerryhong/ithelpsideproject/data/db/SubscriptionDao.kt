package com.jerryhong.ithelpsideproject.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface SubscriptionDao {
    @Query("SELECT * FROM subscription")
    suspend fun getAll(): List<SubscriptionEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setData(item: SubscriptionEntity)

    @Update
    suspend fun updateData(item: SubscriptionEntity)
}