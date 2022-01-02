package com.ortudev.sportsResults.data.db

import com.ortudev.sportsResults.data.db.entities.LocationEntity
import com.ortudev.sportsResults.data.domain.Location

data class Location(val city:String?,val country:String?){
    fun toRoom(): LocationEntity {
        return LocationEntity(country?:"", city?:"")
    }

    fun toDomain():Location{
        return Location(city?:"",country?:"")
    }
}
