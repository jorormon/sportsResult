package com.ortudev.sportsResults.data.db

interface LocalDataSource {

    suspend fun getDrivers():List<Driver>
    suspend fun getCircuits():List<Circuit>
    suspend fun isCircuitsEmpty():Boolean
    suspend fun saveCircuits(list: List<Circuit>)
}