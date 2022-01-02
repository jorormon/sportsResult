package com.ortudev.sportsResults.data.db

import com.ortudev.sportsResults.data.db.entities.CircuitEntity
import com.ortudev.sportsResults.data.db.Location

class  RoomDataSource(db:F1Database):LocalDataSource {

    private val f1Dao = db.f1Dao()
    override suspend fun getDrivers():List<Driver> {
        TODO("Not yet implemented")
    }

    override suspend fun getCircuits():List<Circuit> {
       val circuits = mutableListOf<Circuit>()
       f1Dao.getCircuits().forEach { entity->
          val location = getLocation(entity.locationId)
          entity.apply { circuits.add(Circuit(id, name, image, location, length)) }
       }
        return circuits
    }

    override suspend fun isCircuitsEmpty(): Boolean = f1Dao.circuitsCount() <= 0


    override suspend fun saveCircuits(list: List<Circuit>) {
        val listEntities: List<CircuitEntity> = list.map {
            val locationId= saveLocation(it.location)
            it.toRoomCircuit(locationId)
        }
        return f1Dao.insertCircuits(listEntities)
    }

    override suspend fun saveLocation(location: Location):Int {
        val locat =  f1Dao.insertLocation(location.toRoom())
        return locat.toInt()
    }

     suspend fun getLocationByCircuit(circuitId: Int) {
     //  return f1Dao.getLocationByCircuit(circuitId).toLocation()
    }

    override suspend fun getLocation(locationId: Int): Location {
        return f1Dao.getLocation(locationId).toLocation()
    }


}