package com.ortudev.sportsResults.data.server.responses

import com.google.gson.annotations.SerializedName
import com.ortudev.sportsResults.data.db.Circuit
import com.ortudev.sportsResults.data.db.Location

data class DriverResponse(
    @field:SerializedName("id")
    val id: Int,
    val name: String,
    @field:SerializedName("image")
    val image: String,
    val nationality:String,
    val birthdate:String
)
