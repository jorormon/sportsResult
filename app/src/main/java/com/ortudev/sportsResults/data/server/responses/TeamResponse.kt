package com.ortudev.sportsResults.data.server.responses

import com.google.gson.annotations.SerializedName

data class TeamResponse(
    val id:Int,
    val name:String,
    val logo:String,
    val president:String,
    val director:String,
    @field:SerializedName("technical_manager")
    val technicalManager:String,
    val engine:String,
    val tyres:String
){

}
