package com.ortudev.sportsResults.data.server

import com.ortudev.sportsResults.data.db.Circuit
import com.ortudev.sportsResults.data.db.Driver
import com.ortudev.sportsResults.data.domain.Season

interface RemoteDataSource {

    suspend fun getDrivers():List<Driver>
    suspend fun getCircuits():List<Circuit>
    suspend fun getRankingTeam(season: Season)
}