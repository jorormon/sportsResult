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
           getLocationFromCircuit(entity)?.let { circuits.add(it) }
       }
        return circuits
    }

    override suspend fun isCircuitsEmpty(): Boolean = f1Dao.circuitsCount() <= 0


    override suspend fun saveCircuits(list: List<Circuit>) {
        val listEntities: List<CircuitEntity> = list.map {
            it.location?.let { location ->
                val locationId = saveLocation(location)
                it.toRoomCircuit(locationId)
            }!!
        }
        return f1Dao.insertCircuits(listEntities)
    }

    override suspend fun saveLocation(location: Location):Int {
        val locat =  f1Dao.insertLocation(location.toRoom())
        return locat.toInt()
    }

    override suspend fun getCircuitById(circuitId: Int): Circuit? {
      return f1Dao.getCircuitById(circuitId)?.let { circuit->
          getLocationFromCircuit(circuit)
      }
    }

    private suspend fun getLocationFromCircuit(circuit: CircuitEntity): Circuit {
       val location =  getLocation(circuit.locationId)
        return Circuit(circuit.id, circuit.name, circuit.image, location, circuit.length)

    }

    override suspend fun getLocation(locationId: Int): Location? {
        return f1Dao.getLocation(locationId)?.let{it.toLocation()}
    }


}