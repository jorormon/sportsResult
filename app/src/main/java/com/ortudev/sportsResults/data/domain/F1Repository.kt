package com.ortudev.sportsResults.data.domain

import com.ortudev.sportsResults.data.db.Circuit
import com.ortudev.sportsResults.data.db.Driver
import com.ortudev.sportsResults.data.db.LocalDataSource
import com.ortudev.sportsResults.data.server.RemoteDataSource

class F1Repository(private val localDataSource: LocalDataSource,
                   private val remoteDataSource: RemoteDataSource) {

    suspend fun getDrivers(): List<Driver> {
      return localDataSource.getDrivers()
    }

    suspend fun getCircuits(): List<Circuit> {
        if(localDataSource.isCircuitsEmpty()){
            val circuits = remoteDataSource.getCircuits()
            localDataSource.saveCircuits(circuits)
        }
        return localDataSource.getCircuits()
    }

}