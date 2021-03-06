package com.ortudev.sportsResults.data.db

interface LocalDataSource {

    suspend fun getDrivers():List<Driver>
    suspend fun getCircuitById(circuitId: Int):Circuit?
    suspend fun getCircuits():List<Circuit>
    suspend fun isCircuitsEmpty():Boolean
    suspend fun saveCircuits(list: List<Circuit>)
    suspend fun saveLocation(location: Location):Int
    suspend fun getLocation(locationId: Int):Location?
}