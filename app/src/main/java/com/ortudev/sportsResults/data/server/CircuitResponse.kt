package com.ortudev.sportsResults.data.server

import com.google.gson.annotations.SerializedName
import com.ortudev.sportsResults.data.db.Circuit

data class CircuitResponse(
    @field:SerializedName("id")
    val id: Int,
    val name: String,
    @field:SerializedName("image")
    val image: String,
    val length:String,
    val capacity:Int,
    val opened:Int,
    val owner:String?
){
    fun toCircuitDB(): Circuit {
       return Circuit(id,name, length)
    }
}
