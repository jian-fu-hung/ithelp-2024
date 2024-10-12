package com.jerryhong.ithelpsideproject.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "subscription")
data class SubscriptionEntity(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "product_name")
    val productName: String,
    @ColumnInfo(name = "price")
    val price: String,
    @ColumnInfo(name = "cycle")
    val cycle: String
)
