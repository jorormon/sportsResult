package com.ortudev.sportsResults.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ortudev.sportsResults.data.db.entities.CircuitEntity
import com.ortudev.sportsResults.data.db.entities.DriverEntity
import com.ortudev.sportsResults.data.db.entities.LocationEntity

@Database(
    entities = [CircuitEntity::class,DriverEntity::class,LocationEntity::class],
    version = 1,
    exportSchema = false
)
abstract class F1Database : RoomDatabase() {

  companion object {

    private const val DATABASE_NAME = "reader.db"

    private var instance: F1Database? = null

    private fun create(context: Context): F1Database =
        Room.databaseBuilder(context, F1Database::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()


    fun getInstance(context: Context): F1Database =
        (instance ?: create(context)).also { instance = it }
  }

  abstract fun f1Dao(): F1Dao

}