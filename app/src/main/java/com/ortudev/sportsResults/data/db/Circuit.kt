package com.ortudev.sportsResults.data.db

import com.ortudev.sportsResults.data.db.entities.CircuitEntity
import com.ortudev.sportsResults.data.domain.Circuit

data class Circuit(val id:Int, val name:String,val image:String,val location: Location, val length:String){
    fun toDomainCircuit():Circuit{
        return Circuit(name,image,location.toDomain(),length)
    }

    fun toRoomCircuit(locationId:Int):CircuitEntity{
        return CircuitEntity(id,name,image,locationId,length)
    }
}
