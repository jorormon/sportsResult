package com.ortudev.sportsResults.data.server.responses

import com.google.gson.annotations.SerializedName
import com.ortudev.sportsResults.data.db.Circuit
import com.ortudev.sportsResults.data.db.Location

data class CircuitResponse(
    @field:SerializedName("id")
    val id: Int,
    val name: String,
    @field:SerializedName("image")
    val image: String,
    val competition:CompetitionResponse,
    val length:String,
    val capacity:Int,
    val opened:Int,
    val owner:String?
){
    fun toCircuitDB(): Circuit {
        val (city,country) = competition.location
        val location = Location(city, country)
       return Circuit(id,name,image,location, length)
    }
}
