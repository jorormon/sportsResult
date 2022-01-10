package com.ortudev.sportsResults.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ortudev.sportsResults.data.db.Circuit
import com.ortudev.sportsResults.data.db.Location

@Entity(tableName = "circuit")
data class CircuitEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "image") val image: String,
    @ColumnInfo(name = "location") val locationId: Int,
    @ColumnInfo(name = "length") val length: String
)