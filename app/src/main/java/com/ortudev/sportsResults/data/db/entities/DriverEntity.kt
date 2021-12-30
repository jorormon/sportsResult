package com.ortudev.sportsResults.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "driver")
data class DriverEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String
)