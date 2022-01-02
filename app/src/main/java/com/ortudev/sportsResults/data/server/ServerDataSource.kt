package com.ortudev.sportsResults.data.server

import com.ortudev.sportsResults.data.db.Circuit
import com.ortudev.sportsResults.data.db.Driver
import com.ortudev.sportsResults.data.server.api.F1Api
import com.ortudev.sportsResults.data.server.responses.CircuitResponse

class ServerDataSource(private val f1Api: F1Api):RemoteDataSource {
    override suspend fun getDrivers(): List<Driver> {
        TODO("Not yet implemented")
    }

    override suspend fun getCircuits(): List<Circuit> {
       return f1Api.getCircuits().response.map(CircuitResponse::toCircuitDB)
    }
}