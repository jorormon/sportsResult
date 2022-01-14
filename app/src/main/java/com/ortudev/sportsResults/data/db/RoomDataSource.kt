package com.ortudev.sportsResults.data.db

import com.ortudev.sportsResults.data.db.entities.CircuitEntity

class  RoomDataSource(db:F1Database):LocalDataSource {

    private val f1Dao = db.f1Dao()


    override suspend fun getDrivers():List<Driver> {
        TODO("Not yet implemented")
    }


    override suspend fun getCircuits():List<Circuit> {
       val circuits = mutableListOf<Circuit>()
       f1Dao.getCircuits().forEach { entity->
           val location = getLocationFromCircuit(entity)
           entity.toDB(location).also { circuits.add(it) }
       }
        return circuits
    }

    override suspend fun isCircuitsEmpty(): Boolean = f1Dao.circuitsCount() <= 0

    override suspend fun saveCircuits(list: List<Circuit>) {
        val listEntities: List<CircuitEntity> = list.map {
           val locationId =  it.location?.let { location ->
                saveLocation(location)
            }
            it.toRoomCircuit(locationId)
        }
        return f1Dao.insertCircuits(listEntities)
    }

    override suspend fun saveLocation(location: Location):Int {
        return f1Dao.insertLocation(location.toRoom()).toInt()
    }

    override suspend fun getCircuitById(circuitId: Int): Circuit? {
      return f1Dao.getCircuitById(circuitId)?.let { circuit->
         val location = getLocationFromCircuit(circuit)
         circuit.toDB(location)
      }
    }


    private suspend fun getLocationFromCircuit(circuit: CircuitEntity): Location? {
        return circuit.locationId?.let{ getLocation(it) }
    }

    override suspend fun getLocation(locationId: Int): Location? {
        return f1Dao.getLocation(locationId)?.toLocation()
    }

}