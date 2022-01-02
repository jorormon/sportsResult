package com.ortudev.sportsResults.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ortudev.sportsResults.data.db.Location

@Entity(tableName = "location")
data class LocationEntity(
    @ColumnInfo(name = "country") val country: String,
    @ColumnInfo(name = "city") val city: String,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
){
    fun toLocation():Location{
        return Location(city, country)
    }
}
