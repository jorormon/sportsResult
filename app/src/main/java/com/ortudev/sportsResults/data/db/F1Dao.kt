package com.ortudev.sportsResults.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ortudev.sportsResults.data.db.entities.CircuitEntity

@Dao
interface F1Dao {
    @Query("SELECT * FROM circuit")
    suspend fun getCircuits(): List<Circuit>

    @Query("SELECT COUNT(*) FROM circuit")
    suspend fun circuitsCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCircuits(list : List<CircuitEntity>)
}