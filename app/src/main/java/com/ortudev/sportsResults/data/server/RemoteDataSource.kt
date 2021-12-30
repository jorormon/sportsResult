package com.ortudev.sportsResults.data.server

import com.ortudev.sportsResults.data.db.Circuit
import com.ortudev.sportsResults.data.db.Driver

interface RemoteDataSource {

    suspend fun getDrivers():List<Driver>
    suspend fun getCircuits():List<Circuit>
}