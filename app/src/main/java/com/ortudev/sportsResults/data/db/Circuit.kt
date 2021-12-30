package com.ortudev.sportsResults.data.db

import com.ortudev.sportsResults.data.db.entities.CircuitEntity
import com.ortudev.sportsResults.data.domain.Circuit

data class Circuit(val id:Int, val name:String,val length:String){
    fun toDomainCircuit():Circuit{
        return Circuit(name,length)
    }

    fun toRoomCircuit():CircuitEntity{
        return CircuitEntity(id,name,length)
    }
}
