package com.ortudev.sportsResults.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ortudev.sportsResults.data.db.entities.CircuitEntity
import com.ortudev.sportsResults.data.db.entities.LocationEntity

@Dao
interface F1Dao {
    @Query("SELECT * FROM circuit")
    suspend fun getCircuits(): List<CircuitEntity>

    @Query("SELECT * FROM circuit where id=:circuitId")
    suspend fun getCircuitById(circuitId:Int): CircuitEntity?

    @Query("SELECT * FROM location where id=:locationId")
    suspend fun getLocation(locationId:Int): LocationEntity?

    @Query("SELECT COUNT(*) FROM circuit")
    suspend fun circuitsCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCircuits(list : List<CircuitEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLocation(location : LocationEntity):Long
}