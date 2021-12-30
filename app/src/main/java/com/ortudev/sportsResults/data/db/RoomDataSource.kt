package com.ortudev.sportsResults.data.db

class RoomDataSource(db:F1Database):LocalDataSource {

    private val f1Dao = db.f1Dao()
    override suspend fun getDrivers():List<Driver> {
        TODO("Not yet implemented")
    }

    override suspend fun getCircuits():List<Circuit> {
       return f1Dao.getCircuits()
    }

    override suspend fun isCircuitsEmpty(): Boolean = f1Dao.circuitsCount() <= 0


    override suspend fun saveCircuits(list: List<Circuit>) {
        return f1Dao.insertCircuits(list.map(Circuit::toRoomCircuit))
    }


}